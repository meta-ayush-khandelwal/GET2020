package Animal.Aqua.Omnivorous;

public class AngelFish extends OmnivorousAqua 
{	
    public AngelFish(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "AngelFish";
    }
    
    public String getSound()
    {
        return ("Drumming");
    }
}