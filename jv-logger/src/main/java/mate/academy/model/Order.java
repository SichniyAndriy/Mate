package mate.academy.model;

import java.util.List;

public class Order {
    private Long orderId;
    private List<Product> products;
    private Long userId; // the identifier of user who complete the order

    public Order() {
    }

    public Order(List<Product> products, Long userId) {
        this.products = products;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
