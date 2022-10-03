package co.kr.abc.kthuluapi.token.controller;

import co.kr.abc.kthuluapi.token.dto.TokenDTO;
import co.kr.abc.kthuluapi.token.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class tokenController {

    @Autowired
    TokenMapper tokenMapper;

    @GetMapping("/")
    public ModelAndView index(TokenDTO tokenDTO) {
        ModelAndView mav = new ModelAndView("index");
        List<TokenDTO> tokenList = tokenMapper.tokenList(tokenDTO);
        mav.addObject("tokenList",tokenList);
        return mav;
    }
}
