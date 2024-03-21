package api.tests;

import api.jsonresponses.auth.DataUserResponse;
import api.jsonresponses.auth.LoginUserResponse;
import api.jsonresponses.profile.Profile;
import api.jsonresponses.users.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

import static api.constants.ConstantApi.*;
import static io.restassured.RestAssured.given;

public class Requests {
    String value;
    int userId;

    public List<Users> getAllUsers() {
        List<Users> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + USERS)
                .then().log().all()
                .extract().body().jsonPath()
                .getList("items", Users.class);
        return users;
    }

    public List<Users> getCertainNumberOfUsersOnPage(int quantity) {
        List<Users> users = given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam(COUNT, quantity)
                .get(URL + USERS)
                .then().log().all()
                .extract().body().jsonPath()
                .getList("items", Users.class);
        return users;
    }

    public List<Users> getUserNameStringForSearching(String userName) {
        List<Users> users = given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam(TERM, userName)
                .get(URL + USERS)
                .then().log().all()
                .extract().body().jsonPath()
                .getList("items", Users.class);
        return users;
    }

    public DataUserResponse getAuthUser() {
        DataUserResponse auth = given()
                .header("api-key", "6b95b811-a8c5-4127-9a7b-d92c9a2f2845")
                .cookie(".ASPXAUTH", value)
                .when()
                .contentType(ContentType.JSON)
                .get(URL + AUTH + ME)
                .then().log().all()
                .extract().body().jsonPath()
                .getObject("", DataUserResponse.class);
        return auth;
    }

    public LoginUserResponse postAuthUser(String email, String password) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email",email);
        jsonObj.put("password",password);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonObj.toString())
                .when()
                .post(URL + AUTH + LOGIN);


        Map<String, String> allDetailedCookies = response.cookies();

        value = allDetailedCookies.get(".ASPXAUTH");

        LoginUserResponse auth = response
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().jsonPath()
                .getObject("", LoginUserResponse.class);

        userId = auth.getData().getUserId();

        return auth;
    }

    public LoginUserResponse LogOutUser() {
        LoginUserResponse unauthorized = given()
                .header("api-key", "6b95b811-a8c5-4127-9a7b-d92c9a2f2845")
                .cookie(".ASPXAUTH", value)
                .when()
                .contentType(ContentType.JSON)
                .delete(URL + AUTH + LOGIN)
                .then().log().all()
                .extract().body().jsonPath()
                .getObject("", LoginUserResponse.class);
        return unauthorized;
    }

    public LoginUserResponse putStatus(String status) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("status",status);

        LoginUserResponse putStatus = given()
                .header("api-key", "6b95b811-a8c5-4127-9a7b-d92c9a2f2845")
                .cookie(".ASPXAUTH", value)
                .contentType(ContentType.JSON)
                .body(jsonObj.toString())
                .when()
                .put(URL + PROFILE + STATUS)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().jsonPath()
                .getObject("", LoginUserResponse.class);
        return putStatus;
    }

    public String getStatus() {
        String getStatus = given()
                .header("api-key", "6b95b811-a8c5-4127-9a7b-d92c9a2f2845")
                .cookie(".ASPXAUTH", value)
                .when()
                .contentType(ContentType.JSON)
                .get(URL + PROFILE + STATUS + "/" + userId)
                .then().log().all()
                .extract().body()
                .asString();
        return getStatus;
    }

    public LoginUserResponse putProfile() {
        JSONObject jsonObjContacts = new JSONObject();
        jsonObjContacts.put("vk",VK_CONTACT);


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("aboutMe",ABOUT_ME);
        jsonObj.put("contacts",jsonObjContacts);
        jsonObj.put("lookingForAJob",true);
        jsonObj.put("lookingForAJobDescription",true);
        jsonObj.put("fullName",FULL_NAME);
        jsonObj.put("status",CURRENT_STATUS);

        LoginUserResponse profile = given()
                .header("api-key", "6b95b811-a8c5-4127-9a7b-d92c9a2f2845")
                .cookie(".ASPXAUTH", value)
                .contentType(ContentType.JSON)
                .body(jsonObj.toString())
                .when()
                .put(URL + PROFILE)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().jsonPath()
                .getObject("", LoginUserResponse.class);
        return profile;
    }

    public Profile getProfile() {
        Profile getProfile = given()
                .header("api-key", "6b95b811-a8c5-4127-9a7b-d92c9a2f2845")
                .cookie(".ASPXAUTH", value)
                .when()
                .contentType(ContentType.JSON)
                .get(URL + PROFILE + "/" + userId)
                .then().log().all()
                .extract().body().jsonPath()
                .getObject("", Profile.class);
        return getProfile;
    }

}
