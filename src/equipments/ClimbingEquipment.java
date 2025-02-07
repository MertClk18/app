package equipments;

//Specific Equipment: Climbing Equipment
public class ClimbingEquipment extends Equipment {
 public ClimbingEquipment() {
     super("cl");
 }

 @Override
 public void use() {
     System.out.println("Using Climbing Equipment.");
 }
}