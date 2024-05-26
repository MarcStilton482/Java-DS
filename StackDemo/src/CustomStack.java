class CustomStack {
    private int[] stackArray;
    private int topIndex;
    private int stackCapacity;

    public CustomStack() {
        stackCapacity = 10;
        stackArray = new int[stackCapacity];
        topIndex = -1;
    }

    public void push(int element) {
        if (isFull()) {
            expandArray();
        }
        stackArray[++topIndex] = element;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Underflow!");
            System.exit(1);
        }
        return stackArray[topIndex--];
    }

    public int getStackSize() {
        return topIndex + 1;
    }

    public boolean isFull() {
        return topIndex == stackCapacity - 1;
    }

    private void expandArray() {
        int currentSize = topIndex + 1;
        int[] newArray = new int[currentSize + 1];
        copyArray(stackArray, newArray, currentSize);
        stackArray = newArray;
        stackCapacity = newArray.length;
    }

    private void copyArray(int[] source, int[] destination, int n) {
        if (n == 0) {
            return;
        }
        copyArray(source, destination, n - 1);
        destination[n - 1] = source[n - 1];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void printStackElements() {
        for (int i = 0; i <= topIndex; i++) {
            System.out.println(" " + stackArray[i]);
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();

        stack.push(9);
        stack.push(2);
        stack.push(1);
        System.out.println("Stack:");
        stack.printStackElements();
        System.out.println("Top pointer is at " + stack.getStackSize() + " pointing at " + stack.stackArray[stack.topIndex]);
        stack.push(5);
        stack.pop();
        stack.push(6);
        stack.push(7);
        stack.push(2);
        stack.pop();
        stack.push(1);
        stack.push(7);
        System.out.println("Stack:");
        stack.printStackElements();
        System.out.println();
        System.out.println("Stack dynamically implemented successfully.");
    }
}
