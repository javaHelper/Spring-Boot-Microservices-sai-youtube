# Circuit Breaker 

<img width="1510" alt="Screenshot 2022-06-10 at 11 15 50 PM" src="https://user-images.githubusercontent.com/54174687/173128582-52fc09ce-0bce-4a4f-a0fe-66ca596d7d36.png">

GET -> `http://localhost:60008/actuator`

Response:

```json
{
    "_links": {
        "self": {
            "href": "http://localhost:60008/actuator",
            "templated": false
        },
        "circuitbreakers-name": {
            "href": "http://localhost:60008/actuator/circuitbreakers/{name}",
            "templated": true
        },
        "circuitbreakers": {
            "href": "http://localhost:60008/actuator/circuitbreakers",
            "templated": false
        },
        "circuitbreakerevents": {
            "href": "http://localhost:60008/actuator/circuitbreakerevents",
            "templated": false
        },
        "circuitbreakerevents-name": {
            "href": "http://localhost:60008/actuator/circuitbreakerevents/{name}",
            "templated": true
        },
        "circuitbreakerevents-name-eventType": {
            "href": "http://localhost:60008/actuator/circuitbreakerevents/{name}/{eventType}",
            "templated": true
        },
        "ratelimiters": {
            "href": "http://localhost:60008/actuator/ratelimiters",
            "templated": false
        },
        "ratelimiterevents": {
            "href": "http://localhost:60008/actuator/ratelimiterevents",
            "templated": false
        },
        "ratelimiterevents-name": {
            "href": "http://localhost:60008/actuator/ratelimiterevents/{name}",
            "templated": true
        },
        "ratelimiterevents-name-eventType": {
            "href": "http://localhost:60008/actuator/ratelimiterevents/{name}/{eventType}",
            "templated": true
        },
        "retries": {
            "href": "http://localhost:60008/actuator/retries",
            "templated": false
        },
        "retryevents": {
            "href": "http://localhost:60008/actuator/retryevents",
            "templated": false
        },
        "retryevents-name": {
            "href": "http://localhost:60008/actuator/retryevents/{name}",
            "templated": true
        },
        "retryevents-name-eventType": {
            "href": "http://localhost:60008/actuator/retryevents/{name}/{eventType}",
            "templated": true
        },
        "timelimiters": {
            "href": "http://localhost:60008/actuator/timelimiters",
            "templated": false
        },
        "timelimiterevents": {
            "href": "http://localhost:60008/actuator/timelimiterevents",
            "templated": false
        },
        "timelimiterevents-name": {
            "href": "http://localhost:60008/actuator/timelimiterevents/{name}",
            "templated": true
        },
        "timelimiterevents-name-eventType": {
            "href": "http://localhost:60008/actuator/timelimiterevents/{name}/{eventType}",
            "templated": true
        },
        "beans": {
            "href": "http://localhost:60008/actuator/beans",
            "templated": false
        },
        "caches": {
            "href": "http://localhost:60008/actuator/caches",
            "templated": false
        },
        "caches-cache": {
            "href": "http://localhost:60008/actuator/caches/{cache}",
            "templated": true
        },
        "health-path": {
            "href": "http://localhost:60008/actuator/health/{*path}",
            "templated": true
        },
        "health": {
            "href": "http://localhost:60008/actuator/health",
            "templated": false
        },
        "info": {
            "href": "http://localhost:60008/actuator/info",
            "templated": false
        },
        "conditions": {
            "href": "http://localhost:60008/actuator/conditions",
            "templated": false
        },
        "configprops": {
            "href": "http://localhost:60008/actuator/configprops",
            "templated": false
        },
        "configprops-prefix": {
            "href": "http://localhost:60008/actuator/configprops/{prefix}",
            "templated": true
        },
        "env-toMatch": {
            "href": "http://localhost:60008/actuator/env/{toMatch}",
            "templated": true
        },
        "env": {
            "href": "http://localhost:60008/actuator/env",
            "templated": false
        },
        "loggers-name": {
            "href": "http://localhost:60008/actuator/loggers/{name}",
            "templated": true
        },
        "loggers": {
            "href": "http://localhost:60008/actuator/loggers",
            "templated": false
        },
        "heapdump": {
            "href": "http://localhost:60008/actuator/heapdump",
            "templated": false
        },
        "threaddump": {
            "href": "http://localhost:60008/actuator/threaddump",
            "templated": false
        },
        "metrics": {
            "href": "http://localhost:60008/actuator/metrics",
            "templated": false
        },
        "metrics-requiredMetricName": {
            "href": "http://localhost:60008/actuator/metrics/{requiredMetricName}",
            "templated": true
        },
        "scheduledtasks": {
            "href": "http://localhost:60008/actuator/scheduledtasks",
            "templated": false
        },
        "mappings": {
            "href": "http://localhost:60008/actuator/mappings",
            "templated": false
        },
        "refresh": {
            "href": "http://localhost:60008/actuator/refresh",
            "templated": false
        },
        "features": {
            "href": "http://localhost:60008/actuator/features",
            "templated": false
        },
        "serviceregistry": {
            "href": "http://localhost:60008/actuator/serviceregistry",
            "templated": false
        }
    }
}
```
GET -> `http://localhost:60008/actuator/circuitbreakerevents`

