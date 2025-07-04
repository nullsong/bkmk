package hu.bookmarker.api.login.model;

import lombok.Data;

@Data
public class LoginDTO {
    private String userId;
    private String password;
}
