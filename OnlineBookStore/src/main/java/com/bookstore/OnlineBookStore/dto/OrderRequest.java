package com.bookstore.OnlineBookStore.dto;

import com.bookstore.OnlineBookStore.model.Cart;
import java.util.List;

public class OrderRequest {
    private String userEmail;
    private List<Cart> items;
    private float totalAmount;
    private String paymentMethod;

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public List<Cart> getItems() { return items; }
    public void setItems(List<Cart> items) { this.items = items; }

    public float getTotalAmount() { return totalAmount; }
    public void setTotalAmount(float totalAmount) { this.totalAmount = totalAmount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
