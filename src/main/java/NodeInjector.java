import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NodeInjector {
    private static final int HEAD_NODE = 0;
    private static final Logger logger = LogManager.getLogger(NodeInjector.class);

    public Node getNodesList(int nodesListSize, int maxNodeValue) {
        List<Node> nodes = new ArrayList<>();
        if (nodesListSize < 1) {
            logger.error("Invalid number of nodes = {}", nodesListSize);
            throw new RuntimeException("Number of nodes should be bigger or equal to 1. "
                    + "Please, try again");
        }
        if (maxNodeValue < 1) {
            logger.error("Invalid max node value = {}", maxNodeValue);
            throw new RuntimeException("Max node value should be bigger or equal to 1. "
                    + "Please, try again");
        }
        for (int i = 0; i < nodesListSize; i++) {
            Node node = new Node(new Random().nextInt(maxNodeValue));
            nodes.add(node);
        }
        for (int i = 0; i < nodesListSize - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        logger.info("Number of nodes = {}, "
                + "Max node value = {}", nodesListSize, maxNodeValue);
        String nodesSequence = nodes.stream()
                .map(n -> String.valueOf(n.value))
                .collect(Collectors.joining(" -> "));
        logger.info("Nodes sequence = {} ", nodesSequence);
        return nodes.get(HEAD_NODE);
    }
}
