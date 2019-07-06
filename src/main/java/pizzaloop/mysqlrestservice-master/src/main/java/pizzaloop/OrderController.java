package pizzaloop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/demoOne")
public class OrderController{
        @Autowired
private OrderRepository orderRepository;
        private static final String SUCCESS= "Saved";
        /*
         * READ Operation
         * This method will list all the orders in the table
         * URI to access this: http://localhost:8080/demoOne/all
         */
        @GetMapping(path="/all")
        public @ResponseBody
        Iterable<OrderDetails> getOrderDetails() {
            return orderRepository.findAll();
        }

        /*izza ID
         * READ Operation based on Pizza ID
         * This method will return the details of a pizza specified by the id
         * URI to access this: http://localhost:8080/demoOne/findByCustomerId?id=2
         */
        @GetMapping(path="/findByCustomerId")
        public @ResponseBody
        List<OrderDetails> getOrderById(@RequestParam Integer id) {
            return orderRepository.findByCustomerId(id);
        }

        /*
         * CREATE Operation
         * This method will crate new pizza item in the database table
         * and returns the SUCCESS message
         * URI to access this: http://localhost:8080/demoOne/add?name=VegiPizza&price=2500.75
         */
        @GetMapping(path="/add")
        public @ResponseBody String addNewOrder(@RequestParam String pizzaName,@RequestParam Double pizzaPrice) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setPizzaName(pizzaName);
            orderDetails.setPizzaPrice(pizzaPrice);
            orderRepository.save(orderDetails);
            return SUCCESS;
        }

        /*
         * DELETE Operation
         * This method will delete existing pizza item by finding it using the ID
         * and returns the deleted item
         * URI to access this: http://localhost:8080/demoOne/deleteByPizzaId?id=2
         */
        @GetMapping(path="/deleteByCustomerId")
        public @ResponseBody List<OrderDetails> deleteOrderById(@RequestParam Integer id) {
            return orderRepository.deleteByCustomerId(id);
        }

        /*
         * UPDATE Operation
         * This method will update existing order details by finding it using the ID
         * and returns the updated data
         * URI to access this: http://localhost:8080/demoOne/update?id=1&name=updatedname=updated&price=1234.56
         */
        @GetMapping(path="/update")
        public @ResponseBody List<OrderDetails> updateOrderDetails(@RequestParam Integer id, @RequestParam String name,  @RequestParam Double price) {
            //First get all the order details according to the provided ID
            List<OrderDetails> orderDetailsList = orderRepository.findByCustomerId(id);
            if(!orderDetailsList.isEmpty()) {
                //Iterate through the order list
                for(OrderDetails orderDetails: orderDetailsList) {
                    //Set new values
                    orderDetails.setPizzaName(name);
                    orderDetails.setPizzaPrice(price);
                    //Update existing order item
                    orderRepository.save(orderDetails);
                }
            }
            return orderRepository.findByCustomerId(id);
        }
}