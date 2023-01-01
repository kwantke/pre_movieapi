package kr.or.zeropay2.model.vo;

import kr.or.zeropay2.model.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVo {

  String id;
  String name;
  String password;
  String email;

  public MemberEntity saveMember(){
    return MemberEntity.builder()
            .id(id)
            .name(name)
            .password(password)
            .email(email)
            .build();
  }

}
