package Step9.Lec1;

class MyQueue {
    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    void push(int x) {
        rear = (rear + 1) % 100005;
        arr[rear] = x;
    }

    int pop() {
        if (front == rear) {
            return -1;
        }
        front = (front + 1) % 100005;
        return arr[front];
    }
}

public class Problem2 {

}
