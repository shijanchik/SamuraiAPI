package api.jsonresponses.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class TotalCountOfUsers {
    @JsonProperty("items")
    private List<Users> items;
    @JsonProperty("totalCount")
    private int totalCount;
    @JsonProperty("error")
    private Object error;

}
