# Security in Microservices

- Sequence to start the services - 

- discovery-service
- inventory-service
- order-service
- product-service
- api-gateway

# Keycloak

`docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev`

<img width="1232" alt="Screenshot 2022-06-10 at 11 10 08 PM" src="https://user-images.githubusercontent.com/54174687/173121582-30b299ed-b267-43cc-84b2-aca2a34be8b4.png">

<img width="1506" alt="Screenshot 2022-06-10 at 11 10 39 PM" src="https://user-images.githubusercontent.com/54174687/173121691-7f8e6609-8e64-4998-8a01-ca8fdc04c70c.png">


<img width="1342" alt="Screenshot 2022-06-10 at 11 11 31 PM" src="https://user-images.githubusercontent.com/54174687/173121780-7164e0e7-506a-4584-8016-4f636c0d63fb.png">

<img width="1335" alt="Screenshot 2022-06-10 at 11 12 01 PM" src="https://user-images.githubusercontent.com/54174687/173121862-2269028a-470e-4ceb-b960-9d341fbfc7c4.png">

# Step to Create Toke

- Token Name = token
- Grant Type = client Credentials
- Access Token URL = http://localhost:8080/realms/spring-boot-microservices-realm/protocol/openid-connect/token
- Client Id = spring-cloud-client
- Client Secrete = BxvZSljdSK6PDY9eSUC8BFy5wiTE1tw7
- Scope = openid offline_access

Make the HTTP GET and POST Request over endpoint

<img width="1014" alt="Screenshot 2022-06-10 at 11 14 24 PM" src="https://user-images.githubusercontent.com/54174687/173122337-bfac9175-5581-4dc9-9ddd-f7fcb6a37463.png">

Enter Username/password = eureka/password (this is set in code)

<img width="1510" alt="Screenshot 2022-06-10 at 11 15 50 PM" src="https://user-images.githubusercontent.com/54174687/173122506-5101af09-aa01-4543-80a0-c474a959b5d0.png">

