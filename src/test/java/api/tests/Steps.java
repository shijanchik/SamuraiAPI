package api.tests;

import api.jsonresponses.auth.LoginUserResponse;
import api.jsonresponses.users.Users;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static api.constants.ConstantApi.*;

public class Steps {
    Requests requests = new Requests();

    @Step("Checking user search functionality")
    public void checkingUserSearchFunctionality(String userName) {
        List<Users> listUsers = requests.getUserNameStringForSearching(userName);
        String name = listUsers.get(0).getName();
        int numberOfUsers = listUsers.size();
        int id = listUsers.get(0).getId();
        Assertions.assertTrue(name.equals(userName), INCORRECT_USERNAME);
        Assertions.assertEquals(1, numberOfUsers, INCORRECT_NUMBER_OF_USERS);
        Assertions.assertEquals(30483, id, INCORRECT_USER_ID);
    }

    @Step("Default number of users on the page")
    public void defaultNumberOfUsersOnThePage() {
        int numberOfUsers = requests.getAllUsers().size();
        Assertions.assertEquals(10, numberOfUsers, INCORRECT_NUMBER_OF_USERS);
    }

    @Step("Number of users on the page")
    public void numberOfUsersOnThePage(int quantity) {
        int numberOfUsers = requests.getCertainNumberOfUsersOnPage(quantity).size();
        Assertions.assertEquals(quantity, numberOfUsers, INCORRECT_NUMBER_OF_USERS);
    }

    @Step("Is current user authorized")
    public void isCurrentUserAuthorized(int expectedCode) {
        int actualCode = requests.getAuthUser().getResultCode();
        List<String> actualMessage = requests.getAuthUser().getMessages();

        if (expectedCode == 0) {
            Assertions.assertEquals(expectedCode, actualCode, USER_IS_NOT_AUTHORIZED);
            Assertions.assertEquals(0, actualMessage.size(), USER_IS_ALREADY_AUTHORIZED);
        } else {
            Assertions.assertEquals(expectedCode, actualCode, USER_IS_ALREADY_AUTHORIZED);
            Assertions.assertTrue(actualMessage.get(0).equals(ERROR_MESSAGE));
        }
    }

    @Step("User authorization")
    public void userAuthorization(String email, String password) {
        LoginUserResponse loginUserResponse = requests.postAuthUser(email, password);
        int id = loginUserResponse.getData().getUserId();
        int actualCode = loginUserResponse.getResultCode();
        Assertions.assertEquals(30483, id, INCORRECT_USER_ID);
        Assertions.assertEquals(0, actualCode, USER_IS_ALREADY_AUTHORIZED);
    }

    @Step("User log out")
    public void userLogOut() {
        LoginUserResponse loginUserResponse = requests.LogOutUser();
        int messages = loginUserResponse.getMessages().size();
        int actualCode = loginUserResponse.getResultCode();
        Assertions.assertEquals(0, messages, USER_HAS_NOT_YET_LOGGED_OUT);
        Assertions.assertEquals(0, actualCode, USER_HAS_NOT_YET_LOGGED_OUT);
    }

    @Step("Changing status")
    public void changingStatus(String status) {
        LoginUserResponse loginUserResponse = requests.putStatus(status);
        int messages = loginUserResponse.getMessages().size();
        int actualCode = loginUserResponse.getResultCode();
        Assertions.assertEquals(0, messages, USER_HAS_NOT_YET_LOGGED_OUT);
        Assertions.assertEquals(0, actualCode, USER_HAS_NOT_YET_LOGGED_OUT);
    }

    @Step("Checking status")
    public void checkingStatus(String status) {
        Assertions.assertTrue(requests.getStatus().contains(status));
    }

    @Step("Put profile data")
    public void changingProfile() {
        LoginUserResponse loginUserResponse = requests.putProfile();
        int messages = loginUserResponse.getMessages().size();
        int actualCode = loginUserResponse.getResultCode();
        Assertions.assertEquals(0, messages, USER_HAS_NOT_YET_LOGGED_OUT);
        Assertions.assertEquals(0, actualCode, USER_HAS_NOT_YET_LOGGED_OUT);
    }

    @Step("Checking profile")
    public void checkingProfile() {
        Assertions.assertTrue(requests.getProfile().getFullName().contains(FULL_NAME));
        Assertions.assertTrue(requests.getProfile().getAboutMe().contains(ABOUT_ME));
        Assertions.assertTrue(requests.getProfile().getLookingForAJob());
        Assertions.assertTrue(requests.getProfile().getContacts().getVk().contains(VK_CONTACT));
    }
}
