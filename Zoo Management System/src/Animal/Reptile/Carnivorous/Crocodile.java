package Animal.Reptile.Carnivorous;

public class Crocodile extends CarnivorousReptile
{
    public Crocodile(String uniqueName,double age,double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Crocodile";
    }
 
    public String getSound()
    {
        return ("Grunts");
    }
}