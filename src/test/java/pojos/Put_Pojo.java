package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Put_Pojo {

 /*
               {
                "id": 29,
                "brand": "Bellissima"
                }
  */

    private Integer id;
    private  String brand;

    public Put_Pojo(Integer id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Put_Pojo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Put_Pojo{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}
