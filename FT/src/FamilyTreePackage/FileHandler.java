package FamilyTreePackage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Serializable,Writable {
    private List<Human> list = new ArrayList<>();

    public List<Human> getList() {
        return list;
    }
    public void save(List<Human> list) throws Exception {
        ObjectOutputStream objectOutputStream;
        try (FileOutputStream outputStream = new FileOutputStream("D:\\list.txt"))
        {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
        }
    }


    public List<Human> load() throws Exception {

        ObjectInputStream objectInputStream;
        try (FileInputStream fileInputStream = new FileInputStream("D:\\list.txt")
        ){
            objectInputStream = new ObjectInputStream(fileInputStream);

            list = (List<Human>) objectInputStream.readObject();

            for (Human h : list) {
                System.out.println(h.getName() + " " + h.getBirthDate() + " " +
                        h.getDeathDate()
                        + " " + h.getGender());
            }
        }
        return getList();
    }

}

