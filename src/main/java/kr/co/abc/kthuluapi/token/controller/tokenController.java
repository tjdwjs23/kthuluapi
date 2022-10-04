package kr.co.abc.kthuluapi.token.controller;

import com.google.gson.Gson;
import kr.co.abc.kthuluapi.token.dto.TokenDTO;
import kr.co.abc.kthuluapi.token.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@RestController
public class tokenController {

    @Autowired
    TokenMapper tokenMapper;

    @GetMapping("/")
    public ModelAndView index(
            Locale locale
            , HttpSession session) {
        ModelAndView mav = new ModelAndView("/index");
        return mav;
    }

    /**
     * token
     */
    @PostMapping("/token/{type}")
    public String token(
            Locale locale
            , HttpSession session
            , TokenDTO tokenDTO
            , @PathVariable(name="type") String type
            , @RequestParam(value="token_name", required=true) String token_name) {

        String strResult = "{ \"result\":\"FAIL\", \"value\":\"[]\" }";

        tokenDTO.setToken_type(type);
        tokenDTO.setToken_name(token_name);
        List<TokenDTO> tokenList = tokenMapper.tokenList(tokenDTO);

        // List to JSONArray
        Gson gson = new Gson();
        strResult = "{ \"result\":\"OK\", \"value\":"+gson.toJsonTree(tokenList).toString()+" }";

        return strResult;
    }
}
