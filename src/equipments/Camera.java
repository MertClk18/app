package equipments;

//Specific Equipment: Camera
public class Camera extends Equipment {
 public Camera() {
     super("cm");
 }

 @Override
 public void use() {
     System.out.println("Using Camera.");
 }
}
