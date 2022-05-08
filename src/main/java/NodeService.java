import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NodeService {
    private Node nextNode;
    private Node previousNode;
    private Node currentNode;
    private List<Node> nodes = new LinkedList<>();

    public Node reverse(Node node) {
        previousNode = null;
        currentNode = node;
        nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public void newNodeSequence(Node node) {
        currentNode = node;
        while (currentNode != null) {
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }
        System.out.print("Reversed nodes sequence: ");
        System.out.println(nodes.stream()
                .map(n -> String.valueOf(n.value))
                .collect(Collectors.joining(" -> ")));
    }
}
