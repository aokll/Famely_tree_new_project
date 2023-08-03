package MVP.model;

import FamilyTreePackage.FamilyTree;
import FamilyTreePackage.FileHandler;
import FamilyTreePackage.Gender;
import FamilyTreePackage.Human;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service<T> implements IService {
    private FamilyTree familyTree;
    private FileHandler fileHandler;

    public Service() {
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    @Override
       public void PrintTree(){
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
    public void AddNewHuman(String name, LocalDate birthdate, LocalDate deathDate, Gender gender) throws ParseException {
        List<Human> list = new ArrayList<>();
        list.add(new Human(name,birthdate,deathDate,gender));

        for (Human h : list) {
            familyTree.getTreeList().add(h);
        }
    }

    @Override
    public void RemoveHuman(String name) {
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
    public void Save() {
        List<Human> recoveredDate = new ArrayList<>();
        List<Human> list = familyTree.getTreeList();
        try {
            fileHandler.save(list);
            recoveredDate = fileHandler.load();
            for (Human h : recoveredDate) {
                System.out.println(h.getName() + " " + h.getBirthDate() + " " +
                        h.getDeathDate()
                        + " " + h.getGender());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void SortName() {
        familyTree.sortName(familyTree.getTreeList());
    }

    @Override
    public void SortBirthday() {
        familyTree.sortBirthday(familyTree.getTreeList());
    }
}

