package io.github.dklota.inventory_checker;

import tools.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final ObjectMapper objectMapper;
    private List<InventoryItem> inventoryItems = new ArrayList<>();

    public InventoryService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadInventory() {
        try {
            ClassPathResource resource = new ClassPathResource("inventory.json");
            try (InputStream inputStream = resource.getInputStream()) {
                inventoryItems = objectMapper.readValue(
                    inputStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, InventoryItem.class)
                );
                System.out.println("Successfully loaded " + inventoryItems.size() + " inventory items.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to load inventory.json!");
        }
    }

    public Optional<InventoryItem> getItemBySku(String sku) {
        return inventoryItems.stream()
            .filter(item -> item.sku().equalsIgnoreCase(sku))
            .findFirst();
    }
}
