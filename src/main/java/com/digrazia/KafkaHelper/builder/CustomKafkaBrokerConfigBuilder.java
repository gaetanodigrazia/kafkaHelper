package com.digrazia.KafkaHelper.builder;


import com.digrazia.KafkaHelper.enumeration.AUTO_OFFSET_RESET;
import com.digrazia.KafkaHelper.enumeration.KEY_DESERIALIZER_CONFIG;
import com.digrazia.KafkaHelper.enumeration.LOSS_TOLERANCE;
import com.digrazia.KafkaHelper.enumeration.VALUE_DESERIALIZER_CONFIG;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;
import java.util.concurrent.ExecutionException;

public class CustomKafkaBrokerConfigBuilder {

    Properties properties = new Properties();
    private CustomKafkaBrokerConfigBuilder(KafkaBuilder builder) {
        this.properties = builder.properties;
    }

    //Builder Class
    public static class KafkaBuilder {
        private static Logger logger = LoggerFactory.getLogger(KafkaBuilder.class);

        Properties properties = new Properties();

        /*
        These are required config parameters
         */
        private String HDD;
        private String RAM;

        /*
        These are optional config parameters
         */
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        protected KafkaBuilder() {
        }
        public KafkaBuilder lostOffsetAfter(int amountTimeInMinutes) {
            properties.setProperty("offset.retention.minutes", String.valueOf(amountTimeInMinutes));
            return this;
        }
        public Properties build() {
            return properties;
        }

    }

}
