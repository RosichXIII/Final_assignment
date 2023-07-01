package Animals;

public class Beast extends Animal {
    protected String type = "Beast";

    public Beast(String name, String birthDate) {
        super(name, birthDate);
    }

    public String getType() {
        return type;
    }
}