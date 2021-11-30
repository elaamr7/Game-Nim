import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class GameNimLearning {
    Tree.Node root;
    Players players;

    GameNimLearning(Tree.Node root, Players players){
        this.root = root;
        this.players = players;
    }

    private void initialWeight(){
        Tree.LevelOrderTraversal(root, new TraversalMetodeListener() {
            @Override
            public void onTraversal(int levelSize, Queue<Tree.Node>level) {
                while (levelSize > 0) {
                    Tree.Node node = level.peek();
                    level.remove();
                    if(node.child.size()!=0){
                        node.weight=0.5;
                    }
                    else{
                        if(players.getPlayers().get(0).equals("Computer"))
                            node.weight = 1.0;
                        else
                            node.weight = 0.0;
                    }
                    for (int i = 0; i < node.child.size(); i++)
                        level.add(node.child.get(i));
                    levelSize--;
                }
            }
        },players);

    }
    public void getExperimentResult(){
        players.reset();
        for(int i=0; i<2; i++){
            doExperiment(root);
        }
        System.out.println("Hasil eksperimen : ");
        Tree.LevelOrderTraversal(root, new TraversalMetodeListener() {
            @Override
            public void onTraversal(int levelSize, Queue<Tree.Node> level) {
                while (levelSize>0) {
                    Tree.Node node = level.peek();
                    level.remove();
                    Tree.printNode(node);
                    for (int i = 0; i < node.child.size(); i++) {
                        level.add(node.child.get(i));
                    }
                    levelSize--;
                }

            }
        },players);
    }
    public void doExperiment(Tree.Node root){
        Tree.LevelOrderTraversal(root, new TraversalMetodeListener() {
            @Override
            public void onTraversal(int levelSize, Queue<Tree.Node> level) {
                while (levelSize > 0) {
                    Tree.Node parent = level.peek();
                    level.remove();
                    Tree.Node child = null;
                    if (parent.child.size() != 0) {
                        Random rand = new Random();
                        child = parent.child.get(rand.nextInt(parent.child.size()));
                        parent.weight = parent.weight + (0.1*(child.weight-parent.weight));
                    }
                    Tree.printNode(parent);
                    doExperiment(child);
                    levelSize--;
                }
            }
        },null);
    }

    public void learn(){
     initialWeight();
     getExperimentResult();
    }

    public static void main(String[] args){
        Tree.Node root = Tree.createTree();

        List<String> playerList = new ArrayList<>();
        playerList.add("Computer");
        playerList.add("User");
        Players players = new Players(playerList);


        GameNimLearning learner  = new GameNimLearning(root,players);
        learner.learn();
    }
}
