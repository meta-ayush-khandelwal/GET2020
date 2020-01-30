package Animal.Reptile.Carnivorous;

public class Snake extends CarnivorousReptile 
{
    public Snake(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Snake";
    }

    public String getSound()
    {
        return ("Hiss");
    }
}