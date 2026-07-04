package io.github.dklota.inventory_checker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
class InventoryCheckerApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void returnInventoryItemInfo() {
        ResponseEntity<String> response = restTemplate.getForEntity("/inventory/ELE-402", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

assertThat(response.getBody()).contains("Wireless Ergonomic Mouse");

        System.out.println(">>> API RESPONSE BODY: " + response.getBody());
    }

}
