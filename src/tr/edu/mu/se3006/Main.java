package tr.edu.mu.se3006;

import tr.edu.mu.se3006.business.OrderService;
import tr.edu.mu.se3006.persistence.ProductRepository;
import tr.edu.mu.se3006.presentation.OrderController;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("System Starting.\n");
        
        ProductRepository productRepository = new ProductRepository();
        OrderService orderService = new OrderService(productRepository);
        OrderController orderController = new OrderController(orderService);
        
        System.out.println(" Test Scenarios ");
        
        orderController.handleUserRequest(1L, 2);
        orderController.handleUserRequest(2L, 25);
        orderController.handleUserRequest(99L, 1);
    }
}

