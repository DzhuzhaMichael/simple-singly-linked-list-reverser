import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NodeService {
    private static final Logger logger = LogManager.getLogger(NodeService.class);
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
        String newNodeSequence = nodes.stream()
                .map(n -> String.valueOf(n.value))
                .collect(Collectors.joining(" -> "));
        logger.info("New nodes sequence = {} ", newNodeSequence);
        return newNodeSequence;
    }
}
