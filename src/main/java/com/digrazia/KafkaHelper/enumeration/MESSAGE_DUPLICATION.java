package com.digrazia.KafkaHelper.enumeration;

public enum MESSAGE_DUPLICATION {

    AVOID ("avoid"),
    PERMIT("permit");

    public final String value;

    MESSAGE_DUPLICATION(String actualValue) {
        value = actualValue;
    }

}


