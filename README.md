# inventory-checker

## goal
The goal of this inventory service is to use kafka, springboot, and docker to track inventory based on orders made in real time. 

## Phase 1: Start with a text file
Set up a text file containing dummy data about the inventory of items stored.

### inventory.csv
Contains 10 items with the following fields:
- SKU
- Item_Name
- Category 
- Quantity_On_Hand
- Reorder_Point 
- Unit_Cost
- Selling_Price 
- Storage_Location 
- Supplier_Name 
- Last_Updated

## Phase 2: Springboot with local db
Use database to run local application using Springboot. What is the service class, respository, model class, controller? Understand how all these work together. 

## Phase 3: API Call with GCP db
Build an API that calls on the db and sends back what the user inputted. Then, check to see if an order is good to be fulfilled. Use postman for API calls.

## Phase 4: Use Kafka API
Use the Kafka API to publish a message, which would contain information about the item in inventory. 

CI/CD Circle CI Jenkins 

## Phase 5: Docker
Now that the application is complete, containerize in Docker and see how it works.

