package kr.or.zeropay2.service.impl;


import kr.or.zeropay2.common.exceptio2.ApiException;
import kr.or.zeropay2.common.exceptio2.ExceptionEnum;
import kr.or.zeropay2.mapper.MemberMapper;
import kr.or.zeropay2.model.entity.MemberEntity;
import kr.or.zeropay2.model.vo.MemberVo;
import kr.or.zeropay2.repository.MemberRepository;
import kr.or.zeropay2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {


  MemberRepository memberRepository;

  MemberMapper memberMapper;
  @Autowired
  MemberServiceImpl(MemberRepository memberRepository, MemberMapper memberMapper){
    this.memberRepository = memberRepository;
    this.memberMapper = memberMapper;
  }

  @Override
  public MemberVo getMemberInfo(String id, String password) {
      Optional<MemberEntity> memberEntity = Optional.ofNullable(memberRepository.findById(id)
              .orElseThrow(() -> new ApiException(ExceptionEnum.ZERO_01)));
    return memberEntity.get().toDomain();
  }

  @Override
  public MemberVo getMemberId(String id) {
    Optional<MemberEntity> memberEntity = Optional.ofNullable(memberRepository.findById(id)
            .orElseThrow(() -> new ApiException(ExceptionEnum.ZERO_01)));
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



    MemberEntity m = memberVo.saveMember();
    memberRepository.save(new MemberEntity(memberVo));
  }

  @Override
  public List<MemberVo> getMemberList() {
    return memberMapper.getMemberList();
  }


}
