package FamilyTreePackage;

import java.io.Serializable;
import java.util.List;

public interface Writable extends Serializable {
    List<Human> load() throws Exception;

    void save(List<Human> list) throws Exception;
}
