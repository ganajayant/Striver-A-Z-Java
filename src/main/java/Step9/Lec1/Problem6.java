package Step9.Lec1;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int a) {
        data = a;
        next = null;
    }
}

public class Problem6 {
    class MyQueue {
        QueueNode front = null, rear = null;

        void push(int a) {
            if (front == null) {
                front = new QueueNode(a);
                rear = front;
            } else {
                rear.next = new QueueNode(a);
                rear = rear.next;
            }
        }

        int pop() {
            if (front == null) {
                return -1;
            } else if (front == rear) {
                int x = front.data;
                front = null;
                rear = null;
                return x;
            } else {
                int x = front.data;
                front = front.next;
                return x;
            }
        }
    }

}
