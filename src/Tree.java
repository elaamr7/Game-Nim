import java.util.*;
public class Tree {

        static class Node
        {
            int key ;
            Double weight;
            Vector<Node>child = new Vector<>();
        };

        private static Node newNode(int key,Double weight)
        {
            Node temp = new Node();
            temp.key = key;
            temp.weight = weight;
            return temp;
        }

        public static Node createTree(){
            Node root = newNode(7,0.0);

            root.child.add(newNode(61,0.0));
            root.child.add(newNode(52,0.0));
            root.child.add(newNode(43,0.0));
            root.child.get(0).child.add(newNode(511,0.0));
            root.child.get(0).child.add(newNode(421,0.0));
            root.child.get(1).child.add(newNode(421,0.0));
            root.child.get(1).child.add(newNode(322,0.0));
            root.child.get(2).child.add(newNode(421,0.0));
            root.child.get(2).child.add(newNode(331,0.0));
            root.child.get(0).child.get(0).child.add(newNode(4111,0.0));
            root.child.get(0).child.get(0).child.add(newNode(3211,0.0));
            root.child.get(0).child.get(1).child.add(newNode(3211,0.0));
            root.child.get(1).child.get(0).child.add(newNode(3211,0.0));
            root.child.get(1).child.get(1).child.add(newNode(2221,0.0));
            root.child.get(2).child.get(0).child.add(newNode(3211,0.0));
            root.child.get(2).child.get(1).child.add(newNode(3211,0.0));
            root.child.get(0).child.get(0).child.get(0).child.add(newNode(31111,0.0));
            root.child.get(0).child.get(0).child.get(1).child.add(newNode(22111,0.0));
            root.child.get(0).child.get(1).child.get(0).child.add(newNode(22111,0.0));
            root.child.get(1).child.get(0).child.get(0).child.add(newNode(22111,0.0));
            root.child.get(2).child.get(0).child.get(0).child.add(newNode(22111,0.0));
            root.child.get(2).child.get(1).child.get(0).child.add(newNode(22111,0.0));
            root.child.get(0).child.get(0).child.get(0).child.get(0).child.add(newNode(211111,0.0));

            return root;
        }

        public static void LevelOrderTraversal(Node root,
                                               TraversalMetodeListener listener,
                                               Players players) {

            if (root == null)
                return;
            Queue<Node> level = new LinkedList<>();
            level.add(root);
            int sumData = 1;

            while (!level.isEmpty()) {
                if(sumData!=1 && players!=null)
                    System.out.println(players.getPlayers().get(0));

                int levelSize = level.size();
                listener.onTraversal(levelSize,level);

                System.out.println();
                if(players!=null)
                    if(sumData!=1)
                        players.change();
                sumData++;
            }

        }

        public static void printNode(Node node){
            System.out.print("{");
            System.out.print("node:" + node.key + ",");
            System.out.print("weigth:" + node.weight);
            System.out.print("}");
            System.out.print(" , ");
        }

}

