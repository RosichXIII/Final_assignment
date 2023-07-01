import Animals.Beasts.Camel;
import Animals.Beasts.Horse;
import Animals.Pets.Cat;

public class Main {
    
    public static void main(String[] args) {
        Nursery nursery = new Nursery(null);
        Cat cat = new Cat("Elly", "12.12.2022");
        Horse horse = new Horse("Jack", "27.08.2015");
        Camel camel = new Camel("Baraka", "13.03.2007");

        cat.addCommand("pounce");
        cat.addCommand("prowl");
        cat.addCommand("roar");
        
        horse.addCommand("walk");
        horse.addCommand("easy");        
        horse.addCommand("trot");
        horse.addCommand("back");

        camel.addCommand("walk");        
        horse.addCommand("back");

        nursery.addAnimal(cat);
        nursery.addAnimal(horse);
        nursery.addAnimal(camel);

        Menu menu = new Menu();
        menu.mainMenu(nursery);
    }
}