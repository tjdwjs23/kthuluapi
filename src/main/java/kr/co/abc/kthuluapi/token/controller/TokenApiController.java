package kr.co.abc.kthuluapi.token.controller;

import kr.co.abc.kthuluapi.token.dto.TokenResponseDto;
import kr.co.abc.kthuluapi.token.model.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TokenApiController {

    private final TokenService tokenService;

    /**
     * 토큰 리스트 조회
     */
    @GetMapping("/token")
    public List<TokenResponseDto> findAll(String token_type, String token_name) {
        return tokenService.findAll(token_type, token_name);
    }

    /**
     * 컨트렉트 리스트 조회
     */
    @GetMapping("/tokenAdd")
    public List<TokenResponseDto> findAllContract(String token_type, String token_name) {
        return tokenService.findAllContract(token_type, token_name);
    }
}
