package pizzaloop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderRepository extends CrudRepository<OrderDetails, Integer> {
    /*
     * Find pizza by Id
     */


    /*
     * Delete pizza by Id
     */


    List<OrderDetails> findByCustomerId(Integer id);

    List<OrderDetails> deleteByCustomerId(Integer id);


}
