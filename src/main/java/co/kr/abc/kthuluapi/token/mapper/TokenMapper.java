package co.kr.abc.kthuluapi.token.mapper;

import co.kr.abc.kthuluapi.token.dto.TokenDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenMapper {
    /** articleList **/
    public List<TokenDTO> tokenList(TokenDTO tokenDTO);
}
