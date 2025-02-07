package utilities;

import lake.Hazard;

//Square Class
class Square {
 private boolean hasWall;
 private Hazard hazard;

 public Square(boolean hasWall) {
     this.hasWall = hasWall;
 }

 public boolean hasWall() {
     return hasWall;
 }

 public void setHazard(Hazard hazard) {
     this.hazard = hazard;
 }

 public Hazard getHazard() {
     return hazard;
 }
}