package io.github.dklota.inventory_checker;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/inventory")
public class InventoryCheckerController {
    // implement GET method to retrieve components in JSON
    private final InventoryService inventoryService;

    // Spring auto-injects our service
    public InventoryCheckerController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{requestedSku}")
    private ResponseEntity<InventoryItem> findBySku(@PathVariable String requestedSku) {
        //InventoryItem inventoryItem = ;
        return inventoryService.getItemBySku(requestedSku).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
