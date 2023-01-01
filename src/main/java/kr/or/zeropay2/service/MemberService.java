package kr.or.zeropay2.service;

import kr.or.zeropay2.model.vo.MemberVo;

public interface MemberService {

  MemberVo getMeberInfo(String id, String password);

  void save(MemberVo memberVo);
}
