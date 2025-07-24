package cn.ricecandy.napcat.dto.api.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FetchEmojiLikeApiResp {
    private Long result;
    private String err_msg;
    private List<Long> emoji_like_list;
    private String cookie;
    private Boolean is_last_page;
    private Boolean is_first_page;
}
