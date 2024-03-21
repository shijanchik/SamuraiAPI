package api.jsonresponses.profile;

import api.jsonresponses.users.Photos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class Profile {
    @JsonProperty("aboutMe")
    private String aboutMe;
    @JsonProperty("contacts")
    private Contacts contacts;
    @JsonProperty("lookingForAJob")
    private Boolean lookingForAJob;
    @JsonProperty("lookingForAJobDescription")
    private Boolean lookingForAJobDescription;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("photos")
    private Photos photos;
}
