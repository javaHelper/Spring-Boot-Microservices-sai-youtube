# product-service

POST -> 

```sh
curl --location --request POST 'http://localhost:8090/api/product' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name" :"Iphone 13",
    "description": "iphone 13",
    "price" : 1200
}'
```

GET -> `http://localhost:8090/api/product`

```json
[
    {
        "id": "62a22e5554c7c8619bf05aa8",
        "name": "Iphone 13",
        "description": "iphone 13",
        "price": 1200
    }
]
```