package kr.or.zeropay2;

import kr.or.zeropay.controller.MemberController;
import kr.or.zeropay.model.vo.MemberVo;
import kr.or.zeropay.service.MemberService;
import kr.or.zeropay.util.DocumentUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@AutoConfigureMockMvc
@AutoConfigureRestDocs
@WebMvcTest(MemberController.class)
public class MemberApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;
    @MockBean
    private MemberController memberController;

    private MemberVo member;

    @BeforeEach
    public void setUp(){
        member = new MemberVo("아이디","이름","비번","이메일");
    }

    @Test
    public void getMemberTest() throws Exception {
        this.mockMvc.perform(get("/getMemberId/{id}",5)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(document("get-member",   // get-member 라는 이름으로 asciidoc 문서가 만들어집니다.
                        DocumentUtils.getDocumentRequest(), // 문서를 이쁘게 출력합니다.
                        DocumentUtils.getDocumentResponse(),    // 문서를 이쁘게 출력합니다.
                        pathParameters( // id 가 url 뒤에 붙는 변수이기에 PathParameters 로 설정해줍니다.
                                parameterWithName("id").description("member id")
                        ),
                        responseFields( // responseField 를 써줍니다.
                                fieldWithPath("id").description("member id"),
                                fieldWithPath("name").description("member id"),
                                fieldWithPath("password").description("member id"),
                                fieldWithPath("email").description("member id")
                        )
                ))

        ;
    }

}

