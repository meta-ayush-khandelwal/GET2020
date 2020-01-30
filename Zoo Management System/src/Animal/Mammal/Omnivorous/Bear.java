package Animal.Mammal.Omnivorous;

public class Bear extends OmnivorousMammal 
{
    public Bear(String uniqueName,double age,double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Bear";
    }

    public String getSound()
    {
        return ("Growls");
    }
}