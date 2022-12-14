package kr.co.abc.kthuluapi.token.dto;

import kr.co.abc.kthuluapi.token.entity.Token;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenRequestDto {
    private  String token_type; // 토큰 타입
    private  String token_contract; // 토큰 컨트렉트 주소
    private  String token_name; // 토큰 이름
    private  String token_img; // 토큰 이미지
    private  String token_symbol; // 토큰 심볼
    private  int token_decimals; // 토큰 데시말

    public Token toEntity() {
        return Token.builder()
                .token_type(token_type)
                .token_contract(token_contract)
                .token_name(token_name)
                .token_img(token_img)
                .token_symbol(token_symbol)
                .token_decimals(token_decimals)
                .build();
    }
}
