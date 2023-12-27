class CustomStack {
    int top;
    char[] arr = new char[20];

    CustomStack() {
        top = 0;
    }

    boolean isEmpty() {
        return (top == 0);
    }

    void push(char x) {
        if (top >= 19) {
            System.out.println("Stack overflow");
        } else {
            arr[++top] = x;
            System.out.println(x + " Element pushed");
        }
    }

    char pop() {
        if (top <= 0) {
            System.out.println("Underflow condition");
            return '\0';
        } else {
            return arr[top--];
        }
    }

    char peek() {
        if (top >= 0) {
            return arr[top];
        } else {
            System.out.println("Stack is empty");
            return '\0';
        }
    }

    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}

public class Infix_Postfix extends CustomStack {
    static CustomStack s = new CustomStack();

    static int Prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String intopost(String exp) {
        StringBuilder op = new StringBuilder();

        for (int i = 0; i < exp.length(); ++i) {
            char t = exp.charAt(i);

            if (Character.isAlphabetic(t) || Character.isDigit(t)) {
                op.append(t);
            } else if (t == '(') {
                s.push(t);
            } else if (t == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    op.append(s.pop());
                }
                s.pop();
            } else {
                while (!s.isEmpty() && Prec(t) <= Prec(s.peek())) {
                    op.append(s.pop());
                }
                s.push(t);
            }
        }

        while (s.isEmpty()) { // Error 5: Change to while (!s.isEmpty())
            if (s.peek() == '(') {
                return "Invalid Expression";
            }
            op.append(s.pop());
        }

        return op.toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println(intopost(exp));
    }
}
