package kr.or.zeropay2.service.impl;

import kr.or.zeropay2.model.entity.MemberEntity;
import kr.or.zeropay2.model.vo.MemberVo;
import kr.or.zeropay2.repository.MemberRepository;
import kr.or.zeropay2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {


  MemberRepository memberRepository;

  @Autowired
  MemberServiceImpl(MemberRepository memberRepository){
    this.memberRepository = memberRepository;
  }

  @Override
  public MemberVo getMeberInfo(String id, String password) {
      Optional<MemberEntity> memberEntity = memberRepository.findById(id);
    return memberEntity.get().toDomain();
  }

  @Override
  @Transactional
  public void save(MemberVo memberVo) {
    //MemberVo memberVo = new MemberVo();
    //memberVo.setId("");
    memberVo.setPassword("member3");
    memberVo.setName("최홍익3");
    memberVo.setEmail("chl3@gmail.com");

    memberRepository.save(new MemberEntity(memberVo));
  }
}
