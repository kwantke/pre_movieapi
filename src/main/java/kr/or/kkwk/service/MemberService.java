package kr.or.kkwk.service;



import kr.or.kkwk.model.vo.MemberVo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MemberService {


  MemberVo getMemberInfo(String id, String password);




  MemberVo getMemberId(String id);

  boolean save(MemberVo memberVo);


  List<MemberVo> getMemberList();

  String memberLogin(MemberVo memberVo);
}
