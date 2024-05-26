class Stk
{
    public int[] arr;
    public int top;
    public int capacity;
    Stk(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
public void push(int x)
{
    if(isFull())
    {
        System.out.println("Stack is full!");
        expandArray();
        System.out.println("Stack expanded");
    }
    else
    {
        arr[++top] = x;
    }
}
public int pop()
{
    if(isEmpty())
    {
        System.out.println("Underflow!");
        System.exit(1);
    }

    return arr[top--];

}
public int getSize()
{
    return top+1;
}
public boolean isFull()
{
    return top==capacity-1;
}
public void expandArray()
{
    int curr_size = top+1;
    int[] new_array = new int[curr_size*2];
    for ( int i=0 ; i < curr_size; i++ )
    {
        new_array[i] = arr[i];

    }
    arr = new_array;
    capacity = new_array.length;
}
public boolean isEmpty()
{
    return top == -1;
}
public void printStk()
{
    for(int i = 0; i <= top; i++)
    {
        System.out.println(" "+arr[i]);
    }
}
public static void main(String[] args)
{
    Stk stack = new Stk(5);

    stack.push(9);
    stack.push(2);
    stack.push(1);
    System.out.println(("Stack: "));
    stack.printStk();
    System.out.println("Top pointer is at "+stack.getSize()+ " pointing at "+ stack.arr[stack.top]);
    stack.push(5);
    stack.pop();
    stack.push(6);
    stack.push(7);
    stack.push(2);
    stack.pop();
    stack.push(1);
    stack.push(7);
    System.out.println(("Stack: "));
    stack.printStk();
    System.out.println();
    System.out.println("Stack dynamically implemented successfully.");

}





}