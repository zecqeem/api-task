import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@Execution(ExecutionMode.CONCURRENT)
public class ApiTest {

    private static UsersApiResponse apiResponse;
    @BeforeAll
    public static void getUsersResponse() {
        apiResponse = UsersApiClient.getUsers();
    }
    @Test
    public void verifyContentTypeHeader(){
        assertThat(apiResponse.getContentTypeHeader())
                .as("Content-Type header is invalid")
                .isEqualTo("application/json; charset=utf-8");
    }
    @Test
    public void verifyStatusCode(){
        assertThat(apiResponse.getStatusCode())
                .as("Status code should be 200 OK")
                .isEqualTo(200);
    }
    @Test
    public void verifyResponseBodyContains10Users(){
        List<UserDto> users = apiResponse.getUsersAsDto();

        assertThat(users)
                .as("Response should contain exactly 10 users")
                .hasSize(10);
        assertThat(users.getFirst().getId())
                .as("First user id should be 1")
                .isEqualTo(1);
    }
    @Test
    public void verifyCreateUserPostRequest() {

        UserDto newUser = GeneratorDto.createUserToPost();
        UsersApiResponse response = UsersApiClient.createUser(newUser);
        assertThat(response.getStatusCode())
                .as("Status code should be 201 Created")
                .isEqualTo(201);

        UserDto createdUser = response.getUserAsDto();
        assertThat(createdUser.getName()).isEqualTo("Illia");
        assertThat(createdUser.getId()).isGreaterThan(0);
    }
    @Test
    public void verifyUpdateUserPutRequest() {

        UserDto updatedUser = GeneratorDto.updateUserToPut();
        UsersApiResponse response = UsersApiClient.updateUser(updatedUser,1);
        assertThat(response.getStatusCode())
                .as("Status code should be 200 OK")
                .isEqualTo(200);

        UserDto createdUser = response.getUserAsDto();
        assertThat(createdUser.getName()).isEqualTo("Lionel");
    }
    @Test
    public void deleteUserRequest() {
        UsersApiResponse response = UsersApiClient.deleteUser(1);
        assertThat(response.getStatusCode())
                .as("Status code should be 200 OK")
                .isEqualTo(200);
    }

}
