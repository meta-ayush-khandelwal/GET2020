package zoo;

import java.util.HashMap;
import Animal.Animal;

public class Cage {
    public int cageId;

    public int capacityOfCage;

    public String cageSpecies;
    
    public int TotalAnimalInCage;
    
    public HashMap<String, Animal> animalList = new HashMap<String, Animal>();

    public Cage(int capacityOfCage, String cageSpecies) {
        this.capacityOfCage = capacityOfCage;
        this.cageSpecies = cageSpecies;
        this.TotalAnimalInCage = 0;
    }

    public boolean addAnimalInCage(Animal animal) {
        if (this.cageSpecies != animal.species || this.capacityOfCage == this.TotalAnimalInCage) {
            return false;
        }
        this.animalList.put(animal.uniqueName, animal);
        this.TotalAnimalInCage++;
        return true;
    }

    public boolean removeAnimalFromCage(Animal animal) {
        if (this.animalList.containsKey(animal.uniqueName)) {
            this.animalList.remove(animal.uniqueName);
            this.TotalAnimalInCage--;
        }
        return true;
    }
}
