package cn.ricecandy.napcat.dto.api.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileApiReq {
    private String group_id;
    private String file_id;
    private String current_parent_directory; // 当前根目录
    private String target_parent_directory; // 目标父目录
    private String new_name;
    private String name;
    private String file;
    private String folder;
    private String folder_id;
    private String folder_name;
    private String url;
    private String base64;
    private String headers;
    private Integer file_count;

}
