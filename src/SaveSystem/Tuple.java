package SaveSystem;

import java.io.Serializable;

public class Tuple<T1, T2> implements Serializable {

    public T1 item1;
    public T2 item2;

    public Tuple(T1 item1, T2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public void setValues(T1 item1, T2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }
}
