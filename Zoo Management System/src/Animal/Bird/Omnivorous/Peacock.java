package Animal.Bird.Omnivorous;

public class Peacock extends OmnivorousBird 
{
    public Peacock(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Peacock";
    }

    public String getSound()
    {
        return ("Scream");
    }
}