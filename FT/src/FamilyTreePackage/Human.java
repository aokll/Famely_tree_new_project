package FamilyTreePackage;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;

public class Human implements Buffer, Serializable {
    private String name;
    private LocalDate birthday;

    private LocalDate deathDate;
    private Gender gender;
    private int id;

    public Human(String name, LocalDate birthday, LocalDate deathDate, Gender gender,int id) throws ParseException {
        this.name = name;
        this.birthday = birthday;
        this.deathDate = deathDate;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthday;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public int getID() {
        return id;
    }
}
