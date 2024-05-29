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

public class CustomKafkaConsumerConfigBuilder {

    Properties properties = new Properties();
    private CustomKafkaConsumerConfigBuilder(KafkaBuilder builder) {
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

        public KafkaBuilder(List<String> bootstrapServersList, String groupId,
                KEY_DESERIALIZER_CONFIG keyDeserializerConfig, VALUE_DESERIALIZER_CONFIG valueDeserializerConfig) {

            BOOTSTRAP_SERVER_LIST(bootstrapServersList).GROUP_ID(groupId)
                    .KEY_DESERIALIZER_CLASS_CONFIG(keyDeserializerConfig)
                    .VALUE_DESERIALIZER_CLASS_CONFIG(valueDeserializerConfig);
        }

        public KafkaBuilder BOOTSTRAP_SERVER_LIST(List<String> bootstrapServersList) {
            StringJoiner stringJoiner = new StringJoiner(",");
            bootstrapServersList.forEach(stringJoiner::add);
            String boostrapServers = stringJoiner.toString();

            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServers);
            return this;
        }
        public KafkaBuilder GROUP_ID(String groupId) {
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            return this;
        }

        public KafkaBuilder AUTO_OFFSET_RESET_CONFIG(AUTO_OFFSET_RESET value) {
            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
                    AUTO_OFFSET_RESET.valueOf(value.name()).value.toString());
            return this;
        }
        public KafkaBuilder KEY_DESERIALIZER_CLASS_CONFIG(KEY_DESERIALIZER_CONFIG value) {
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                    KEY_DESERIALIZER_CONFIG.valueOf(value.name()).value.toString());
            return this;
        }
        public KafkaBuilder VALUE_DESERIALIZER_CLASS_CONFIG(VALUE_DESERIALIZER_CONFIG value) {
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                    KEY_DESERIALIZER_CONFIG.valueOf(value.name()).value.toString());
            return this;
        }

        public KafkaBuilder REBALANCING_TIME(int sessionTimeout, int heartbeatInterval) {
            int threshold = (int) Math.floor((heartbeatInterval / 3));
            if (sessionTimeout < threshold) {
                logger.info("Session Timeout Interval should be 1/3 of Heartbeat Interval MS");
            }
            properties.setProperty(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, String.valueOf(sessionTimeout));
            properties.setProperty(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, String.valueOf(heartbeatInterval));

            return this;
        }
        public KafkaBuilder BALANCED_REBALANCING_TIME(int sessionTimeout) {
            properties.setProperty(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, String.valueOf(sessionTimeout));
            properties.setProperty(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, String.valueOf(sessionTimeout*3));
            return this;
        }
        public KafkaBuilder readFromLatestOffset(boolean readFromLatestOffset) {
            if(readFromLatestOffset){
                properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, AUTO_OFFSET_RESET.LATEST.value);
            } else {
                properties.setProperty(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, AUTO_OFFSET_RESET.EARLIEST.value);
            }
            return this;
        }

        public Properties build() {
            return properties;
        }

    }

}
