package cn.ricecandy.napcat.dto.api.resp;


import lombok.*;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetRecordResp {
    String file;
    String url;
    String file_size;
    String file_name;
    String base64;
}
