package kr.co.abc.kthuluapi.token;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.abc.kthuluapi.token.entity.QToken;
import kr.co.abc.kthuluapi.token.entity.Token;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
public class TokenTests {

    @Autowired
    private JPAQueryFactory queryFactory;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        // when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("Here is Token Api!");
    }

    @Test
    @DisplayName("token name 기준으로 equal/contains 조회")
    void findToken() {
        final String token_type = "ethreum";
        final String token_name = "e";

        // Q클래스를 이용한다.
        QToken token = QToken.token;
        List<Token> findToken = queryFactory
                .selectFrom(token)
                .where(
                        token.token_type.eq(token_type)
                                .andAnyOf(
                                        token.token_name.contains(token_name)
                                                .or(token.token_symbol.contains(token_name))
                                                .or(token.token_contract.contains(token_name))
                                )
                )
                .limit(150)
                .fetch();

    }

    @Test
    @DisplayName("token name 기준으로 equal 조회")
    void findTokenContract() {
        final String token_type = "ethreum";
        final String token_name = "USDT";

        // Q클래스를 이용한다.
        QToken token = QToken.token;
        List<Token> findTokenContract = queryFactory
                .selectFrom(token)
                .where(
                        token.token_type.eq(token_type)
                                .and(token.token_symbol.eq(token_name))
                )
                .fetch();
    }

}