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
        if (stackIsFull()) {
            expandArray();
        }
        stackArray[++topIndex] = element;
    }

    public int pop() {
        if (stackIsEmpty()) {
            throw new StackUnderflowException("Stack Underflow! Can't pop from an empty Stack.");
        }
        return stackArray[topIndex--];
    }

    public int getStackSize() {
        return topIndex + 1;
    }

    public boolean stackIsFull() {
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

    public boolean stackIsEmpty() {
        return topIndex == -1;
    }

    public void printStackElements() {
        for (int i = 0; i <= topIndex; i++) {
            System.out.println(" " + stackArray[i]);
        }
    }

    static CustomStack stack = new CustomStack();

    static void insertAtBottom(int item) {
        if (stack.stackIsEmpty()) {
            stack.push(item);
        } else {
            int element = stack.pop();
            insertAtBottom(item);
            stack.push(element);
        }
    }

    static void reverse() {
        if (!stack.stackIsEmpty()) {
            int element = stack.pop();
            reverse();
            insertAtBottom(element);
        }
    }

    public static class CustomQueue extends CustomStack {
        void enQueue(int item) {
            stack.push(item);
            System.out.println("After insertion of " + item + " in Queue: ");
            stack.printStackElements();
        }

        void deQueue()
        {
            if (stack.stackIsEmpty())
            {
                throw new StackUnderflowException("Queue Underflow! Can't dequeue from an empty Queue.");
            }
            CustomStack.reverse();
            stack.pop();
            System.out.println("After deletion in Queue: ");
            CustomStack.reverse();
            stack.printStackElements();
        }


        public static void main(String[] args) {
            try
            {
                CustomQueue queue = new CustomQueue();
                queue.enQueue(2);
                queue.enQueue(1);
                queue.enQueue(4);
                queue.enQueue(6);
                queue.enQueue(8);
                queue.deQueue();
            }
            catch (StackUnderflowException e)
            {
                System.out.println(e.getMessage());
            }


        }
    }
}
    class StackUnderflowException extends RuntimeException
    {
        public StackUnderflowException(String message)
        {
            super(message);
        }
    }

//Space Complexity: O(n)
//Time Complexity: O(n)