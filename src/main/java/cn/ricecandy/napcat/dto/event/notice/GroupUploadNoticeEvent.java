package cn.ricecandy.napcat.dto.event.notice;
// 群文件上传

import cn.ricecandy.napcat.entity.GroupUploadFile;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupUploadNoticeEvent extends GroupNoticeEvent{
    private GroupUploadFile file;
}
