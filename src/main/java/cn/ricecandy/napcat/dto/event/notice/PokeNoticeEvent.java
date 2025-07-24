package cn.ricecandy.napcat.dto.event.notice;
// 戳一戳

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PokeNoticeEvent extends NoticeEvent{
    private String target_id;
    private String user_id;
}
