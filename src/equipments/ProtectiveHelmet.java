package equipments;

//Specific Equipment: Protective Helmet
public class ProtectiveHelmet extends Equipment {
 public ProtectiveHelmet() {
     super("ph");
 }

 @Override
 public void use() {
     System.out.println("Using Protective Helmet.");
 }
}
