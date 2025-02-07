package equipments;

// Abstract Class for Equipment
public abstract class Equipment {
    private String type;

    public Equipment(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void use();
    

    public void report() {
        System.out.println("Equipment Type: " + type);
    }
}

