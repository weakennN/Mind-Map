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
        List<String[]> connectionIds = new ArrayList<>();

        for (Connection connection : connections) {
            connectionIds.add(new String[]{connection.parent().getUniqueId(), connection.getConnected().getUniqueId()});
        }

        items.add(new Tuple<String, Object>(field.getName(), connectionIds));
    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object object) {
        try {
            Node node = (Node) object;
            List<String[]> connectionIds = (List<String[]>) item.item2;
            node.setConnectionIds(connectionIds);
            field.set(object, new ArrayList<>());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
