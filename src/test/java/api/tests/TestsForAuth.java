package api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.constants.ConstantApi.*;

public class TestsForAuth {
    Steps steps = new Steps();

    @Test
    @DisplayName("Verified that the current user is not authorized")
    public void verifiedCurrentUserNotAuthorized() {
        steps.isCurrentUserAuthorized(1);
    }

    @Test
    @DisplayName("Verified that the user can log in")
    public void verifiedUserCanLogIn() {
        steps.userAuthorization(EMAIL, PASSWORD);
        steps.isCurrentUserAuthorized(0);
    }

    @Test
    @DisplayName("Verified that the user can log out")
    public void verifiedUserCanLogOut() {
        steps.userAuthorization(EMAIL, PASSWORD);
        steps.userLogOut();
    }

}
