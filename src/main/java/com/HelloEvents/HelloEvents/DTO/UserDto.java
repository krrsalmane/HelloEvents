package com.HelloEvents.HelloEvents.DTO;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

public class UserDto {
    @Setter
    @Getter
    @NotNull

    private String Email;

    @Setter
    @NotNull

    private String password;
    private String matchingPassword;

    public UserDto(String email, String password, String matchingPassword) {
        Email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }


}
