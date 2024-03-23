import java.util.List;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.lang.Throwable;

public class Stack<T> {
    public T[] stack;

    public Stack() {
        this.stack = (T[]) new Object[0];
    }

    public void push(T value) {
        if (value != null) {
            int updatedArrayLength = stack.length + 1;
            T[] updatedStack = (T[]) new Object[updatedArrayLength];
            System.arraycopy(stack, 0, updatedStack, 0, stack.length);
            updatedStack[updatedArrayLength - 1] = value;
            this.stack = updatedStack;
        }
    }

    public T peek() {
        return stack[stack.length - 1];
    }

    public T pop() {
        if (stack.length == 0) {
            throw new EmptyStackException();
        }
        T deletingElement = stack[stack.length - 1];
        int updatedArrayLength = stack.length - 1;
        T[] updatedStack = (T[]) new Object[updatedArrayLength];
        System.arraycopy(stack, 0, updatedStack, 0, stack.length - 1);
        this.stack = updatedStack;
        return deletingElement;
    }

    public int size() {
        return stack.length;
    }
}