class Stk {
    public int[] arr;
    public int capacity, top;

    Stk(int size) {
        capacity = size;
        top = -1;
        arr = new int[capacity];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void expandStk() {
        int curr_size = top + 1;
        int[] new_arr = new int[curr_size * 2];
        for (int i = 0; i < curr_size; i++) {
            new_arr[i] = arr[i];
        }
        arr = new_arr;
        capacity = new_arr.length;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Top element: " + arr[top]);
        }
        System.out.println();
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Expanding Stack...");
            expandStk();
        }
        arr[++top] = x;
        System.out.println("Element successfully added: " + x);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1; // Return some default value or throw an exception
        }
        return arr[top--];
    }

    void prt_Stk() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }
}

public class Rev_Stk {
    static Stk st = new Stk(4);

    static void insert_at_bottom(int x) {
        if (st.isEmpty()) {
            st.push(x);
        } else {
            int a = st.pop();
            insert_at_bottom(x);
            st.push(a);
        }
    }

    static void reverse() {
        if (!st.isEmpty()) {
            int x = st.pop();
            reverse();
            insert_at_bottom(x);
        }
    }

    public static void main(String[] args) {
        st.push(5);
        st.push(7);
        st.peek();
        st.push(6);
        st.push(4);
        st.push(2);
        st.pop();
        st.prt_Stk();
        st.push(1);
        reverse();
        st.prt_Stk();
    }
}
