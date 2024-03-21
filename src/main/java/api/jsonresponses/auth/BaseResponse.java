package api.jsonresponses.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class BaseResponse {
    @JsonProperty("messages")
    protected List<String> messages;
    @JsonProperty("fieldsErrors")
    protected List<Object> fieldsErrors;
    @JsonProperty("resultCode")
    protected Integer resultCode;
}
