package cn.ricecandy.napcat.dto.api.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupApiReq {
    private String group_id;
    private Integer add_type; // 1：允许任何人加群，2：需要发送验证消息，3：不允许任何人加群，4：正确回答问题， 5：回答问题并要管理员审核
    private String group_question;
    private String group_answer;
    private Object user_id; // List or Long
    private Boolean reject_add_request; // 是否群拉黑
    private String remark; // 群备注
    private Integer count;
    private Integer duration; // 禁言时间(秒)
    private Boolean enable;
    private String file;
    private String card; // 群名片
    private String group_name; // 群名
    private String content;
    private String image;
    private Integer pinned; // 是否置顶（1,0)
    private Integer confirm_required; // 公告是否需要成员确认（1,0）
    private Integer is_show_edit_card; // 公告是否引导群员修改群名片
    private Integer tip_window_type; // 公告提示窗口的样式类型
    private String special_title; // 头衔
    private String flag; // 加群请求id
    private Boolean approve; // 加群是否同意
    private String reason; // 加群拒绝理由
    private Boolean no_cache;
    private String notice_id; // 群公告Id
    private String type; // 群荣誉类型

}
