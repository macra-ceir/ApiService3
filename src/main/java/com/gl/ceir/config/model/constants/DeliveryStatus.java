package com.gl.ceir.config.model.constants;

public enum DeliveryStatus {
    SUCCESS(1, "delivery success"),
    FAILURE(2, "delivery failure"),
    BUFFERED(4, "message buffered"),
    SMSC_SUBMIT(8, "smsc submit"),
    SMSC_REJECT(16, "smsc reject");

    private final int value;
    private final String status;

    private DeliveryStatus(int value, String status) {
        this.value = value;
        this.status = status;
    }

    public int getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }

    public static String fromValue(int value) {
        for (DeliveryStatus status : values()) {
            if (status.getValue() == value) {
                return status.getStatus();
            }
        }
        throw new IllegalArgumentException("Invalid DeliveryStatus value: " + value);
    }
}


