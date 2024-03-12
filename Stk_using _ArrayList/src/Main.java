import java.util.ArrayList;

class Stk {
    private ArrayList<Integer> arr;

    Stk() {
        arr = new ArrayList<>();
    }

    public void push(int x) {
        arr.add(x);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Underflow!");
            System.exit(1);
        }
        return arr.remove(arr.size() - 1);
    }

    public int getSize() {
        return arr.size();
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public void printStk() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(" " + arr.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stk stack = new Stk();

        stack.push(9);
        stack.push(2);
        stack.push(1);
        System.out.println("Stack:");
        stack.printStk();
        System.out.println("Size: " + stack.getSize());

        stack.push(5);
        stack.pop();
        stack.push(6);
        stack.push(7);
        stack.push(2);
        stack.pop();
        stack.push(1);
        stack.push(7);
        System.out.println("Stack:");
        stack.printStk();
        System.out.println("Size: " + stack.getSize());

        System.out.println("Stack implemented successfully.");
    }
}
