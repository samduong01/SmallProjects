#include <Servo.h>
#include <LiquidCrystal.h>

LiquidCrystal lcd(12,11,5,4,3,2);
LiquidCrystal lcd2(12,11,5,4,3,2);
LiquidCrystal lcd3(12,11,5,4,3,2);
LiquidCrystal colon(12,11,5,4,3,2);

const int trigPin = 6;
const int echoPin = 7;
// defines variables
long duration;
int distance;



bool water = false;
int a[] = {5,0,0};
Servo servo1;
void setup() {
  // put your setup code here, to run once:
  servo1.attach(9);
  servo1.write(180);
  lcd.begin(1,2);
  colon.begin(1,2);
  lcd2.begin(1,2);
  lcd3.begin(1,2);

pinMode(trigPin, OUTPUT); // Sets the trigPin as an Output
pinMode(echoPin, INPUT); // Sets the echoPin as an Input
  Serial.begin(9600);
  
}

void loop()
{
  distanceSensor();

  if(distance<8){
    water = true;
  }

  if(a[0] == 0 && a[1] == 0 && a[2] == 0){
    servo1.write(90);
    water = false;
  }

  if(distance>8 && water == false){
    a[0] = 5;
    a[1] = 0;
    a[2] = 0;
  }

 

  if(water){
    timer();
  }else{
    lcd.print(" YOUR 5 MINUTE SHOWER IS UP ");
    lcd.scrollDisplayLeft();
    delay(500);
  }
  
}

void distanceSensor(){
  digitalWrite(trigPin, LOW);
    delayMicroseconds(2);
  // Sets the trigPin on HIGH state for 10 micro seconds
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  // Reads the echoPin, returns the sound wave travel time in microseconds
  duration = pulseIn(echoPin, HIGH);
  // Calculating the distance
  distance= duration*0.034/2;
    // Prints the distance on the Serial Monitor
  Serial.print("Distance: ");
  Serial.println(distance);
}

void timer(){
  if(a[1] == 0 && a[2] == 0){
      a[0] = a[0]-1;
        a[1] = 5;
        a[2] = 9;
    }else if (a[2] == 0){
       a[1] = a[1]-1;
       a[2] = 9;
    }else{
       a[2] = a[2]-1;
    }

    lcd.print(a[0]);
    colon.print(":");

    lcd2.print(a[1]);
    lcd3.print(a[2]);

    delay(100);
    colon.clear();
    lcd2.clear();
    lcd.clear();
    lcd3.clear();
    
  if(a[0] == 0 && a[1] == 0 && a[2] == 0){
    servo1.write(90);
    water = false;
    return;
  }
}
