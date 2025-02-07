package lake;

import Presentation.Researcher;
import utilities.Position;

//Specific Hazard: HoleInIce
public class HoleInIce extends Hazard {
 public HoleInIce(Position position) {
     super(position);
 }

 @Override
 public void interact(Researcher researcher) {
     System.out.println("Researcher fell into a hole in the ice at position " + getPosition().getX() + ", " + getPosition().getY());
 }
}