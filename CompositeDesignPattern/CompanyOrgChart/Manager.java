import java.util.*;

class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void add(Employee emp) {
        subordinates.add(emp);
    }

    public Object toNode() {
        Map<String, Object> node = new HashMap<>();
        node.put("name", name);
        node.put("position", position);
        List<Object> subs = new ArrayList<>();
        for (Employee e : subordinates) {
            subs.add(e.toNode());
        }
        if (!subs.isEmpty())
            node.put("subordinates", subs);
        return node;
    }
}

