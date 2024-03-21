package api.jsonresponses.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class LoginUserResponse extends BaseResponse {
    @JsonProperty("data")
    private LoginUser data;
}
