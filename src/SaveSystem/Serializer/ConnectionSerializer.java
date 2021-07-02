package SaveSystem.Serializer;

import Nodes.Connection;
import SaveSystem.Annotaions.ConnectionSerialize;
import SaveSystem.Tuple;

import java.lang.reflect.Field;
import java.util.List;

public class ConnectionSerializer extends Serializer {

    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(ConnectionSerialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object node) {
        try {
            List<Connection> connections = (List<Connection>) field.get(node);
            items.add(new Tuple<>(field.getName(), connections));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object result) {
        try {
            List<Connection> connections = (List<Connection>) item.item2;
            field.set(result, connections);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
