package Stack;

import java.util.Stack;

public class InsertAtBottom {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        int idx = 2;
        int x = 7;
        Stack<Integer> stack1 = new Stack<>();
        while(stack.size()>idx){
            stack1.push(stack.pop());
        }
        stack.push(x);
        while(!stack1.isEmpty()){
            stack.push(stack1.pop());
        }
        System.out.println(stack);
    }
}