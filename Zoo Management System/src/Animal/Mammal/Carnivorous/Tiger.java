package Animal.Mammal.Carnivorous;

public class Tiger extends CarnivorousMammal 
{
    public Tiger(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Tiger";
    }

    public String getSound() 
    {
        return "Roars";
    }
}