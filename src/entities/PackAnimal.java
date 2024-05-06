package entities;

import services.CommandService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class PackAnimal extends AbstractAnimal implements CommandService {
    public static final double DEFAULT_CAPACITY = 100.0;
    private String name;
    private LocalDate birthDate;
    private List<Command> commandList;

    public PackAnimal(String name, LocalDate birthDate) {
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
        return "PackAnimal{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
