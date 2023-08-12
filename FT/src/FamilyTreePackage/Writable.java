package FamilyTreePackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface Writable extends Serializable {
    void save(List<Human> list) throws Exception;
    void saveFT(List<MakingConnections> list) throws IOException;
    List<Human> load() throws Exception;
    List<MakingConnections> loadFT() throws IOException, ClassNotFoundException;

}
