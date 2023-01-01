package kr.or.zeropay2;

import kr.or.zeropay2.model.entity.MemberEntity;
import kr.or.zeropay2.model.vo.MemberVo;
import kr.or.zeropay2.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class Zeropay2ApplicationTests {

	@Autowired
	MemberRepository memberRepository;

	@Test
	void save() {
		MemberVo memberVo = new MemberVo();
		memberVo.setId("nn");
		memberVo.setPassword("member3");
		memberVo.setName("최홍익3");
		memberVo.setEmail("chl3@gmail.com");

		if (memberRepository.findByIdAndPassword(memberVo.getId(), memberVo.getPassword()).isPresent()) {
			System.out.println("동일한 아이디가 있습니다.");
		} else {
			MemberEntity memberEntity = memberVo.saveMember();
			memberRepository.save(memberEntity);
		}
		// 업데이트인 경우 isEmpty() 사용
	}

	@Test
	void select(){
		MemberEntity memberEntity= memberRepository.findByIdAndPassword("admin","admin").get();
		System.out.println(memberEntity);
	}
}
