package cn.ricecandy.napcat.dto.api.req;

import cn.ricecandy.napcat.entity.ForwardMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageApiReq {
    private String group_id;
    private String message;
    private List<ForwardMessage> messages;
    private String message_id;
    private String user_id;
    private String target_id;
    private Integer count;
    private Boolean reverse_order;
    private Integer emoji_id;
    private Boolean set;
    private String message_seq;
    private String file;
    private String file_id;
    private String out_format;
    private String character;
    private String text;
}
