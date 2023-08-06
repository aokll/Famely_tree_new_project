package FamilyTreePackage;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Buffer<T>> implements Serializable {
    private List<T> TreeList;
    public FamilyTree(){
        TreeList = new ArrayList<>();
    }
    public List<T> getTreeList() {
        return TreeList;
    }
    public void sortName(List<T> list){
        //list = ;
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(list,comparator);
        for (T h : list) {
            System.out.println(h.getName() + " " + h.getBirthDate() + " " + h.getDeathDate() + " " +
                    h.getGender());
        }
    }
    public void sortBirthday(List<T> list){
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        };
        Collections.sort(list,comparator);
        for (T h : list) {
            System.out.println(h.getBirthDate() + " " + h.getName() + " " + h.getDeathDate() + " " +
                    h.getGender());
        }
    }
}


