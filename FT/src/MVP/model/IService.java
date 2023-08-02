package MVP.model;

import FamilyTreePackage.Gender;

import java.text.ParseException;
import java.time.LocalDate;

public interface IService {
    void PrintTree();
    void AddNewHuman(String name, LocalDate birthdate, LocalDate deathdate, Gender gender) throws ParseException;
    void RemoveHuman(String name);
    void Save();
    void SortName();
    void SortBirthday();

}

