class Stk
{
    public final int[] arr;
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
        System.exit(1);
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
    Stk stack = new Stk(8);

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

}





}