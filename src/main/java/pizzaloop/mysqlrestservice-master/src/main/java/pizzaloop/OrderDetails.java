package pizzaloop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer customerId;
    private String pizzaName;
    private Double pizzaPrice;

    public OrderDetails() {

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(Double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public OrderDetails(Integer customerId, String pizzaName, Double pizzaPrice) {
        this.customerId = customerId;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;

    }
}
