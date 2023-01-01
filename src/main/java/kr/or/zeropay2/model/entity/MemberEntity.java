package kr.or.zeropay2.model.entity;

import kr.or.zeropay2.model.vo.MemberVo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name="member")
public class MemberEntity {
// Entity는 jpa가 관리하는 객체
  @Id
  @Column(name="id", nullable=false)
  @NotBlank
  private String id;

  @Column(name="name")
  private String name;

  @Column(name="password")
  private String password;

  @Column(name="email")
  private String email;


  public MemberEntity(MemberVo memberVo){
    BeanUtils.copyProperties(memberVo, this);
  }



  public MemberVo toDomain(){
    MemberVo memberVo = new MemberVo();
    memberVo.setId(this.id);
    memberVo.setName(this.name);
    memberVo.setPassword(this.password);
    memberVo.setEmail(this.email);

    return memberVo;
  }

}
