package kr.co.abc.kthuluapi.token;

import java.util.List;

import kr.co.abc.kthuluapi.token.entity.Token;
import kr.co.abc.kthuluapi.token.entity.TokenRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TokenTests {

    @Autowired
    TokenRepository tokenRepository;

    @Test
    void findAll() {

        // 1. 전체 게시글 수 조회
        long tokensCount = tokenRepository.count();

        // 2. 전체 게시글 리스트 조회
        List<Token> tokens = tokenRepository.findAll();
    }

}