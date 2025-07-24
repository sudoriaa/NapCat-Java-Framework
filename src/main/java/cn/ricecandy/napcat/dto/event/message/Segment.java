package cn.ricecandy.napcat.dto.event.message;


import cn.ricecandy.napcat.enums.MessageSubType;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Segment {
    MessageSubType type; // text,at,reply,file,face
    JSONObject data;
}
