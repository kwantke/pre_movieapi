package kr.or.zeropay2.mapper;

import kr.or.zeropay2.model.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberVo> getMemberList();
}
