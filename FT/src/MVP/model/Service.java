package MVP.model;

import FamilyTreePackage.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service implements ServiceInterfaceTree,ServiceInterfaceDatabase {
    private FamilyTree familyTree;
    private FileHandler fileHandler;

    public Service() {
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void printBD(){
        List<Human> list = familyTree.getDataBase();
        if (familyTree.getDataBase().isEmpty()){
            System.out.println("пусто");
        }else {
        for (Human h : list) {
            System.out.println(h.getName()
                    + " " + h.getBirthDate()
                    + " " + h.getDeathDate()
                    + " " + h.getGender()+ " " + h.getID());
        }}
    }
    @Override
    public void printTree() {
        List<MakingConnections> list = familyTree.getLinkList();
        if (familyTree.getLinkList().isEmpty()){
            System.out.println("пусто");
        }else {
            for (MakingConnections h : list) {
                System.out.println(h.getId1() + " " + h.getConnections() + " -> " + h.getId2());
            }}
    }

    @Override
    public void addNewHuman(String name, LocalDate birthdate, LocalDate deathDate, Gender gender,int id) throws ParseException {
        List<Human> list = new ArrayList<>();
        list.add(new Human(name,birthdate,deathDate,gender,id));

        for (Human h : list) {
            familyTree.getDataBase().add(h);
        }
    }
    @Override
    public void addConnection(int h1, int h2, Connect s) {
        List<MakingConnections> list = new ArrayList<>();
        list.add(new MakingConnections(h1,s,h2));
        for (MakingConnections m : list) {
            familyTree.getLinkList().add(m);
        }
    }
    @Override
    public boolean verification(int id){
        boolean ver = false;
        List<Human> list = familyTree.getDataBase();
        for (Human h : list) {
            if (id == h.getID()){
                ver = true;
            }
        }
        return ver;
    }
    @Override
    public void removeHuman(String name) {
        List<Human> list = familyTree.getDataBase();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                familyTree.getDataBase().remove(i);
            } else {
                System.out.println("Такого человека не найдено");
                break;
            }
        }
    }

    @Override
    public void save() {
        List<Human> list = familyTree.getDataBase();
        try {
            fileHandler.save(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void saveFT() {
        List<MakingConnections> list = familyTree.getLinkList();
        try {
            fileHandler.saveFT(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Human> load() {
        List<Human> recoveredDate = new ArrayList<>();
        try {
            recoveredDate = fileHandler.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (Human h : recoveredDate) {

            familyTree.getDataBase().add(h);
        }
        return recoveredDate;
    }
    @Override
    public List<MakingConnections> loadFT() {
        List<MakingConnections> recoveredDate = new ArrayList<>();
        try {
            recoveredDate = fileHandler.loadFT();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (MakingConnections h : recoveredDate) {

            familyTree.getLinkList().add(h);
        }
        return recoveredDate;
    }
    @Override
    public List<Human> sortName() {
        List<Human> list = familyTree.sortName(familyTree.getDataBase());
        return list;
    }

    @Override
    public List<Human> sortBirthday() {
        List<Human> list = familyTree.sortBirthday(familyTree.getDataBase());
        return list;
    }

    @Override
    public List<Human> sortID() {
        List<Human> list = familyTree.sortID(familyTree.getDataBase());
        return list;
    }

    @Override
    public void clearBD() {
        familyTree.getDataBase().clear();
    }

    @Override
    public void clearTree() {
        familyTree.getLinkList().clear();
    }


}

