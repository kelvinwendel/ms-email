package com.ms.email.enums;

public enum EmailStatus {
    SENT("Sent"),
    ERROR("Error");

    private String s;

    EmailStatus(String s) {
        this.s = s;
    }

    public String toString() {
        return this.s;
    }
}
