package kr.or.zeropay2.controller;



import kr.or.zeropay2.model.vo.MemberVo;
import kr.or.zeropay2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MemberController {


    MemberService memberService;

    /**
     * 데이터베이스 연결
     * <pre>
     * NOTE: 데이터베이스 설정 정보는 application.yml에 설정된
     *       dataSource 설정 정보이다.
     *       여기 정보를 가져오는 부분이 @ConfigurationProperties
     *       이다.
     * </pre>
     *
     * @return
     */
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @RequestMapping("/")
    public void goDomain(){
        System.out.println("");

    }

    /**
     * EntityManagerFactory 생성
     *
     * @param dataSource
     * @return
     */
    @GetMapping("/getMember")
    public MemberVo getMember(){
        MemberVo memberVo = memberService.getMemberId("admin");
        return memberVo;

    }

    @PostMapping("/getMemberPost")
    public MemberVo getMemberPost(@RequestBody MemberVo memberVo){

        return memberService.getMemberId(memberVo.getId());

    }


}
