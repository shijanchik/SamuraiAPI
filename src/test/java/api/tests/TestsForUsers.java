package api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.constants.ConstantApi.FULL_NAME;


public class TestsForUsers {
    Steps steps = new Steps();

    @Test
    @DisplayName("Checking that the page only shows 10 users")
    public void checkingThatThePageOnlyShowsTenUsers() {
        steps.defaultNumberOfUsersOnThePage();
    }

    @Test
    @DisplayName("Verifying that a page displays a certain number of users")
    public void numberOfUsersOnThePage() {
        steps.numberOfUsersOnThePage(5);
    }

    @Test
    @DisplayName("Checking user search")
    public void checkingUserSearch() {
        steps.checkingUserSearchFunctionality(FULL_NAME);
    }



}
