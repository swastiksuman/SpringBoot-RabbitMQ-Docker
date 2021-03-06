package rabbit.example.springbootrabbit.listeners;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import rabbit.example.springbootrabbit.domains.Product;
import rabbit.example.springbootrabbit.repository.ProductRepository;

@Component
public class ProductMessageListener {

    private ProductRepository productRepository;

    private static final Logger log = Logger.getLogger(ProductMessageListener.class);

    public ProductMessageListener(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * This method is invoked whenever any new message is put in the queue.
     * See {@link guru.springframework.SpringBootRabbitMQApplication} for more details
     * @param message
     */
    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        Long id = Long.valueOf(message.get("id"));
        Product product = productRepository.findOne(id);
        product.setMessageReceived(true);
        product.setMessageCount(product.getMessageCount() + 1);

        productRepository.save(product);
        log.info("Message processed...");
    }
}
