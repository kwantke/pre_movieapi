package kr.or.zeropay2.controller;



import kr.or.zeropay2.model.vo.MemberVo;
import kr.or.zeropay2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MemberController {


    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @RequestMapping("/")
    public void goDomain(){

    }


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
