import java.util.Queue;

public interface TraversalMetodeListener {
    void onTraversal(int levelSize, Queue<Tree.Node> level);
}
