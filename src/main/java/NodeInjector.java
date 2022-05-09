import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NodeInjector {
    private static final int HEAD_NODE = 0;
    private List<Node> nodes = new LinkedList<>();

    public Node getNodesList(int nodesListSize, int maxNodeValue) {
        if (nodesListSize < 1) {
            throw new RuntimeException("Number of nodes should be bigger or equal to 1. Please, try again");
        }
        if (maxNodeValue < 1) {
            throw new RuntimeException("Max node value should be bigger or equal to 1. Please, try again");
        }
        for (int i = 0; i < nodesListSize; i++) {
            Node node = new Node(new Random().nextInt(maxNodeValue));
            nodes.add(node);
        }
        for (int i = 0; i < nodesListSize - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        System.out.println("Number of nodes: " + nodesListSize + System.lineSeparator()
                + "Max Node value: " + maxNodeValue);
        System.out.print("Nodes sequence: ");
        System.out.println(nodes.stream()
                .map(n -> String.valueOf(n.value))
                .collect(Collectors.joining(" -> ")));
        return nodes.get(HEAD_NODE);
    }
}
