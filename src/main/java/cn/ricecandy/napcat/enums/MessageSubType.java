package cn.ricecandy.napcat.enums;

/**
 * Napcat支持的消息类型枚举
 * 参考：https://www.napcat.wiki/develop/msg
 */
public enum MessageSubType {
    /**
     * 纯文本消息
     */
    TEXT("text"),
    /**
     * QQ表情
     */
    FACE("face"),
    /**
     * 图片
     */
    IMAGE("image"),
    /**
     * 语音
     */
    RECORD("record"),
    /**
     * 视频
     */
    VIDEO("video"),
    /**
     * @某人
     */
    AT("at"),
    /**
     * 猜拳魔法表情
     */
    RPS("rps"),
    /**
     * 骰子魔法表情
     */
    DICE("dice"),
    /**
     * 私聊窗口抖动
     */
    SHAKE("shake"),
    /**
     * 群聊戳一戳
     */
    POKE("poke"),
    /**
     * 链接分享
     */
    SHARE("share"),
    /**
     * 推荐好友/群
     */
    CONTACT("contact"),
    /**
     * 位置
     */
    LOCATION("location"),
    /**
     * 音乐分享
     */
    MUSIC("music"),
    /**
     * 回复消息
     */
    REPLY("reply"),
    /**
     * 合并转发消息
     */
    FORWARD("forward"),
    /**
     * 转发消息节点
     */
    NODE("node"),
    /**
     * JSON消息
     */
    JSON("json"),
    /**
     * QQ表情包（mface）
     */
    MFACE("mface"),
    /**
     * 文件
     */
    FILE("file"),
    /**
     * markdown消息（仅合并转发内）
     */
    MARKDOWN("markdown"),
    /**
     * 小程序卡片
     */
    LIGHTAPP("lightapp");

    private final String type;

    MessageSubType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}