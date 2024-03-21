package api.jsonresponses.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class Contacts {
    @JsonProperty("facebook")
    private String facebook;
    @JsonProperty("website")
    private String website;
    @JsonProperty("vk")
    private String vk;
    @JsonProperty("twitter")
    private String twitter;
    @JsonProperty("instagram")
    private String instagram;
    @JsonProperty("youtube")
    private String youtube;
    @JsonProperty("github")
    private String github;
    @JsonProperty("mainLink")
    private String mainLink;
}
