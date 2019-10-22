package unittests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class CustomerServiceUnitTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void itShouldFindAllUsers() {
        assertThat(customerService.findAll().size()).isGreaterThanOrEqualTo(4);
    }

    @Test
    public void itShouldFindUserById() {
        assertThat(customerService.find(101).isPresent()).isTrue();
    }

    @Test
    public void itShouldFindUserByName() {
        assertThat(customerService.findByName("Steve").isPresent()).isTrue();
    }

    @Test
    public void itShouldAddNewUser() {
        int randomId = CustomerHelper.generateRandomId();
        Customer customer =
                new Customer(randomId, "OsvAdd", "osv.add@tx.com",
                LocalDate.of(1990, 8, 11));
        customerService.add(customer);
        assertThat(customerService.findAll()).contains(customer);
    }

    @Test
    public void itShouldDeleteAUser(){
        int randomId = CustomerHelper.generateRandomId();
        Customer customer =
                new Customer(randomId, "OsvDel", "osv.del@tx.com",
                        LocalDate.of(1990, 8, 11));
        customerService.add(customer);
        Optional<Customer> customerFound = customerService.findByName("OsvDel");
        customerService.remove(customerFound.get().getCustomerId());
        List<Customer> customers = customerService.findAll();
        assertThat(customers).doesNotContain(customer);
    }
}
