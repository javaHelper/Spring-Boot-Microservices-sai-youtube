# Event Driven Microservices using Kafka!

Spring Boot Microservices

1. Eureka - Service registry/doscovery
2. Config-server - Distributed Configurations
3. Sleuth & Zipkin - Distributed Tracing
4. DB per service
5. Resilience4J - Circuit breaker
6. Keycloak - for Auth Server
7. ELK - see logs better
8. RabbitMQ for event drive (planning for Kafka as well)

![MySQL](https://user-images.githubusercontent.com/54174687/173219377-1e04d128-8ec2-4bde-af9f-1c990d58845e.jpg)

# Eureka

`http://localhost:8761/`

<img width="1344" alt="Screenshot 2022-06-12 at 11 37 48 AM" src="https://user-images.githubusercontent.com/54174687/173219396-69d6a734-9469-47c6-923d-07a56cdb7264.png">

# Zipkin

`http://localhost:9411/`

<img width="1512" alt="Screenshot 2022-06-12 at 11 38 52 AM" src="https://user-images.githubusercontent.com/54174687/173219422-30b9f453-53a0-4251-a9f5-febea376f09d.png">

- Place the Order 

<img width="1238" alt="Screenshot 2022-06-12 at 12 19 45 PM" src="https://user-images.githubusercontent.com/54174687/173221058-cfc6348d-71d9-4d27-9662-8c2563d081b2.png">

When the order will be placed, notification will be raised by sending it through RabbitMQ and Notification will be read by notification-service

<img width="1074" alt="Screenshot 2022-06-12 at 9 06 27 PM" src="https://user-images.githubusercontent.com/54174687/173241061-89d982d7-1aa3-4229-a4c4-76a9925876f3.png">
