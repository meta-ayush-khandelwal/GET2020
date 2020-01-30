package Animal.Mammal.Herbivore;

public class Elephant extends HerbivorousMammal
{
    public Elephant(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Elephant";
    }
 
    public String getSound()
    {
        return ("Trumpet,Roar");
    }
}
