# order-service

POST

```sh
curl --location --request POST 'http://localhost:8092/api/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "orderLineItemsDtoList": [
        {
            "skuCode": "iphone_13",
            "price": 1200,
            "quantity": 1
        }
    ]
}'
```