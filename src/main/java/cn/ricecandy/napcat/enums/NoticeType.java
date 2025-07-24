package cn.ricecandy.napcat.enums;

public enum NoticeType {
    GROUP_UPLOAD("group_upload"),          // 群文件上传
    GROUP_ADMIN("group_admin"),            // 群管理员变动
    GROUP_DECREASE("group_decrease"),      // 群成员减少
    GROUP_INCREASE("group_increase"),      // 群成员增加
    GROUP_BAN("group_ban"),                // 群禁言
    FRIEND_ADD("friend_add"),              // 好友添加
    GROUP_RECALL("group_recall"),          // 群消息撤回
    FRIEND_RECALL("friend_recall"),        // 好友消息撤回
    GROUP_CARD("group_card"),              // 群名片变更
    OFFLINE_FILE("offline_file"),          // 离线文件上传
    CLIENT_STATUS("client_status"),        // 客户端状态变更
    ESSENCE("essence"),                    // 精华消息
    NOTIFY("notify");                      // 系统通知

    private final String value;

    NoticeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}