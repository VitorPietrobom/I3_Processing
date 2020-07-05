class Dot {
  float x = random(0,width);
  float y = random(-500,height);
  float z = random(0,20);
  float addY = 0.1;
  int colorR = (int) random(0,255);
  int colorG = (int) random(0,255);
  int colorB = (int) random(0,255);
  int circleRadius = (int) map(z,0,20,4,30);
  int velocity = (int) map(z,0,20,4,30);
  
  void show (){
    fill(colorR,colorG,colorB);
    noStroke();
    circle(x,y,circleRadius);
    
  
  }
  
  void sinMove(float initY){
    if (x>width+circleRadius/2){
      x = -circleRadius/2;
    }
    else if (x<-circleRadius/2){
      x = width+circleRadius/2;
    }
    
    x += map(mouseX,0,width,-velocity,velocity);
    y = initY + map(sin(addY),-1,1,0,100);
    addY += 0.2;
    
  
  }
  
  void move(){
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
    addY += 0.2;
    
  
  }


}
