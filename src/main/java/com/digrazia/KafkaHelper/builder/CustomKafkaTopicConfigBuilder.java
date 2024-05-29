package com.digrazia.KafkaHelper.builder;


import com.digrazia.KafkaHelper.enumeration.LOSS_TOLERANCE;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;
import java.util.Map;
import java.util.Properties;

public class CustomKafkaTopicConfigBuilder {

    Properties properties = new Properties();
    private CustomKafkaTopicConfigBuilder(KafkaBuilder builder) {
        this.properties = builder.properties;
    }
    public static class KafkaBuilder {
        private static Logger logger = LoggerFactory.getLogger(KafkaBuilder.class);

        Properties properties = new Properties();

        protected KafkaBuilder() {}
        public KafkaBuilder setMinInSyncReplica(int numberOfReplica) {
            properties.setProperty(TopicConfig.MIN_IN_SYNC_REPLICAS_CONFIG, String.valueOf(numberOfReplica));
            return this;
        }


        //        public KafkaBuilder setLossTolerance(Properties producerProperties,
        //                LOSS_TOLERANCE lossTolerance) {
        //            final String acksProperty = "acks";
        //            final String acksValue;
        //            if(producerProperties == null ||  producerProperties.getProperty(acksProperty) == null){
        //                throw new RuntimeException("In order to set a tolerance the producer properties"
        //                        + " must me specified and the properties acks must be setted.");
        //            }
        //            acksValue  = producerProperties.getProperty(acksProperty);
        //            EnumMap<LOSS_TOLERANCE, Runnable> enumMap = new EnumMap<>(Map.<LOSS_TOLERANCE, Runnable>of(
        //                    LOSS_TOLERANCE.NONE, noTolerance(acksValue), // 'Main', or wherever your do* methods are.
        //                    LOSS_TOLERANCE.LOW, lowTolerance(producerProperties), // 'Main', or wherever your do* methods are.
        //                    LOSS_TOLERANCE.MEDIUM, mediumTolerance(producerProperties), // 'Main', or wherever your do* methods are.
        //                    LOSS_TOLERANCE.HIGH, highTolerance(producerProperties) // 'Main', or wherever your do* methods are.
        //            ));
        //
        //            LOSS_TOLERANCE value = lossTolerance.value();
        //            enumMap.get(value).run();
        //            return this;
        //        }
        //        private KafkaBuilder noTolerance(String acksValue) {
        //            switch (acksValue){
        //                case "all":
        //                    break;
        //                case "0":
        //                    break;
        //                case "1":
        //                    break;
        //            }
        //            properties.setProperty(TopicConfig.MIN_IN_SYNC_REPLICAS_CONFIG, String.valueOf(numberOfReplica));
        //            return this;
        //        }
        //        private KafkaBuilder lowTolerance(Properties producerProperties) {
        //            return this;
        //        }
        //        private KafkaBuilder mediumTolerance(Properties producerProperties) {
        //            return this;
        //        }
        //        private KafkaBuilder highTolerance(Properties producerProperties) {
        //            return this;
        //        }

        public Properties build() {
            return properties;
        }

    }

}
