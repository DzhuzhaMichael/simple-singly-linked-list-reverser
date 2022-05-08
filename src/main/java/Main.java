public class Main {
    private static final int NODE_LIST_SIZE = 10;
    private static final int MAX_NODE_VALUE = 100;
    private static final NodeInjector nodeInjector = new NodeInjector();
    private static final NodeService nodeService = new NodeService();

    public static void main(String[] args) {
        Node headNode = nodeInjector.getNodesList(NODE_LIST_SIZE, MAX_NODE_VALUE);
        nodeService.newNodeSequence(nodeService.reverse(headNode));
    }
}
