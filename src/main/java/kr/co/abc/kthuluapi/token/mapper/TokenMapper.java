package kr.co.abc.kthuluapi.token.mapper;

import kr.co.abc.kthuluapi.token.dto.TokenDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TokenMapper {
    /** articleList **/
    public List<TokenDTO> tokenList(TokenDTO tokenDTO);
}
