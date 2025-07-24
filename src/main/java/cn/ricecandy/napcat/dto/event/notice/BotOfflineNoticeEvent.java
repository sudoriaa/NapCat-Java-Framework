package cn.ricecandy.napcat.dto.event.notice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BotOfflineNoticeEvent extends NoticeEvent {
    private String user_id;
    private String tag;
    private String message;
}
