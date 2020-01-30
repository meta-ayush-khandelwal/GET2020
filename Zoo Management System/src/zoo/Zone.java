package zoo;

import java.util.HashMap;
import java.util.Map;
import Animal.Animal;

public class Zone {
    public int zoneId;

    public int totalCagesCapacity;

    public int numberOfCagesPlaced;

    public String categoryOfAnimalSupported;

    //public String subcategoryOfAnimalSupported;

    public Map<Integer, Cage> cageList = new HashMap<Integer, Cage>();

    public boolean hasCanteen;

    public boolean hasPark;

    public Zone(int totalCagesCapacity, String categoryOfAnimalSupported,
             boolean hasCanteen, boolean hasPark) {
        this.totalCagesCapacity = totalCagesCapacity;
        this.categoryOfAnimalSupported = categoryOfAnimalSupported;
       // this.subcategoryOfAnimalSupported = subcategoryOfAnimalSupported;
        this.hasCanteen = hasCanteen;
        this.hasPark = hasPark;
    }

    public boolean addCage(Cage cage) {
        if (this.totalCagesCapacity == this.numberOfCagesPlaced) {
            return false;
        }
        cage.cageId = ++this.numberOfCagesPlaced;
        this.cageList.put(cage.cageId, cage);
        return true;
    }

    public boolean addAnimalInZone(Animal animal) throws Exception {
        for (Cage cage : this.cageList.values()) {
            if (cage.addAnimalInCage(animal)) {
                return true;
            }
        }
        return false;
    }
}
