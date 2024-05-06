package entities.impl;

import entities.AbstractAnimal;
import entities.Command;
import entities.CommandService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Pet extends AbstractAnimal implements CommandService {
    private String name;
    private LocalDate birthDate;
    private List<Command> commandList;

    public Pet(String name, LocalDate birthDate) {
        super();
        this.name = name;
        this.birthDate = birthDate;
        commandList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    public String getAgeInYears(){
        int years = Period.between(birthDate, LocalDate.now()).getYears();
        int month = Period.between(birthDate, LocalDate.now()).getMonths() % 12;
        return years + "." + month;
    }

    public void play(Command command){
        System.out.println("The animal has completed the command: " + command.toString());
    }

    @Override
    public boolean learnCommand(Command newCommand) {
        if(commandList.contains(newCommand)){
            return false;
        }
        commandList.add(newCommand);
        return true;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