Response:

```json
{
    "circuitBreakerEvents": [
        {
            "circuitBreakerName": "inventory",
            "type": "ERROR",
            "creationTime": "2022-06-11T00:02:36.324080+05:30[Asia/Kolkata]",
            "errorMessage": "java.util.concurrent.TimeoutException: TimeLimiter 'inventory' recorded a timeout exception.",
            "durationInMs": 3027,
            "stateTransition": null
        },
        {
            "circuitBreakerName": "inventory",
            "type": "ERROR",
            "creationTime": "2022-06-11T00:02:44.359318+05:30[Asia/Kolkata]",
            "errorMessage": "java.util.concurrent.TimeoutException: TimeLimiter 'inventory' recorded a timeout exception.",
            "durationInMs": 3010,
            "stateTransition": null
        },
        {
            "circuitBreakerName": "inventory",
            "type": "ERROR",
            "creationTime": "2022-06-11T00:02:52.373025+05:30[Asia/Kolkata]",
            "errorMessage": "java.util.concurrent.TimeoutException: TimeLimiter 'inventory' recorded a timeout exception.",
            "durationInMs": 3007,
            "stateTransition": null
        }
    ]
}
```

GET -> `http://localhost:60008/actuator/retryevents`

```json
{
    "retryEvents": [
        {
            "retryName": "inventory",
            "type": "RETRY",
            "creationTime": "2022-06-11T00:02:36.339686+05:30[Asia/Kolkata]",
            "errorMessage": "java.util.concurrent.TimeoutException: TimeLimiter 'inventory' recorded a timeout exception.",
            "numberOfAttempts": 1
        },
        {
            "retryName": "inventory",
            "type": "RETRY",
            "creationTime": "2022-06-11T00:02:44.359845+05:30[Asia/Kolkata]",
            "errorMessage": "java.util.concurrent.TimeoutException: TimeLimiter 'inventory' recorded a timeout exception.",
            "numberOfAttempts": 2
        },
        {
            "retryName": "inventory",
            "type": "ERROR",
            "creationTime": "2022-06-11T00:02:52.379311+05:30[Asia/Kolkata]",
            "errorMessage": "java.util.concurrent.TimeoutException: TimeLimiter 'inventory' recorded a timeout exception.",
            "numberOfAttempts": 3
        }
    ]
}
```

GET -> `http://localhost:60008/actuator/timelimiterevents`

Response:

```json
{
    "timeLimiterEvents": [
        {
            "timeLimiterName": "inventory",
            "type": "TIMEOUT",
            "creationTime": "2022-06-11T00:02:36.320120+05:30[Asia/Kolkata]"
        },
        {
            "timeLimiterName": "inventory",
            "type": "TIMEOUT",
            "creationTime": "2022-06-11T00:02:44.358453+05:30[Asia/Kolkata]"
        },
        {
            "timeLimiterName": "inventory",
            "type": "TIMEOUT",
            "creationTime": "2022-06-11T00:02:52.372326+05:30[Asia/Kolkata]"
        }
    ]
}
```

