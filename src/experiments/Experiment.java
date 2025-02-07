package experiments;

import utilities.Position;

//Experiment Class
public abstract class Experiment {
 private Position position;

 public Experiment(Position position) {
     this.position = position;
 }

 public Position getPosition() {
     return position;
 }

 public abstract void perform();

 public abstract void report();
}