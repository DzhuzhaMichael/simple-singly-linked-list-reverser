import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NodeService {
    private Node nextNode;
    private Node previousNode;
    private Node currentNode;

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

    public String getNewNodeSequence(Node node) {
        List<Node> nodes = new ArrayList<>();
        currentNode = node;
        while (currentNode != null) {
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }
        System.out.print("Reversed nodes sequence: ");
        return  nodes.stream()
                .map(n -> String.valueOf(n.value))
                .collect(Collectors.joining(" -> "));
    }
}
