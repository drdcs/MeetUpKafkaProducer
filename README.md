# Building a Kafka Producer through Java.

## What will you Learn ?

* Buiding a Json to Pojo.
* Leverage JSON serializer.
* Kafka Producer(java) build.

### Building a Json to Pojo

Bring out the Json as mentioned below and paste: http://www.jsonschema2pojo.org/

```json
{
  "venue": {
    "venue_name": "16109 Nacogdoches Rd",
    "lon": -98.36081,
    "lat": 29.587322,
    "venue_id": 26466187
  },
  "visibility": "public",
  "response": "yes",
  "guests": 0,
  "member": {
    "member_id": 200069824,
    "photo": "https://secure.meetupstatic.com/photos/member/e/9/e/c/thumb_254039884.jpeg",
    "member_name": "Debbie LaBouff Burnam"
  },
  "rsvp_id": 1840421555,
  "mtime": 1591671730500,
  "event": {
    "event_name": "SISTA's @ Pompeii ",
    "event_id": "tbhmgrybcjbnb",
    "time": 1591806600000,
    "event_url": "https://www.meetup.com/meetup-group-VVwOORPh/events/271065743/"
  },
  "group": {
    "group_topics": [
      {
        "urlkey": "smallbiz",
        "topic_name": "Small Business"
      },
      {
        "urlkey": "business-referral-networking",
        "topic_name": "Business Referral Networking"
      },
      {
        "urlkey": "women-entrepreneurs",
        "topic_name": "Women Entrepreneurs"
      },
      {
        "urlkey": "business-strategy",
        "topic_name": "Business Strategy"
      },
      {
        "urlkey": "professional-women",
        "topic_name": "Professional Women"
      },
      {
        "urlkey": "professional-networking",
        "topic_name": "Professional Networking"
      },
      {
        "urlkey": "womens-business-networking",
        "topic_name": "Women's Business Networking"
      },
      {
        "urlkey": "womens-networking",
        "topic_name": "Women's Networking"
      },
      {
        "urlkey": "networking-your-network-marketing-business",
        "topic_name": "Networking Your Network Marketing Business"
      }
    ],
    "group_city": "San Antonio",
    "group_country": "us",
    "group_id": 32201506,
    "group_name": "Sista's",
    "group_lon": -98.47,
    "group_urlname": "meetup-group-VVwOORPh",
    "group_state": "TX",
    "group_lat": 29.48
  }
}
```
>> We can see the above json would have child json, Array (which bring down to new classes ) and pass as a class object to the main class MeetUp.This is one of the easiest way to write the Jackson to Pojo.

 
![JSON POJO CONVERTER](/images/test.png)


### Json Serialization
```text
The Producer API allows applications to send streams of data to topics in the Kafka cluster.Here we are using a json serializer which is same for all json type SerDe.
Th serde in our case accepts json through the jackson object mapper.

```

Now we can update the same in runner class where we need to mention the serialization method.
```java
Properties properties = new Properties();
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs.applicationID);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
```
Initialize KafkaProducer and  we can send data as a producer record.
