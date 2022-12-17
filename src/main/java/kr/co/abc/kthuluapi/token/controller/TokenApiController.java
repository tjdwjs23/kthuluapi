package kr.co.abc.kthuluapi.token.controller;

import com.google.gson.Gson;
import kr.co.abc.kthuluapi.token.entity.TokenRepository;
import kr.co.abc.kthuluapi.token.model.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class TokenApiController {

    private final TokenService tokenService;
    private final TokenRepository tokenRepository;

    /**
     * index
     * @param locale
     * @param session
     * @return
     */
    @GetMapping("/")
    public ModelAndView index(
            Locale locale
            , HttpSession session) {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }


    /**
     * 토큰 리스트 조회
     */
    @GetMapping("/token")
    public String token(String token_type, String token_name) {
        String strResult = "{ \"result\":\"FAIL\", \"value\":\"[]\" }";
        Gson gson = new Gson();
        strResult = "{ \"result\":\"OK\", \"value\":"+gson.toJsonTree(tokenService.findToken(token_type, token_name)).toString()+" }";
        return strResult;

    }

    /**
     * 토큰 리스트 조회
     */
    @GetMapping("/tokenAdd")
    public String tokenAdd(String token_type, String token_name) {
        String strResult = "{ \"result\":\"FAIL\", \"value\":\"[]\" }";
        Gson gson = new Gson();
        strResult = "{ \"result\":\"OK\", \"value\":"+gson.toJsonTree(tokenService.findTokenContract(token_type, token_name)).toString()+" }";
        return strResult;
    }


}