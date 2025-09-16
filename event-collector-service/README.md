#### Sample Request for /track api (http://localhost:8080/track) : takes a responsebody(EventRequest)
```
{
  "websiteId": 101,
  "eventType": "CLICK",
  "eventData": {
    "eventInfo": [
      {
        "elementId": "btn-login",
        "pageUrl": "/login",
        "x": 120,
        "y": 250
      },
      {
        "browser": "Chrome",
        "os": "Windows 11"
      }
    ]
  }
}
```

#### Check the kafka-container to check this added event into the topic
```
docker ps
CONTAINER ID IMAGE COMMAND CREATED STATUS PORTS NAMES
f152a3f3e767 confluentinc/cp-kafka:7.6.0 "/etc/confluent/dock…" 7 minutes ago Up 7 minutes 0.0.0.0:9092->9092/tcp, [::]:9092->9092/tcp, 0.0.0.0:29092->29092/tcp, [::]:29092->29092/tcp kafka
28b50d7b302f confluentinc/cp-zookeeper:7.6.0 "/etc/confluent/dock…" 7 minutes ago Up 7 minutes 0.0.0.0:2181->2181/tcp, [::]:2181->2181/tcp zookeeper
```

#### Go into the kafka-container to check the events in the topic
```
docker exec -it kafka bash
```

#### Check all the kafka-acls in the /usr/bin
```
ls /usr/bin | grep kafka-
```

#### List the kafka-topics
```
/usr/bin/kafka-topics --list --bootstrap-server localhost:9092
```

#### Get all unconsumed events from the given topic(we get back the json(s) which are still not consumed)
```
/usr/bin/kafka-console-consumer \
 --bootstrap-server localhost:9092 \
 --topic clickstream-events \
 --from-beginning
```
