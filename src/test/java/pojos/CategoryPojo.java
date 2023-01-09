package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryPojo {

    private UsertypePojo usertype;
    private String category;

    public CategoryPojo(UsertypePojo usertype, String category) {
        this.usertype = usertype;
        this.category = category;
    }

    public CategoryPojo() {
    }

    public UsertypePojo getUsertype() {
        return usertype;
    }

    public void setUsertype(UsertypePojo usertype) {
        this.usertype = usertype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "usertype=" + usertype +
                ", category='" + category + '\'' +
                '}';
    }
}
