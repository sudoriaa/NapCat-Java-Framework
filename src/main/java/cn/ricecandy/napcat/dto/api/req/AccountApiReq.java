package cn.ricecandy.napcat.dto.api.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountApiReq {
    private String nickname;
    private String sex;
    private String personal_note;
    private Integer count;
    private String group_id;
    private String user_id;
    private String phone_number;
    private String flag;
    private Boolean approve;
    private Integer status;
    private Integer ext_status;
    private Integer battery_status;
    private String file;
    private Integer times;
    private String raw_data;
    private String brief;
    private String remark;
    private String long_nick;
    private Boolean no_cache;
    private Integer start;
    private Boolean temp_both_del;
    private Boolean temp_block;
    private Integer face_id;
    private Integer face_type;
    private String wording;
}
