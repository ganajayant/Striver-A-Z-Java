package Step12.Lec1;

import java.util.PriorityQueue;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class Node implements Comparable<Node> {
    int weight;
    int value;

    public Node(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return o.value * this.weight - this.value * o.weight;
    }
}

public class Problem2 {
    double fractionalKnapsack(int w, Item arr[], int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Item node : arr) {
            pq.add(new Node(node.weight, node.value));
        }
        double result = 0.0;
        while (w != 0 && !pq.isEmpty()) {
            Node temp = pq.poll();
            if (w < temp.weight) {
                result += (((double) (temp.value)) / ((double) (temp.weight)) * w);
                w = 0;
            } else {
                result += (double) temp.value;
                w -= temp.weight;
            }
        }
        return result;
    }
}
