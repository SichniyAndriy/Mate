package mate.academy.service;

import mate.academy.model.Order;

public interface OrderService {
    Order completeOrder(Long userId);
}
