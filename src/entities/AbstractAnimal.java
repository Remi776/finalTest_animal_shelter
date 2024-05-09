package entities;

public abstract class AbstractAnimal {
    private static int counter;
    private final int id = ++counter;
    private AnimalType animalType;

    public AbstractAnimal() {
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public int getId() {
        return id;
    }

    public void eat(){
        System.out.println("The animal was fed.");
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", animalType: " + animalType;
    }
}
