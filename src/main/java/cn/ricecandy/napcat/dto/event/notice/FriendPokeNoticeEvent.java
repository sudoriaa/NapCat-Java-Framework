package cn.ricecandy.napcat.dto.event.notice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FriendPokeNoticeEvent extends PokeNoticeEvent {
    private String raw_info;
    private String sender_id;
}
