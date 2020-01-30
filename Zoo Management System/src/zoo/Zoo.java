package zoo;

import java.util.HashMap;
import java.util.Map;
import Animal.Animal;

public class Zoo {

    static HashMap<String, Animal> animalsInZoo = new HashMap<>();

    public static int numberOfZones = 0;

    public static Map<Integer, Zone> zonesInZoo = new HashMap<Integer, Zone>();

    public static boolean addZone(Zone zone) {
        zone.zoneId = ++(Zoo.numberOfZones);
        Zoo.zonesInZoo.put(zone.zoneId, zone);
        return true;
    }


    private static Zone findSupportedZoneForAnimal(Animal animal) throws Exception {
        for (Zone zone : Zoo.zonesInZoo.values()) {
            if (zone.categoryOfAnimalSupported.equalsIgnoreCase(animal.category)) {
                return zone;
            }
        }

        throw new Exception("Supported zone not found for given animal!!!");
    }

    public static boolean addAnimal(Animal animal) throws Exception {
        if (Zoo.animalsInZoo.containsKey(animal.uniqueName)) {
            throw new Exception("Same name animal already present in zoo!!!");
        }

        Zone supportedZone = Zoo.findSupportedZoneForAnimal(animal);
        boolean animalPlaced = supportedZone.addAnimalInZone(animal);
        if (animalPlaced) {
            animalsInZoo.put(animal.uniqueName, animal);
            return true;
        }
        return false;
    }

    public static boolean addCage(Zone zone, Cage cage) {
        if (Zoo.zonesInZoo.containsKey(zone.zoneId)) {
            boolean cagePlaced = zone.addCage(cage);
            if (cagePlaced) {
                return true;
            }
        }
        return false;
    }

    public static boolean removeAnimal(Animal animal) throws Exception {
        if (Zoo.animalsInZoo.containsKey(animal.uniqueName)) {
            Zone zoneOfAnimal = Zoo.findSupportedZoneForAnimal(animal);
            for (Cage cage : zoneOfAnimal.cageList.values()) {
                if (cage.cageSpecies == animal.species) {
                    cage.removeAnimalFromCage(animal);
                }
            }
            Zoo.animalsInZoo.remove(animal.uniqueName);
            return true;
        }
        return false;
    }
}
