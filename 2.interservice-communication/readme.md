# Interservice comminication

POST ->

```sh
curl --location --request POST 'http://localhost:8091/api/order' \
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

Response

<img width="894" alt="Screenshot 2022-06-10 at 12 50 42 AM" src="https://user-images.githubusercontent.com/54174687/172927628-50c7422a-b1ec-41cd-b6cf-a97306eb1f14.png">
