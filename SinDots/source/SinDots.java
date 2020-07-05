import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SinDots extends PApplet {

int dotCount = 1000;
Dot dots[] = new Dot[dotCount];
float dotsY[] = new float[dotCount];


public void setup() {
  
  for(int i = 0 ; i < dots.length ; i++){
    dots[i] = new Dot();
  
  }

}

public void draw() {
  background(255,255,255);
  for(int i = 0 ; i < dots.length ; i++){
    dots[i].show();
    
    if (mousePressed == true){
      dots[i].sinMove(dotsY[i]);
    }
    else{
      dots[i].move();
      for(int x = 0 ; x < dots.length ; x++){
        dotsY[x] = dots[x].y;
  
      }
    }
  
  }

}
class Dot {
  float x = random(0,width);
  float y = random(-500,height);
  float z = random(0,20);
  float addY = 0.1f;
  int colorR = (int) random(0,255);
  int colorG = (int) random(0,255);
  int colorB = (int) random(0,255);
  int circleRadius = (int) map(z,0,20,4,30);
  int velocity = (int) map(z,0,20,4,30);
  
  public void show (){
    fill(colorR,colorG,colorB);
    noStroke();
    circle(x,y,circleRadius);
    
  
  }
  
  public void sinMove(float initY){
    if (x>width+circleRadius/2){
      x = -circleRadius/2;
    }
    else if (x<-circleRadius/2){
      x = width+circleRadius/2;
    }
    
    x += map(mouseX,0,width,-velocity,velocity);
    y = initY + map(sin(addY),-1,1,0,100);
    addY += 0.2f;
    
  
  }
  
  public void move(){
    if (x>width+circleRadius/2){
      x = -circleRadius/2;
    }
    else if (x<-circleRadius/2){
      x = width+circleRadius/2;
    }
    if (y>height+500+circleRadius/2){
      y = -circleRadius/2;
    }
    else if (y<-500-circleRadius/2){
      y = height+circleRadius/2;
    }
    
    x += map(mouseX,0,width,-velocity,velocity);
    y += map(mouseY,0,height,-velocity,velocity);
    addY += 0.2f;
    
  
  }


}
  public void settings() {  size(1200,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SinDots" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
