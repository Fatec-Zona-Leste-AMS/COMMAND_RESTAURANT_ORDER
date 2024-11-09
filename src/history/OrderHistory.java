package history;

import commands.OrderCommand;
import java.util.Stack;

public class OrderHistory {
    private Stack<OrderCommand> history = new Stack<>();

    public void push(OrderCommand command) {
        history.push(command);
    }

    public OrderCommand pop() {
        return history.isEmpty() ? null : history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}