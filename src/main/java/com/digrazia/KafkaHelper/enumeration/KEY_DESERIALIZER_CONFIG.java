package com.digrazia.KafkaHelper.enumeration;

public enum KEY_DESERIALIZER_CONFIG {
    BOOLEAN_DESERIALIZER("org.apache.kafka.common.serialization.BooleanDeserializer.class"),
    BYTE_ARRAY_DESERIALIZER("org.apache.kafka.common.serialization.ByteArrayDeserializer.class"),
    BYTE_BUFFER_DESERIALIZER("org.apache.kafka.common.serialization.ByteBufferDeserializer.class"),
    BYTE_DESERIALIZER("org.apache.kafka.common.serialization.ByteDeserializer.class"),
    DOUBLE_DESERIALIZER("org.apache.kafka.common.serialization.DoubleDeserializer.class"),
    FLOAT_DESERIALIZER("org.apache.kafka.common.serialization.FloatDeserializer.class"),
    INTEGER_DESERIALIZER("org.apache.kafka.common.serialization.IntegerDeserializer.class"),
    LIST_DESERIALIZER("org.apache.kafka.common.serialization.ListDeserializer.class"),
    LONG_DESERIALIZER("org.apache.kafka.common.serialization.LongDeserializer.class"),
    STRING_DESERIALIZER("org.apache.kafka.common.serialization.StringDeserializer");


    public final String value;

    KEY_DESERIALIZER_CONFIG(String actualValue) {
        value = actualValue;
    }
}

