package cn.ricecandy.napcat.dto.api.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseNapcatResp<T> {
    private String status;
    private Integer ret_code;
    private T data;
    private String message;
    private String wording;
    private String echo;
}
