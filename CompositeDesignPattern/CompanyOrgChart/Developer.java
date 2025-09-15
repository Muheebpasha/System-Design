import java.util.*;

class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Object toNode() {
        Map<String, String> node = new HashMap<>();
        node.put("name", name);
        node.put("position", position);
        return node;
    }
}
