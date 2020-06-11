package com.demo.Runner;

import com.demo.config.AppConfigs;
import com.demo.generator.GetEvent;
import com.demo.serde.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import com.demo.types.MeetUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.Future;

public class DemoProducer {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs.applicationID);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        MeetUp meetUp = new MeetUp();
        ObjectMapper objectMapper = new ObjectMapper();
        URL data = new URL("http://stream.meetup.com/2/rsvps");

        KafkaProducer<Integer, MeetUp> kafkaProducer = new KafkaProducer<Integer, MeetUp>(properties);


        while (data != null) {
            try (BufferedReader input = new BufferedReader(
                    new InputStreamReader(data.openStream()))) {
                meetUp = objectMapper.readValue(input, meetUp.getClass());
                System.out.println(meetUp.getMember().getMemberName());
                ProducerRecord val = new ProducerRecord<String, MeetUp>("pykafka", meetUp);
                Future<RecordMetadata> recordMetadata = kafkaProducer.send(val);
            }
             kafkaProducer.close();
        }
    }
}
