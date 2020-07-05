int DropsQuantity = 200;
Drop drops[] = new Drop[DropsQuantity];


void setup() {
  size(1920,1024);
  for (int i = 0; i<drops.length;i++){
    drops[i] = new Drop();
  }

}

void draw() {
  background(41,41,193);
  for (int i = 0; i<drops.length;i++){
    drops[i].show();
    drops[i].fall();
  }
  

}
