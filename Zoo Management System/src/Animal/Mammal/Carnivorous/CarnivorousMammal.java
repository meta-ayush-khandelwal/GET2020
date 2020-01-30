package Animal.Mammal.Carnivorous;

import Animal.Mammal.Mammal;

abstract class CarnivorousMammal extends Mammal 
{

    protected CarnivorousMammal()
    {
        super.subCategory = "Carnivorous";
    }
}