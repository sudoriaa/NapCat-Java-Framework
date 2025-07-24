package cn.ricecandy.napcat.entity.sender;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupSender extends Sender{
    private String card; // 群名片/备注
    private String role; // 'owner'/'admin'/'member'
}
