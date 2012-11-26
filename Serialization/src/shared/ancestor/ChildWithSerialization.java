package shared.ancestor;

import java.io.Serializable;

public class ChildWithSerialization extends ParentWithNoSerialization implements Serializable {
    private int counter = 0;

}
