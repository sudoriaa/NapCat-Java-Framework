package cn.ricecandy.napcat.entity;


import com.alibaba.fastjson.JSONObject;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class ForwardMessageNode {
    private String nickname;
    private String user_id;
    private String content;
}
