package cn.ricecandy.napcat.dto.event.notice;
// 群管理员变动

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupAdminNoticeEvent extends GroupNoticeEvent{
    private String sub_type; // "set" or "unset"
}
