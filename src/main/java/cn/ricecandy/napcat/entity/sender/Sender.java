package cn.ricecandy.napcat.entity.sender;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class Sender {
    private String userId;
    private String nickname;
    private String sex; // male,female,unknown
    private String card; // 群名片/备注
    private String role; // 'owner'/'admin'/'member'
    private String groupId; // 临时会话群号（可选）

}
