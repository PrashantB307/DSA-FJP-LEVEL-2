

//   https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1

//   https://www.codingninjas.com/studio/problems/two-stacks_983634?leftPanelTab=0


class twoStacks {
    int arr[];
    int size;
    int top1, top2;

    twoStacks() {
        size = 100;
        arr = new int[100];
        top1 = -1;
        top2 = size;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        if (top1 == top2 - 1) {
            return;
        }
        top1++;
        arr[top1] = x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if (top1 == top2 - 1) {
            return;
        }
        top2--;
        arr[top2] = x;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if (top1 == -1) {
            return -1;
        }

        int val = arr[top1];
        top1--;
        return val;
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if (top2 == arr.length) {
            return -1;
        }

        int val = arr[top2];
        top2++;
        return val;
    }
}
