package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductListPojo {
    private Integer id;
    private String name;
    private String price;
    private String brand;
    private CategoryPojo category;

    public ProductListPojo(Integer id, String name, String price, String brand, CategoryPojo category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }

    public ProductListPojo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CategoryPojo getCategory() {
        return category;
    }

    public void setCategory(CategoryPojo category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", brand='" + brand + '\'' +
                ", category=" + category +
                '}';
    }
}
