package kr.or.zeropay2.service;



import kr.or.zeropay2.model.vo.MemberVo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MemberService {


  MemberVo getMemberInfo(String id, String password);




  MemberVo getMemberId(String id);

  void save(MemberVo memberVo);


  List<MemberVo> getMemberList();
}
