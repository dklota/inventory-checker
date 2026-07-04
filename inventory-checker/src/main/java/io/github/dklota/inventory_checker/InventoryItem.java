package io.github.dklota.inventory_checker;
import 
com.fasterxml.jackson.annotation.JsonProperty;

public record InventoryItem(@JsonProperty("SKU") String sku, @JsonProperty("Item_Name") String itemName, @JsonProperty("Category") String category, @JsonProperty("Quantity_On_Hand") Integer quantityOnHand, @JsonProperty("Reorder_Point") Integer reorderPoint, @JsonProperty("Unit_Cost") Double unitCost, @JsonProperty("Selling_Price") Double sellingPrice, @JsonProperty("Storage_Location") String storageLocation, @JsonProperty("Supplier_Name") String supplierName, @JsonProperty("Last_Updated") String lastUpdated) {
}
