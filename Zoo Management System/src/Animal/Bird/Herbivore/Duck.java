package Animal.Bird.Herbivore;

public class Duck extends HerbivoreBird 
{	
    public Duck(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Duck";
    }
    
    public String getSound()
    {
        return ("Quack");
    }
}