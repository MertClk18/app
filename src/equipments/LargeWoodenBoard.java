package equipments;

//Specific Equipment: Large Wooden Board
public class LargeWoodenBoard extends Equipment {
 public LargeWoodenBoard() {
     super("wb");
 }

 @Override
 public void use() {
     System.out.println("Using Large Wooden Board.");
 }
}