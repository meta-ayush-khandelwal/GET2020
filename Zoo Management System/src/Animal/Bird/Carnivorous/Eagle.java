package Animal.Bird.Carnivorous;

public class Eagle extends CarnivorousBird 
{
	public Eagle(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Eagle";
	}

	public String getSound()
	{
		return ("Scream");
	}
}