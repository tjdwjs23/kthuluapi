package co.kr.abc.kthuluapi.token.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Alias("token")
@Getter
@Setter
@ToString
public class TokenDTO {
	int id;
	String name;
	String gender;
	String city;
	int token_idx;
	String token_type;
	String token_contract;
	String token_name;
	String token_img;
	String token_symbol;
	int token_decimals;
	Date token_udate;
	Date token_rdate;

	public TokenDTO() {}

	public TokenDTO(int id, String name, String gender, String city, int token_idx, String token_type, String token_contract, String token_name, String token_img, String token_symbol, int token_decimals, Date token_udate, Date token_rdate) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.token_idx = token_idx;
		this.token_type = token_type;
		this.token_contract = token_contract;
		this.token_name = token_name;
		this.token_img = token_img;
		this.token_symbol = token_symbol;
		this.token_decimals = token_decimals;
		this.token_udate = token_udate;
		this.token_rdate = token_rdate;
	}

}
