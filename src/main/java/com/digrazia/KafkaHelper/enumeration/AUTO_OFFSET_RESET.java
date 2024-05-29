package com.digrazia.KafkaHelper.enumeration;

public enum AUTO_OFFSET_RESET {
    EARLIEST("earliest"),
    LATEST ("latest"),
    NONE("none");

    public final String value;

    AUTO_OFFSET_RESET(String actualValue) {
        value = actualValue;
    }

}


