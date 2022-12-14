package kr.co.abc.kthuluapi.token.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "token")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "token_idx")
	private Long id; // PK
	private  String token_type; // 토큰 타입
	private  String token_contract; // 토큰 컨트렉트 주소
	private  String token_name; // 토큰 이름
	private  String token_img; // 토큰 이미지
	private  String token_symbol; // 토큰 심볼
	private  int token_decimals; // 토큰 데시말

	@Builder
	public Token(String token_type, String token_contract, String token_name, String token_img, String token_symbol, int token_decimals) {
		this.token_type = token_type;
		this.token_contract = token_contract;
		this.token_name = token_name;
		this.token_img = token_img;
		this.token_symbol = token_symbol;
		this.token_decimals = token_decimals;
	}

}
