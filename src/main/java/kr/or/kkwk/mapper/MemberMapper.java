package kr.or.kkwk.mapper;

import kr.or.kkwk.model.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface MemberMapper {


    List<MemberVo> getMemberList();



}
