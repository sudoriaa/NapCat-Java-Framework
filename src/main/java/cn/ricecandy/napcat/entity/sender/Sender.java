package cn.ricecandy.napcat.entity.sender;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public abstract class Sender {
    private String userId;
    private String nickname;
    private String sex; // male,female,unknown
}
