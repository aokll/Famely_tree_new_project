package MVP.Presenter;

import FamilyTreePackage.Gender;
import MVP.View.Console.ConsoleFT;
import MVP.model.IService;
import MVP.model.Service;

import java.text.ParseException;
import java.time.LocalDate;


public class Present{
    private ConsoleFT view;
    private Service service;

    public Present(ConsoleFT view) {
        this.view = view;
        service = new Service();
    }


    public void PrintTree() {
        service.PrintTree();
    }

    public void AddNewHuman(String name, LocalDate birthdate, LocalDate deathdate, Gender gender) throws ParseException {
        service.AddNewHuman(name,birthdate,deathdate,gender);
    }

    public void RemoveHuman(String name) {
        service.RemoveHuman(name);
    }

    public void Save() {
        service.Save();
    }

    public void SortName() {
        service.SortName();
    }

    public void SortBirthday() {
        service.SortBirthday();
    }
}
