package kr.co.abc.kthuluapi.token.controller;

import kr.co.abc.kthuluapi.token.dto.TokenDTO;
import kr.co.abc.kthuluapi.token.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
            , HttpSession session
            , TokenDTO tokenDTO) {
        ModelAndView mav = new ModelAndView("/index");
        List<TokenDTO> tokenList = tokenMapper.tokenList(tokenDTO);
        mav.addObject("tokenList",tokenList);
        return mav;
    }
}
