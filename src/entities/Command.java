package entities;

public record Command(String name, String description) {
    public Command(String name){
        this(name, null);
    }

    @Override
    public String toString() {
        if (description == null) return name;
        else return "Command{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
