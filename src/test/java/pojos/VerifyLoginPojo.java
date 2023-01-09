package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VerifyLoginPojo {

    private String email;
    private String password;

    public VerifyLoginPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public VerifyLoginPojo() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "VerifyLoginPojo{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
