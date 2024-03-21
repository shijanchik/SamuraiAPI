package api.jsonresponses.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class DataUserResponse extends BaseResponse {
    @JsonProperty("data")
    private DataUser data;
}
