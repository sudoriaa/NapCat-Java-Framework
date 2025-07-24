package cn.ricecandy.napcat.dto.api.resp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetRecordApiResp {
    String file;
    String url;
    String file_size;
    String file_name;
    String base64;
}
