package FamilyTreePackage;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Buffer<T>> implements Serializable {
    private List<T> dataBase;
    private List<T> linkList;


    public FamilyTree(){
        dataBase = new ArrayList<>();
        linkList = new ArrayList<>();
    }
    public List<T> getLinkList() {
        return linkList;
    }
    public List<T> getDataBase() {
        return dataBase;
    }

    public List<T> sortName(List<T> list){
        List<T> list1 = new ArrayList<>();
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(list,comparator);
        for (T h : list) {
            list1.add(h);
        }
        return list1;
    }
    public List<T> sortBirthday(List<T> list){
        List<T> list1 = new ArrayList<>();
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        };
        Collections.sort(list,comparator);
        for (T h : list) {
            list1.add(h);
        }
        return list1;
    }
    public List<T> sortID(List<T> list){
        List<T> list1 = new ArrayList<>();
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Integer.compare(o1.getID(),o2.getID());
            }
        };
        Collections.sort(list,comparator);
        for (T h : list) {
            list1.add(h);
        }
        return list1;
    }
}


