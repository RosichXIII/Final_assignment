import java.util.HashMap;
import java.util.Map;

import Animals.Animal;

public class Nursery {

    private static int id = 0;
    private Map<Integer, Animal> animalRoster;

    public Nursery(Map<Integer, Animal> animalRoster) {
        this.animalRoster = new HashMap<>();
    }
    
    public Map<Integer, Animal> getAnimalRoster() {
        return this.animalRoster;
    }

    public void printAnimalRoster() {
        System.out.println("\nСписок животных:");
        this.animalRoster.forEach((k,v) -> System.out.println("Id: " + k + " | " + v));
    }

    public void addAnimal(Animal animal) {
        this.animalRoster.put(Nursery.id, animal);
        Nursery.id++;
    }
    
    public void removeAnimal(int id) {
        this.animalRoster.remove(id);
    }

    public Animal getAnimal(int id) {
       return this.animalRoster.get(id);
    }


}