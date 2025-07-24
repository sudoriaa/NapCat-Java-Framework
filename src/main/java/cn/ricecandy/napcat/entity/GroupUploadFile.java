package cn.ricecandy.napcat.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode
public class GroupUploadFile {
    private String id;
    private String name;
    private Long size;
    private Long busid;
}