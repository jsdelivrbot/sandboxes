package sandbox.collections;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetSandbox {

    public static void main() {
        //Pass a comparator in to the TreeSet so it knows how to sort the nodes appropriately.
        TreeSet<Node> test = new TreeSet<>(Comparator.comparingInt(o -> (o.getFirstValue() + o.getSecondValue())));

        Node nodeOne = new Node(0, 1);
        Node nodeTwo = new Node(2, 0);
        Node nodeThree = new Node(1, 2);
        Node nodeFour = new Node(2, 2);
        Node nodeFive = new Node(2, 3);

        test.add(nodeOne);
        test.add(nodeTwo);
        test.add(nodeThree);
        test.add(nodeFour);
        test.add(nodeFive);

        test.floor(nodeFour);
        test.ceiling(nodeFour);
        test.headSet(nodeFour);
        //test.ta
    }

    /**
     * Nodes contain two int values, and they are sorted in the TreeSet by comparing the sum of their two values.
     */
    private static class Node {

        private final int firstValue;
        private final int secondValue;

        private Node(int firstValue, int secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }

        private int getFirstValue() {
            return firstValue;
        }

        private int getSecondValue() {
            return secondValue;
        }
    }
}
