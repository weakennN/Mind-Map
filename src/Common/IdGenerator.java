package Common;

public class IdGenerator {

    private static int currentId = 0;

    public static int generateId() {
        return ++currentId;
    }

    public static void setCurrentId(int currentId_) {
        currentId = currentId_;
    }
}
