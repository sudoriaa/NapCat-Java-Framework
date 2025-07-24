package cn.ricecandy.napcat.enums;

public enum PostType {
    META_EVENT("meta_event"),
    REQUEST("request"),
    NOTICE("notice"),
    MESSAGE("message"),
    MESSAGE_SENT("message_sent");

    private final String value;

    PostType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}