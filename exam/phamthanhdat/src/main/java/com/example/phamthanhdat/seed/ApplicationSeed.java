package com.example.phamthanhdat.seed;


import com.example.phamthanhdat.entity.Product;
import com.example.phamthanhdat.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
//@RequiredArgsConstructor
public class ApplicationSeed implements CommandLineRunner {
    boolean seed = true;
    final ProductRepository productRepository;
    Faker faker;
    Random random = new Random();

    public ApplicationSeed(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.faker = new Faker();
    }


    @Override
    public void run(String... args) throws Exception {
        if (seed) {
            productRepository.deleteAll();
            seedProduct();
        }
    }

    private void seedProduct() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Product product = new Product();
            product.setId(String.valueOf(i));
            product.setName(faker.name().name());
            product.setPrice("1000");
            product.setQty(String.valueOf(faker.number().numberBetween(1,10)));
            productList.add(product);
        }
        productRepository.saveAll(productList);
    }

}
