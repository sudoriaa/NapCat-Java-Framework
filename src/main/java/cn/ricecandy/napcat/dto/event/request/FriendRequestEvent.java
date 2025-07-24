package cn.ricecandy.napcat.dto.event.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FriendRequestEvent extends RequestEvent {
    private String user_id;
    private String comment;
    private String flag;
}