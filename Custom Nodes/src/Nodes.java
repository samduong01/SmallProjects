/**
 * Created by sam on 10/3/17.
 */
public class Nodes {
    int key;
    String name;

    //Node leftChild;
    //Node rightChild;

    public Nodes(int key, String name) {

        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has the key " + key;
    }
}
