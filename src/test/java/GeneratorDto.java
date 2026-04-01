public class GeneratorDto {

    public static UserDto createDefaultUser(){
        return UserDto.builder()
                .name("Illia")
                .username("zecqeem")
                .email("zecqeem@qwe.edu")
                .build();
    }

    public static UserDto createUpdatedUser(){
        return UserDto.builder()
                .name("Lionel")
                .username("la pulga")
                .email("91inayear@qwe.edu")
                .build();
    }
}
