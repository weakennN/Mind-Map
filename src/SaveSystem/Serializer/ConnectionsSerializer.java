package SaveSystem.Serializer;

import Nodes.Connection;
import Nodes.Node;
import SaveSystem.Annotaions.ConnectionSerialize;
import SaveSystem.Tuple;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ConnectionsSerializer extends Serializer {

    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(ConnectionSerialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object object) {

        Node node = (Node) object;

        List<Connection> connections = node.getConnections();
        List<Tuple<Integer, Integer>> connectionIds = new ArrayList<>();

        for (Connection connection : connections) {
            connectionIds.add(new Tuple<>(connection.parent().getUniqueId(), connection.getConnected().getUniqueId()));
        }

        items.add(new Tuple<String, Object>(field.getName(), connectionIds));
    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object object) {
        try {
            Node node = (Node) object;
            List<Tuple<Integer, Integer>> connectionIds = (List<Tuple<Integer, Integer>>) item.item2;
            node.setConnectionIds(connectionIds);
            field.set(object, new ArrayList<>());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
