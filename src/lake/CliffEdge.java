package lake;

import Presentation.Researcher;
import utilities.Position;

//Specific Hazard: CliffEdge
public class CliffEdge extends Hazard {
 public CliffEdge(Position position) {
     super(position);
 }

 @Override
 public void interact(Researcher researcher) {
     System.out.println("Researcher avoided falling off the cliff at position " + getPosition().getX() + ", " + getPosition().getY());
 }
}