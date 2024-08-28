package Step9.Lec1;

class MyStack {
    int top;
    int arr[] = new int[1000];

    MyStack() {
        top = -1;
    }

    void push(int a) {
        arr[++top] = a;
    }

    int pop() {
        return top == -1 ? -1 : arr[top--];
    }
}

public class Problem1 {

}
