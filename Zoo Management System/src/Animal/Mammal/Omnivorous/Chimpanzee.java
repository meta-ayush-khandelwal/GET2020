package Animal.Mammal.Omnivorous;

public class Chimpanzee extends OmnivorousMammal 
{
    public Chimpanzee(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Chimpanzee";
    }
    
    public String getSound()
    {
        return ("Hoo");
    }
}