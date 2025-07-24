package cn.ricecandy.napcat.enums;

public enum MessageType {
    GROUP("group"),

    PRIVATE("private");

    private final String type;

    MessageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
