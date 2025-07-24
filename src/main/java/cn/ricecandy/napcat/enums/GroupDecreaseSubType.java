package cn.ricecandy.napcat.enums;

public enum GroupDecreaseSubType {
    LEAVE("leave"),
    KICK("kick"),
    KICK_ME("kick_me"),
    DISBAND("disband");

    private final String value;

    GroupDecreaseSubType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}