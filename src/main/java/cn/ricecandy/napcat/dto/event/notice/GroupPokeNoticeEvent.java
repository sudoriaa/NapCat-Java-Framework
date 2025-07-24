package cn.ricecandy.napcat.dto.event.notice;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupPokeNoticeEvent extends PokeNoticeEvent {
    private String group_id;
    private String raw_info;
}
