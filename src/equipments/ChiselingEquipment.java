package equipments;

//Specific Equipment: Chiseling Equipment
public class ChiselingEquipment extends Equipment {
 public ChiselingEquipment() {
     super("ch");
 }

 @Override
 public void use() {
     System.out.println("Using Chiseling Equipment.");
 }
}
