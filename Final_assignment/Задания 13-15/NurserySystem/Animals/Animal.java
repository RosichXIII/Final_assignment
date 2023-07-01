package Animals;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private LocalDate birthDate;
    private List<String> commands = new ArrayList<>();

    public Animal(String name, String birthDate) {
        this.name = name;
        try {
            this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeException e) {
            System.out.println("Дата рождения введена в некорректном формате.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String newCommand) {
        commands.add(newCommand);
    }

    public void printCommands() {
        for (String str : commands) {
            System.out.println(str);
        }        
    }

    @Override
    public String toString() {
        return String.format("Кличка: %s | Дата рождения: %s", this.name, this.birthDate);
    }

}
