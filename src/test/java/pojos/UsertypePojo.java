package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsertypePojo {

    private String usertype;

    public UsertypePojo(String usertype) {
        this.usertype = usertype;
    }

    public UsertypePojo() {
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "Usertype{" +
                "usertype='" + usertype + '\'' +
                '}';
    }
}
