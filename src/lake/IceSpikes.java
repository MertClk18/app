package lake;

import Presentation.Researcher;
import utilities.Position;

//Specific Hazard: IceSpikes
public class IceSpikes extends Hazard {
 public IceSpikes(Position position) {
     super(position);
 }

 @Override
 public void interact(Researcher researcher) {
     System.out.println("Researcher hit ice spikes at position " + getPosition().getX() + ", " + getPosition().getY());
 }
}