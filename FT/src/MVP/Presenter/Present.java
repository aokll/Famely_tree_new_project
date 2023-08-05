package MVP.Presenter;

import FamilyTreePackage.Gender;
import FamilyTreePackage.Human;
import MVP.View.Console.ConsoleFT;
import MVP.model.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;


public class Present{
    private ConsoleFT view;
    private Service service;

    public Present(ConsoleFT view) {
        this.view = view;
        service = new Service();
    }


    public void printTree() {
        service.printTree();
    }

    public void addNewHuman(String name, LocalDate birthdate, LocalDate deathdate, Gender gender) throws ParseException {
        service.addNewHuman(name,birthdate,deathdate,gender);
    }

    public void removeHuman(String name) {
        service.removeHuman(name);
    }

    public void save() {
        service.save();
    }
    public List<Human> load(){
        List<Human> list = service.load();
        return list;
    }

    public void sortName() {
        service.sortName();
    }

    public void sortBirthday() {
        service.sortBirthday();
    }
    public void clearTree() {
        service.clearTree();
    }
}
