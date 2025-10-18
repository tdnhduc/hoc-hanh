import java.sql.SQLOutput;

public class test_stack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.get(); // => vi tri dau tien cua stack
        stack.pop(); // => lay ra thang dau tien cua stack
        stack.push(5); // day zo stack neu con cho
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);

        stack.print_stack();
        System.out.println( " " + stack.get());

        stack.pop();
        stack.print_stack();

        stack.push(30);
        stack.print_stack();

    }
    public static class Stack {
        private int[] stacks;
        private  int currentSize; // dem xem thu stack co bao nhieu phan tu hien tai

        public void print_stack(){
            for(int i = 0 ; i < stacks.length ; i++){
                System.out.print(" " + stacks [i]);
            }
            System.out.println();
        }

        public Stack(int size) {
            this.stacks = new int[5];
        }

        public int get() {
            return stacks[currentSize] --;
        }

        public int pop() {
            stacks[currentSize] = -1;
            currentSize --;
            return -1;
        }

        public int push(int value) {
            if (this.currentSize < this.stacks.length) {
                // allow to push
                currentSize ++;
                stacks[currentSize] = value;
            }
            return -1;
        }
    }
}
