package api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.constants.ConstantApi.*;
import static api.constants.ConstantApi.PASSWORD;

public class TestForProfile {
    Steps steps = new Steps();

    @Test
    @DisplayName("Verified that the user can change and check the status")
    public void verifiedUserCanChangeAndCheckStatus() {
        steps.userAuthorization(EMAIL, PASSWORD);
        steps.changingStatus(CURRENT_STATUS);
        steps.checkingStatus(CURRENT_STATUS);
    }

    @Test
    @DisplayName("Verified that the user can change profile")
    public void verifiedUserCanChangeProfile() {
        steps.userAuthorization(EMAIL, PASSWORD);
        steps.changingProfile();
        steps.checkingProfile();
    }
}
