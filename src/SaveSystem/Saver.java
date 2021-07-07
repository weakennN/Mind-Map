package SaveSystem;

import SaveSystem.Serializer.*;
import SaveSystem.Serializer.SkinSerializer.SkinSerializer;
import javafx.scene.layout.Region;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Saver {

    private static FileOutputStream fileOut;
    private static ObjectOutputStream out;

    private static FileInputStream in;
    private static ObjectInputStream objectIn;

    private static List<Serializer> serializers;

    public static void init() {

        serializers = new ArrayList<>();
        serializers.add(new PrimitiveTypeSerializer());
        serializers.add(new Vector2Serializer());
        serializers.add(new SkinSerializer());
        serializers.add(new ConnectionsSerializer());
    }

    public static void save(Object node) {

        try {

            List<Tuple<String, Object>> items = new ArrayList<>();

            List<Field> fields = getFields(node.getClass());

            for (Field declaredField : fields) {

                declaredField.setAccessible(true);

                for (Serializer serializer : serializers) {
                    if (serializer.checkCondition(declaredField)) {
                        serializer.save(items, declaredField, node);
                        break;
                    }
                }

                declaredField.setAccessible(false);
            }

            out.writeObject(node.getClass());
            out.writeObject(items);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object load() {

        if (objectIn == null) {
            return null;
        }

        try {

            if (in.available() == 0) {
                return null;
            }

            Object object = objectIn.readObject();

            var clazz = (Class) object;

            Object result = Arrays.stream(clazz.getConstructors()).filter(n -> n.getParameterCount() == 0).findFirst().get().newInstance();

            List<Tuple<String, Object>> items = (List<Tuple<String, Object>>) objectIn.readObject();

            for (var item : items) {

                Field field = getField(clazz, item);
                field.setAccessible(true);

                for (Serializer serializer : serializers) {
                    if (serializer.checkCondition(field)) {
                        serializer.load(item, field, result);
                        break;
                    }
                }

                field.setAccessible(false);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static List<Field> getFields(Class clazz) {

        List<Field> fields = new ArrayList<>();
        Class<?> current = clazz;
        while (current.getSuperclass() != null) {
            fields.addAll(Arrays.asList(current.getDeclaredFields()));
            current = current.getSuperclass();
            if (current == Region.class) {
                break;
            }
        }

        return fields;
    }

    private static <T> Field getField(Class clazz, T item) {

        try {

            Class<?> current = clazz;
            while (current != null) {

                Tuple<String, Object> tuple = (Tuple<String, Object>) item;

                Field[] fields = current.getDeclaredFields();

                for (Field field : fields) {

                    if (field.getName().equals(tuple.item1)) {
                        return field;
                    }
                }

                current = current.getSuperclass();
                if (current == Region.class) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void initIn() {

        try {
            in = new FileInputStream(System.getProperty("user.dir") + "/save/Save.txt");
            if (in.available() == 0) {
                in.close();
                return;
            }
            objectIn = new ObjectInputStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initOut() {
        try {
            fileOut = new FileOutputStream(System.getProperty("user.dir") + "/save/Save.txt", true);
            out = new ObjectOutputStream(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeOut() {
        try {
            if (out != null && fileOut != null) {
                out.close();
                fileOut.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeIn() {
        try {
            if (objectIn != null && in != null) {
                objectIn.close();
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createNewFile() {
        try {
            fileOut = new FileOutputStream(System.getProperty("user.dir") + "/save/Save.txt");
            out = new ObjectOutputStream(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
