package cn.ricecandy.napcat.enums;

public enum ContactType {
    QQ("qq"),
    GROUP("GROUP");

    private final String value;

    ContactType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
