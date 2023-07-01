package Animals;

public class Pet extends Animal {
    protected String type = "Pet";

    public Pet(String name, String birthDate) {
        super(name, birthDate);
    }

    public String getType() {
        return type;
    }
}