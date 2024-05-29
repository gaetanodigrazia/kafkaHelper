package com.digrazia.KafkaHelper.enumeration;

public enum LOSS_TOLERANCE {

    HIGH ("high"),
    MEDIUM("none"),
    LOW("low"),
    NONE("none");

    public final String value;

    LOSS_TOLERANCE(String actualValue) {
        value = actualValue;
    }

}


