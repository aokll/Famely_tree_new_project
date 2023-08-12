package MVP.model;

import FamilyTreePackage.Connect;
import FamilyTreePackage.MakingConnections;

import java.util.List;

public interface ServiceInterfaceTree {
    void printTree();
    void saveFT();
    List<MakingConnections> loadFT();
    void clearTree();
    void addConnection(int h1, int h2, Connect s);
    boolean verification(int id);
}
