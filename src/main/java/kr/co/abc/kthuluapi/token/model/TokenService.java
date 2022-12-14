package kr.co.abc.kthuluapi.token.model;

import java.util.List;
import java.util.stream.Collectors;

import kr.co.abc.kthuluapi.token.dto.TokenResponseDto;
import kr.co.abc.kthuluapi.token.entity.Token;
import kr.co.abc.kthuluapi.token.entity.TokenRepository;
import kr.co.abc.kthuluapi.token.entity.TokenSpecification;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.QueryHint;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    /**
     * 토큰 리스트 조회
     */
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    @Transactional(readOnly = true)
    @BatchSize(size = 10)
    public List<TokenResponseDto> findAll(String token_type, String token_name) {
        Specification<Token> spec = (root, query, criteriaBuilder) -> null;
        if (token_type != null) {
            spec = spec.and(TokenSpecification.equalTokenType(token_type));
        }

        if (token_name != null) {
            spec = spec.and(TokenSpecification.likeTokenName(token_name));
        }
        List<Token> list = tokenRepository.findAll(spec);
        return list.stream().map(TokenResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 토큰 리스트 조회
     */
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    @Transactional(readOnly = true)
    @BatchSize(size = 10)
    public List<TokenResponseDto> findAllContract(String token_type, String token_name) {
        Specification<Token> spec = (root, query, criteriaBuilder) -> null;
        if (token_type != null) {
            spec = spec.and(TokenSpecification.equalTokenType(token_type));
        }

        if (token_name != null) {
            spec = spec.and(TokenSpecification.equalTokenSymbol(token_name));
        }

        List<Token> list = tokenRepository.findAll(spec);
        return list.stream().map(TokenResponseDto::new).collect(Collectors.toList());

    }


}