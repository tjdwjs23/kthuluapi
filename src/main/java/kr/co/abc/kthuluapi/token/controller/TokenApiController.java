package kr.co.abc.kthuluapi.token.controller;

import com.google.gson.Gson;
import kr.co.abc.kthuluapi.token.model.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class TokenApiController {

    private final TokenService tokenService;

    /**
     * index()
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }


    /**
     * 토큰 리스트 조회
     */
    @GetMapping("/token")
    @ResponseBody
    public String token(String token_type, String token_name) {
        String strResult = "{ \"result\":\"FAIL\", \"value\":\"[]\" }";
        Gson gson = new Gson();
        strResult = "{ \"result\":\"OK\", \"value\":" + gson.toJsonTree(tokenService.findToken(token_type, token_name)).toString() + " }";
        return strResult;

    }

    /**
     * 토큰 컨트렉트 조회
     */
    @GetMapping("/tokenAdd")
    @ResponseBody
    public String tokenAdd(String token_type, String token_name) {
        String strResult = "{ \"result\":\"FAIL\", \"value\":\"[]\" }";
        Gson gson = new Gson();
        strResult = "{ \"result\":\"OK\", \"value\":" + gson.toJsonTree(tokenService.findTokenContract(token_type, token_name)).toString() + " }";
        return strResult;
    }


}