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

public class PurpleRain extends PApplet {

int DropsQuantity = 200;
Drop drops[] = new Drop[DropsQuantity];


public void setup() {
  
  for (int i = 0; i<drops.length;i++){
    drops[i] = new Drop();
  }

}

public void draw() {
  background(41,41,193);
  for (int i = 0; i<drops.length;i++){
    drops[i].show();
    drops[i].fall();
  }
  

}
class Drop {
  float x = random(-5, width+5);
  float y = random(-200, height);
  float z = random(0,20);
  float size = map(mouseY,0,height,3,20) + map(z,0,20,0,5);
  float speed = map(mouseX,0,width,0,32);
  float gravity = 0.05f;
  int colorR = (int) map(y,0,height,148,41);
  int colorG = (int) map(y,0,height,24,41);
  int colorB = (int) map(y,0,height,198,193);
  
  
  public void fall() {
    speed = map(mouseX,0,width,0,32);
    size = map(mouseY,0,height,3,20) + map(z,0,20,0,5);
    y += speed ;
    speed = speed + gravity;
    colorR = (int) map(y,0,height,148,41);
    colorG = (int) map(y,0,height,24,41);
    colorB = (int) map(y,0,height,198,193);
    
    
    if (y>height+10){
      y = random(-200, -100);
      x = random(-5, width+5);
      z = random(0,20);
      speed = map(z,0,20,6,12);
      size = map(z,0,20,3,8);
    }
    
  }
  
  public void show() {
    
    stroke(colorR,colorG,colorB);
    fill(colorR,colorG,colorB);
    triangle(x,y-4*size,x-size,y,x+size,y);
    circle(x,y,2*size);
  }
  
}
  public void settings() {  size(1920,1024); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PurpleRain" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
