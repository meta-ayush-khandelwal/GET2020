package Animal.Mammal.Herbivore;

public class Deer extends HerbivorousMammal 
{
    public Deer(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Deer";
    }
 
    public String getSound()
    {
        return ("Bell");
    }
}