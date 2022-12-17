package kr.co.abc.kthuluapi.token.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.abc.kthuluapi.token.entity.QToken;
import kr.co.abc.kthuluapi.token.entity.Token;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final JPAQueryFactory queryFactory;

    public List<Token> findToken(String token_type, String token_name) {
        // Q클래스를 이용한다.
        QToken token = QToken.token;
        return queryFactory.selectFrom(token)
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

    public List<Token> findTokenContract(String token_type, String token_name) {
        // Q클래스를 이용한다.
        QToken token = QToken.token;
        return queryFactory.selectFrom(token)
                .where(
                    token.token_type.eq(token_type)
                    .and(token.token_symbol.eq(token_name))
                )
                .fetch();
    }

}