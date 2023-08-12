package MVP.Presenter;

import FamilyTreePackage.Connect;
import FamilyTreePackage.Gender;
import FamilyTreePackage.Human;
import FamilyTreePackage.MakingConnections;
import MVP.model.Service;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;


public class Present{
    private Service service;

    public Present() {
        service = new Service();
    }


    public void printBD() {
        service.printBD();
    }
    public void printTree() {
        service.printTree();
    }

    public void addNewHuman(String name, LocalDate birthdate, LocalDate deathdate, Gender gender, int id) throws ParseException {
        service.addNewHuman(name,birthdate,deathdate,gender,id);
    }
    public void addConnection(int h1, int h2, Connect s) {
        service.addConnection(h1,h2,s);
    }
    public Boolean verification(int id){
        return service.verification(id);
    }
    public void removeHuman(String name) {
        service.removeHuman(name);
    }

    public void save() {
        service.save();
    }
    public void saveFT() throws IOException {
        service.saveFT();
    }
    public List<Human> load(){
        List<Human> list = service.load();
        return list;
    }
    public List<MakingConnections> loadFT(){
        List<MakingConnections> list = service.loadFT();
        return list;
    }

    public List<Human> sortName() {
        List<Human> list = service.sortName();
        return list;
    }

    public List<Human> sortBirthday() {
        List<Human> list = service.sortBirthday();
        return list;
    }
    public List<Human> sortID() {
        List<Human> list = service.sortID();
        return list;
    }
    public void clearBD() {
        service.clearBD();
    }
    public void clearTree() {
        service.clearTree();
    }

}
