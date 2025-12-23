package com.bookstore.OnlineBookStore.designpatterns.state;

public class OrderContext {
    private OrderState state;

    public void setState(OrderState state) {
        this.state = state;
    }

    public String applyState() {
        return state.updateStatus();
    }
}
