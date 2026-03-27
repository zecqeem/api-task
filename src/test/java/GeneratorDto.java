public class GeneratorDto {

    public static UserDto createUserToPost(){
        return UserDto.builder()
                .name("Illia")
                .username("zecqeem")
                .email("zecqeem@qwe.edu")
                .build();
    }

    public static UserDto updateUserToPut(){
        return UserDto.builder()
                .name("Lionel")
                .username("la pulga")
                .email("91inayear@qwe.edu")
                .build();
    }
}
