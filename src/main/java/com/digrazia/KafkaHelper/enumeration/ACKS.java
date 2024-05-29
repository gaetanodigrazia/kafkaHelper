package com.digrazia.KafkaHelper.enumeration;

public enum ACKS {

    ALL ("all"),
    ONLY_LEADER("1"),
    NO_ACKS("0");

    public final String value;

    ACKS(String actualValue) {
        value = actualValue;
    }

}


