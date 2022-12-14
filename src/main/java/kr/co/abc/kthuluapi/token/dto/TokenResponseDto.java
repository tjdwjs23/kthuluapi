package kr.co.abc.kthuluapi.token.dto;

import kr.co.abc.kthuluapi.token.entity.Token;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
public class TokenResponseDto {

    @Column(name = "token_idx")
    private Long id; // PK
    private  String token_type; // 토큰 타입
    private  String token_contract; // 토큰 컨트렉트 주소
    private  String token_name; // 토큰 이름
    private  String token_img; // 토큰 이미지
    private  String token_symbol; // 토큰 심볼
    private  int token_decimals; // 토큰 데시말

    public TokenResponseDto(Token entity) {
        this.id = entity.getId();
        this.token_type = entity.getToken_type();
        this.token_contract = entity.getToken_contract();
        this.token_name = entity.getToken_name();
        this.token_img = entity.getToken_img();
        this.token_symbol = entity.getToken_symbol();
        this.token_decimals = entity.getToken_decimals();
    }
}
