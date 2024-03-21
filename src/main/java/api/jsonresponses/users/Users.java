package api.jsonresponses.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class Users {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("uniqueUrlName")
    private Object uniqueUrlName;
    @JsonProperty("photos")
    private Photos photos;
    @JsonProperty("status")
    private String status;
    @JsonProperty("followed")
    private Boolean followed;
}
