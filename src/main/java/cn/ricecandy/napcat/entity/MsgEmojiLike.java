package cn.ricecandy.napcat.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode
public class MsgEmojiLike {
    private String emojiId;
    private int count;
}
