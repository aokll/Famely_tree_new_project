package MVP.model;

import FamilyTreePackage.Gender;
import FamilyTreePackage.Human;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public interface ServiceInterfaceDatabase {
    void printBD();
    void addNewHuman(String name, LocalDate birthdate, LocalDate deathDate, Gender gender, int id) throws ParseException;
    void removeHuman(String name);
    void save();
    List<Human> load();
    List<Human> sortName();
    List<Human> sortBirthday();
    List<Human> sortID();
    void clearBD();


}
