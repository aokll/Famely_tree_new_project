package MVP.model;

import FamilyTreePackage.FamilyTree;
import FamilyTreePackage.FileHandler;
import FamilyTreePackage.Gender;
import FamilyTreePackage.Human;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service implements IService {
    private FamilyTree familyTree;
    private FileHandler fileHandler;

    public Service() {
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void printTree(){
        List<Human> list = familyTree.getTreeList();
        if (familyTree.getTreeList().isEmpty()){
            System.out.println("пусто");
        }else {
        for (Human h : list) {
            System.out.println(h.getName() + " " + h.getBirthDate() + " " +
                    h.getDeathDate()
                    + " " + h.getGender());
        }}
    }

    @Override
    public void addNewHuman(String name, LocalDate birthdate, LocalDate deathDate, Gender gender) throws ParseException {
        List<Human> list = new ArrayList<>();
        list.add(new Human(name,birthdate,deathDate,gender));

        for (Human h : list) {
            familyTree.getTreeList().add(h);
        }
    }

    @Override
    public void removeHuman(String name) {
        List<Human> list = familyTree.getTreeList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                familyTree.getTreeList().remove(i);
            } else {
                System.out.println("такого человека не найдено");
                break;
            }
        }
    }

    @Override
    public void save() {
        List<Human> list = familyTree.getTreeList();
        try {
            fileHandler.save(list);
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
            familyTree.getTreeList().add(h);
        }
        return recoveredDate;
    }



    @Override
    public void sortName() {
        familyTree.sortName(familyTree.getTreeList());
    }

    @Override
    public void sortBirthday() {
        familyTree.sortBirthday(familyTree.getTreeList());
    }

    @Override
    public void clearTree() {
        familyTree.getTreeList().clear();
    }
}

