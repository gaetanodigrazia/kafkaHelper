package com.digrazia.KafkaHelper.enumeration;

public enum VALUE_SERIALIZER_CONFIG {
    BOOLEAN_SERIALIZER("org.apache.kafka.common.serialization.BooleanSerializer.class"),
    BYTE_ARRAY_SERIALIZER("org.apache.kafka.common.serialization.ByteArraySerializer.class"),
    BYTE_BUFFER_SERIALIZER("org.apache.kafka.common.serialization.ByteBufferSerializer.class"),
    BYTE_SERIALIZER("org.apache.kafka.common.serialization.ByteSerializer.class"),
    DOUBLE_SERIALIZER("org.apache.kafka.common.serialization.DoubleSerializer.class"),
    FLOAT_SERIALIZER("org.apache.kafka.common.serialization.FloatSerializer.class"),
    INTEGER_SERIALIZER("org.apache.kafka.common.serialization.IntegerSerializer.class"),
    LIST_SERIALIZER("org.apache.kafka.common.serialization.ListSerializer.class"),
    LONG_SERIALIZER("org.apache.kafka.common.serialization.LongSerializer.class"),
    AVRO_SERIALIZER("org.apache.kafka.common.serialization.KafkaAvroSerializer.class"),
    STRING_SERIALIZER("org.apache.kafka.common.serialization.StringSerializer.class");

    private final String value;

    VALUE_SERIALIZER_CONFIG(String actualValue) {
        value = actualValue;
    }
}

