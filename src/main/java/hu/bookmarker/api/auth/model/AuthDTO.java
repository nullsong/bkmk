package hu.bookmarker.api.auth.model;

import lombok.Data;

@Data
public class AuthDTO {
    private String userId;
    private String password;
}
