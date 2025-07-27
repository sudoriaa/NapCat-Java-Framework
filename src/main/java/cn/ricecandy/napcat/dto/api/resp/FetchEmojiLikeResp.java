package cn.ricecandy.napcat.dto.api.resp;

import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FetchEmojiLikeResp {
    private Long result;
    private String err_msg;
    private List<Long> emoji_like_list;
    private String cookie;
    private Boolean is_last_page;
    private Boolean is_first_page;
}
