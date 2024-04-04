package com.quid.spring3.jdbcClient;

import com.quid.specifications.domain.Product;
import java.util.List;
import org.junit.jupiter.api.Test;

class JdbClientServiceTest {

    @Test
    void testGetJdbc() {
        JdbClientService jdbClientService = new JdbClientService();
        List<Product> products = jdbClientService.getProducts();

        System.out.println(products);
    }

}