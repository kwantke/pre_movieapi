package kr.or.zeropay2.model.vo;

import kr.or.zeropay2.model.entity.MemberEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class MemberVo {

  String id;
  @NotNull
  String name;
  String password;
  String email;


  public MemberVo (String id, String name, String password, String email){
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
  }


  public MemberEntity saveMember(){
    return MemberEntity.builder()
            .id(id)
            .name(name)
            .password(password)
            .email(email)
            .build();
  }

}
