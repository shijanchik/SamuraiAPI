package api.jsonresponses.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class Photos {
    @JsonProperty("small")
    private String small;
    @JsonProperty("large")
    private String large;
}
