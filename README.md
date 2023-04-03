# Insurance-Management-Platform---Spring-Boot
REST API that fetch Clients, Claims and Policies using Spring Boot

In this project I have three entities Client, Claim and Policies.
I have developed REST Controller to perform CRUD operations
Used Spring JPA Repository in DAO
Implemented Global Exception handling to handle all bad requests.
I have also written unit tests for all the REST Controller methods using JUnit and Mockito

Some accetable endpoints are : 
a. Clients:
i. GET /api/clients: Fetch all clients.
ii. GET /api/clients/{id}: Fetch a specific client by ID.
iii. POST /api/clients: Create a new client.
iv. PUT /api/clients/{id}: Update a client's information.
v. DELETE /api/clients/{id}: Delete a client.
b. Insurance Policies:
i. GET /api/policies: Fetch all insurance policies.
ii. GET /api/policies/{id}: Fetch a specific insurance policy by ID.
iii. POST /api/policies: Create a new insurance policy.
iv. PUT /api/policies/{id}: Update an insurance policy.
v. DELETE /api/policies/{id}: Delete an insurance policy.
c. Claims:
i. GET /api/claims: Fetch all claims.
ii. GET /api/claims/{id}: Fetch a specific claim by ID.
iii. POST /api/claims: Create a new claim.
iv. PUT /api/claims/{id}: Update a claim's information.
v. DELETE /api/claims/{id}: Delete a claim
