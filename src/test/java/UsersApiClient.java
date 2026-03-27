import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UsersApiClient {
    private static final String ENDPOINT = "https://jsonplaceholder.typicode.com/users";

    public static UsersApiResponse getUsers() {
        return new UsersApiResponse(given().get(ENDPOINT));
    }

    public static UsersApiResponse createUser(UserDto user) {
        return new UsersApiResponse(
                given()
                        .contentType(ContentType.JSON)
                        .body(user)
                        .when()
                        .post(ENDPOINT)
        );
    }

    public static UsersApiResponse updateUser(UserDto user,int userId) {
        return new UsersApiResponse(
                given()
                        .contentType(ContentType.JSON)
                        .body(user)
                        .when()
                        .put(ENDPOINT + "/" + userId)
        );
    }

    public static UsersApiResponse deleteUser(int userId) {
        return new UsersApiResponse(
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .delete(ENDPOINT + "/" + userId)

        );
    }
}
