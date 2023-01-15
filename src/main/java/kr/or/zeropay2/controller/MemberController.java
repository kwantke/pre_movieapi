package kr.or.zeropay2.controller;



import kr.or.zeropay2.common.exceptio2.ApiException;
import kr.or.zeropay2.common.exceptio2.ExceptionEnum;
import kr.or.zeropay2.common.exption.NotFoundException;
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
     * @param
     * @return
     */
    @GetMapping("/getMember")
    public MemberVo getMember(){
        MemberVo memberVo = memberService.getMemberId("admin");
        return memberVo;

    }

    @RequestMapping("/getMemberPost")
    public MemberVo getMemberPost(MemberVo memberVo){
        //throw new NotFoundException("예외 처리");
        MemberVo memberVo1 = memberService.getMemberId(memberVo.getId());
        if(memberVo1 == null){
            throw new ApiException(ExceptionEnum.ZERO_01);
        }
        return memberVo1;
    }

    @RequestMapping("/save")
    public String saveMeber(@Valid MemberVo memberVo){
        memberService.save(memberVo);

        return "";
    }

}
