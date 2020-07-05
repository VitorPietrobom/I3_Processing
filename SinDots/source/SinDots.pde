int dotCount = 1000;
Dot dots[] = new Dot[dotCount];
float dotsY[] = new float[dotCount];


void setup() {
  size(1200,800);
  for(int i = 0 ; i < dots.length ; i++){
    dots[i] = new Dot();
  
  }

}

void draw() {
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
