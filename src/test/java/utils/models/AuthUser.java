package utils.models;

public class AuthUser{
    public final String email;
    public final String password;

    public AuthUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
