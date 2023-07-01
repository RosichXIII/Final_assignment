import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Animals.Animal;
import Animals.Beasts.Camel;
import Animals.Beasts.Donkey;
import Animals.Beasts.Horse;
import Animals.Pets.Cat;
import Animals.Pets.Dog;
import Animals.Pets.Hamster;

public class Menu {

    public void animalMenu(Animal animal, Scanner sc) {        
        Integer userChoice;
        do {
            System.out.println("\n\nКарточка животного: \n" +
                        animal + "\n" + animal.getCommands() +
                        "\n\n1. Обучить новым командам\n" +
                        "0. Выход в меню питомника\n");
            userChoice = Integer.parseInt(sc.nextLine());
            switch (userChoice) {
                case 1:
                    System.out.println("\n\nВведите новую команду: \n");
                    animal.addCommand(sc.nextLine());
                    break;
                case 0:   
                    break;
                default:
                    System.out.println("\n\nПопробуйте снова: \n");
            }
        } while (userChoice != 0);
    }   

    public void nurseryMenu(Nursery nursery, Scanner sc) {
        nursery.printAnimalRoster();
        Integer userChoice = null;

        while (userChoice == null) {
            System.out.println("\n\nМеню питомника: \n" +
                                "1. Добавить животное\n" +
                                "2. Удалить животное\n" +
                                "3. Карточка животного\n" +
                                "0. Выход в главное меню\n");
            try {
                userChoice = Integer.parseInt(sc.nextLine());

                if (userChoice >= 0 && userChoice < 4) {
                    switch (userChoice) {
                        case 1:
                            chooseAnimal(nursery, sc);
                            userChoice = null;
                            break;
                        case 2:                    
                            Integer choice = -1;

                            while (!nursery.getAnimalRoster().containsKey(choice)) {
                                System.out.println("\n\nУкажите id для удаления: \n");
                                try {
                                    choice = Integer.parseInt(sc.nextLine());
                                }
                                catch (Exception e) {
                                    continue;
                                }
                            }
                            nursery.removeAnimal(choice);
                            userChoice = null;
                            break;
                        case 3:
                            Integer choice2 = -1;

                            while (!nursery.getAnimalRoster().containsKey(choice2)) {
                                System.out.println("\n\nУкажите id для удаления: \n");
                                try {
                                    choice2 = Integer.parseInt(sc.nextLine());
                                }
                                catch (Exception e) {
                                    continue;
                                }
                            }                    
                            animalMenu(nursery.getAnimal(choice2), sc);
                            userChoice = null;
                            break;
                        case 0:
                            break;
                    }
                }
                else {
                    userChoice = null;
                }
            }
            catch (Exception e) {
                userChoice = null;
                continue;
            }
        }
    }

    public void chooseAnimal(Nursery nursery, Scanner sc) {

        Integer userChoice = null;
        while (userChoice == null) {
            System.out.println("\n\nВыберите вид животного: \n" +
                            "1. Собака\n" +
                            "2. Кошка\n" +
                            "3. Хомяк\n" +
                            "4. Лошадь\n" +
                            "5. Осёл\n" +
                            "6. Верблюд\n" +
                            "0. Выход в меню питомника\n");
            try {
                userChoice = Integer.parseInt(sc.nextLine());                
            }
            catch (Exception e) {
                userChoice = null;
                continue;
            }
        }
        String[] info = new String[2];

        while (userChoice != 0) {

            if (userChoice > 0 && userChoice < 7) {
                info = nameAndBirthDate(info, sc);

                switch (userChoice) {
                    case 1:                        
                        nursery.addAnimal(new Dog(info[0], info[1]));
                        break;
                    case 2:
                        nursery.addAnimal(new Cat(info[0], info[1]));
                        break;
                    case 3:
                        nursery.addAnimal(new Hamster(info[0], info[1]));
                        break;
                    case 4:
                        nursery.addAnimal(new Horse(info[0], info[1]));
                        break;
                    case 5:
                        nursery.addAnimal(new Donkey(info[0], info[1]));
                        break;
                    case 6:
                        nursery.addAnimal(new Camel(info[0], info[1]));
                        break;
                }                
                Counter.counter++;
                break;
            }
            else {
                userChoice = null;
                
                while (userChoice == null) {                            
                    System.out.println("\n\nПопробуйте снова: \n");
                    
                    try {
                        userChoice = Integer.parseInt(sc.nextLine());
                    }
                    catch (Exception e) {
                        userChoice = null;
                        continue;
                    }
                }
            }
        }
    }

    public String[] nameAndBirthDate(String[] info, Scanner sc) {
        System.out.println("\n\nКличка: \n");
        info[0] = sc.nextLine();
        info[1] = null;

        while (info[1] == null) {
            System.out.println("\n\nДата рождения (dd.MM.yyyy): \n");
            info[1] = sc.nextLine();

            try {
                LocalDate.parse(info[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }
            catch (Exception e) {
                info[1] = null;
                System.out.println("\n\nПопробуйте снова: \n");
                continue;                   
            }
        }
        
        return info;
    }

    public void mainMenu(Nursery nursery) {
        
        try (Scanner sc = new Scanner(System.in); Counter counter = new Counter();) {
            Integer userChoice = null;

            while (userChoice == null) {
                System.out.println("\n\nГлавное меню: \n" +
                                    "1. Меню питомника\n" +
                                    "0. Выход\n");
                try {
                    userChoice = Integer.parseInt(sc.nextLine());

                    if (userChoice == 0 | userChoice == 1) {
                        switch (userChoice) {
                            case 1:                        
                                nurseryMenu(nursery, sc);
                                userChoice = null;
                            case 0:
                                break;
                        }
                    }
                    else {
                        userChoice = null;
                    }
                }
                catch (Exception e) {
                    userChoice = null;
                    continue;
                }
            }
        }
    }
}