package MVP.model;

import FamilyTreePackage.Gender;
import FamilyTreePackage.Human;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public interface IService {
    void printTree();
    void addNewHuman(String name, LocalDate birthdate, LocalDate deathdate, Gender gender) throws ParseException;
    void removeHuman(String name);
    void save() throws Exception;
    List<Human> load() throws Exception;
    void sortName();
    void sortBirthday();
    void clearTree();

}

