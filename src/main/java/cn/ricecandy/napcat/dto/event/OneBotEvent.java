package cn.ricecandy.napcat.dto.event;

import cn.ricecandy.napcat.enums.PostType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OneBotEvent {
    private Long time;
    private PostType post_type;
    private String self_id;
}