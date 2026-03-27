import io.restassured.response.Response;
import java.util.List;

public class UsersApiResponse {

    private final Response response;

    public UsersApiResponse(Response response) {
        this.response = response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getContentTypeHeader() {
        return response.getHeader("Content-Type");
    }

    public List<UserDto> getUsersAsDto() {
        return response.jsonPath().getList("", UserDto.class);
    }

    public UserDto getUserAsDto() {
        return response.as(UserDto.class);
    }
}
