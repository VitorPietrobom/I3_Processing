class Drop {
  float x = random(-5, width+5);
  float y = random(-200, height);
  float z = random(0,20);
  float size = map(mouseY,0,height,3,20) + map(z,0,20,0,5);
  float speed = map(mouseX,0,width,0,32);
  float gravity = 0.05;
  int colorR = (int) map(y,0,height,148,41);
  int colorG = (int) map(y,0,height,24,41);
  int colorB = (int) map(y,0,height,198,193);
  
  
  void fall() {
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
  
  void show() {
    
    stroke(colorR,colorG,colorB);
    fill(colorR,colorG,colorB);
    triangle(x,y-4*size,x-size,y,x+size,y);
    circle(x,y,2*size);
  }
  
}
