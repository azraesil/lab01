package tr.edu.mu.se3006.business;

import tr.edu.mu.se3006.domain.Order;
import tr.edu.mu.se3006.domain.Product;
import tr.edu.mu.se3006.persistence.ProductRepository;

public class OrderService {

    private final ProductRepository productRepository;

    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void placeOrder(Long productId, int quantity) {
        
        Product product = productRepository.findById(productId);

        if (product == null) {
            throw new IllegalArgumentException("Ürün bulunamadı!");
        }

        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("Yetersiz stok! Mevcut ürün: " + product.getName());
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        Order order = new Order(productId, quantity);
    }
}
