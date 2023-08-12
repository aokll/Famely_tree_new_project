package FamilyTreePackage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Serializable,Writable {
    private List<Human> list = new ArrayList<>();
    private List<MakingConnections> list1 = new ArrayList<>();

    public List<MakingConnections> getList1() {
        return list1;
    }
    public List<Human> getList() {
        return list;
    }
    public void save(List<Human> list) throws Exception {
        ObjectOutputStream objectOutputStream;
        try (FileOutputStream outputStream = new FileOutputStream("D:\\BD.txt"))
        {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
        }
    }

    public void saveFT(List<MakingConnections> list) throws IOException {
        ObjectOutputStream objectOutputStream;
        try (FileOutputStream outputStream = new FileOutputStream("D:\\Connect.txt"))
        {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
        }
    }


    public List<Human> load() throws Exception {

        ObjectInputStream objectInputStream;
        try (FileInputStream fileInputStream = new FileInputStream("D:\\BD.txt")
        ){
            objectInputStream = new ObjectInputStream(fileInputStream);

            list = (List<Human>) objectInputStream.readObject();
        }
        return getList();
    }
        public List<MakingConnections> loadFT() throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream;
        try (FileInputStream fileInputStream = new FileInputStream("D:\\Connect.txt")
        ){
            objectInputStream = new ObjectInputStream(fileInputStream);

            list1 = (List<MakingConnections>) objectInputStream.readObject();
        }
        return getList1();
    }
}

