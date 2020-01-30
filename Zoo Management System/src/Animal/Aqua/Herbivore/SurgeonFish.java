package Animal.Aqua.Herbivore;

public class SurgeonFish extends HerbivoreAqua
{
    public SurgeonFish(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "SurgeonFish";
    }
    
    public String getSound()
    {
        return ("Drumming");
    }
}