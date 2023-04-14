package kr.co.abc.kthuluapi.token.controller;

import kr.co.abc.kthuluapi.token.model.TokenService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class TokenApiController {

    private final TokenService tokenService;

    /**
     * index()
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Token list search
     */
    @GetMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String token(String token_type, String token_name) {
        JSONArray jsonArray = new JSONArray(tokenService.findToken(token_type, token_name));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "OK");
        jsonObject.put("value", jsonArray);
        return jsonObject.toString();
    }

    /**
     * Token contract inquiry
     */
    @GetMapping(value = "/tokenAdd", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String tokenAdd(String token_type, String token_name) {
        JSONArray jsonArray = new JSONArray(tokenService.findTokenContract(token_type, token_name));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "OK");
        jsonObject.put("value", jsonArray);
        return jsonObject.toString();
    }
}
