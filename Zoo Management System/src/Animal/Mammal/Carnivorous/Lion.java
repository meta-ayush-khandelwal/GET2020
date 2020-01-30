package Animal.Mammal.Carnivorous;

public class Lion extends CarnivorousMammal {
    public Lion(String uniqueName, double age, double weight) {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Lion";
    }

    public String getSound() {
        return ("Roars");
    }
}
