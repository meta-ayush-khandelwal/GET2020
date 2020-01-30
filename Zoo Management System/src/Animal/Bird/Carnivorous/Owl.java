package Animal.Bird.Carnivorous;

public class Owl extends CarnivorousBird 
{	
    public Owl(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Owl";
    }

    public String getSound()
    {
        return ("hoot");
    }
}