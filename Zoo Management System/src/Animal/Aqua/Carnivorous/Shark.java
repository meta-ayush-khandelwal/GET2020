package Animal.Aqua.Carnivorous;

public class Shark extends CarnivorousAqua
{
    public Shark(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Shark";
    }
    
    public String getSound()
    {
        return ("Do not have organs to produce sound");
    }
}