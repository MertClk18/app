package equipments;

import java.util.Random;

import experiments.Experiment;
import utilities.Position;

//Specific Experiment: TemperatureMeasurement
class TemperatureMeasurement extends Experiment {
 private int temperature;

 public TemperatureMeasurement(Position position) {
     super(position);
 }

 public int getTemperature() {
     return temperature;
 }

 @Override
 public void perform() {
     this.temperature = new Random().nextInt(31) - 30;
     System.out.println("Temperature measured: " + temperature + "°C at position " + getPosition().getX() + ", " + getPosition().getY());
 }

@Override
public void report() {
	// TODO Auto-generated method stub
	
}
}