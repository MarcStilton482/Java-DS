class Stk {
    int capacity, top;
    int arr[];

    Stk(int size) {
        top = -1;
        capacity = size;
        arr = new int[size];
    }

    boolean isFull() {
        return top == capacity - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }


    void expStk() {
        int currSize = top + 1;
        int newArr[] = new int[currSize * 2];
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = arr.length;
    }

    void push(int x) {
        if (isFull()) {
            System.out.println("Queue is full.\nExpanding...");
            expStk();

        }

        arr[++top] = x;

    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            System.exit(1);
        }
        return arr[top--];
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");

        }
        return arr[top];
    }

    void prtStk() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");

        } else {
            for (int i = 0; i <= top; i++) {
                System.out.println(arr[i]);
            }
        }

    }
}

    class RevStk {
        Stk st = new Stk(4);

        void insert_at_bottom(int x) {
            if (st.isEmpty()) {
                st.push(x);
            } else {
                int a = st.pop();
                insert_at_bottom(x);
                st.push(a);
            }
        }

        void reverse() {
            if (!st.isEmpty()) {
                int x = st.pop();
                reverse();
                insert_at_bottom(x);
            }

        }
    }
    public class Q extends RevStk
    {
        void enQ(int a)
        {
            st.push(a);
            System.out.println("After insertion of "+a+" in Queue: ");
            st.prtStk();
        }
        void deQ()
        {
            reverse();
            st.pop();
            System.out.println("After deletion in Queue: ");
            reverse();
            st.prtStk();
        }


        public static void main(String[] args)
        {
            Q q = new Q();
            q.enQ(2);
            q.enQ(1);
            q.enQ(4);
            q.enQ(6);
            q.enQ(8);
            q.deQ();


        }
    }
//Space Complexity: O(n)
//Time Complexity: O(n)