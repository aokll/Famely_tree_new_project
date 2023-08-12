package FamilyTreePackage;

import java.io.Serializable;

public class MakingConnections implements Serializable {
    int id1;
    Connect connections;
    int id2;

    public MakingConnections(int id1,  Connect connections, int id2) {
        this.id1 = id1;
        this.connections = connections;
        this.id2 = id2;
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }

    public Connect getConnections() {
        return connections;
    }
/*public String Connection(int h1, int h2, String s) {
        List<Human> list = familyTree.getDataBase();
        String line = h1 + s + h2;
        String name1 = null;
        String name2 = null;
        for (Human h : list) {
            if (h1 == h.getID()) {
                name1 = h.getName();
            }
            if (h2 == h.getID()) {
                name2 = h.getName();
            }
        }
        if (s.equals("м")) {
            line = name1 + " [" + h1 + "] " + Connect.HUSBAND +
                    " -> " + "name2" + " [" + h1 + "]";
        } else if (s.equals("ж")) {
            line = name1 + " [" + h1 + "] " + Connect.WIFE +
                    " -> " + "name2" + " [" + h1 + "]";
        } else if (s.equals("c")) {
            line = name1 + " [" + h1 + "] " + Connect.SON +
                    " -> " + "name2" + " [" + h1 + "]";
        } else if (s.equals("д")) {
            line = name1 + " [" + h1 + "] " + Connect.DAUGHTER +
                    " -> " + "name2" + " [" + h1 + "]";
        } else if (s.equals("б")) {
            line = name1 + " [" + h1 + "] " + Connect.GRANDMOTHER +
                    " -> " + "name2" + " [" + h1 + "]";
        } else if (s.equals("дд")) {
            line = name1 + " [" + h1 + "] " + Connect.GRANDFATHER +
                    " -> " + "name2" + " [" + h1 + "]";
        } else if (s.equals("вк")) {
            line = name1 + " [" + h1 + "] " + Connect.GRANDSON +
                    " -> " + "name2" + " [" + h1 + "]";
        } else if (s.equals("вка")) {
            line = name1 + " [" + h1 + "] " + Connect.GRANDDAUGHTER +
                    " -> " + "name2" + " [" + h1 + "]";
        } else if (s.equals("прад")) {
            line = name1 + " [" + h1 + "] " + Connect.GREAT_GRANDFATHER +
                    " -> " + name2 + " [" + h1 + "]";
        } else if (s.equals("праб")) {
            line = name1 + " [" + h1 + "] " + Connect.GREAT_GRANDMOTHER +
                    " -> " + name2 + " [" + h1 + "]";
        }
        return line;
    }*/
}
