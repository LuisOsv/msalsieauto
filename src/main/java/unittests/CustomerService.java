package unittests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private static List<Customer> customers = new ArrayList<>();
	static {
		customers.add(new Customer(101, "Steve", "steve@apple.com", LocalDate.of(1955, 2, 24)));
		customers.add(new Customer(201, "Bill", "bill@microsoft.com", LocalDate.of(1955, 10, 28)));
		customers.add(new Customer(301, "Larry", "larry@gmail.com", LocalDate.of(1973, 8, 21)));
		customers.add(new Customer(401, "Sergey", "sergey@abc.xyz", LocalDate.of(1973, 3, 26)));
	}

	public List<Customer> findAll() {
		return customers;
	}

	public void add(Customer customer) {
		customer.setCustomerId(CustomerHelper.generateRandomId());
		customers.add(customer);
	}

	public List<Customer> remove(int customerId) {
		customers.removeIf(c -> c.getCustomerId() == customerId);
		return findAll();
	}

	public Optional<Customer> find(int customerId) {
		
		return customers.stream().filter(c -> c.getCustomerId() == customerId).findFirst();
	}

	public Optional<Customer> findByName(String customerName) {
		return customers.stream()
				.filter(customer -> customer.getCustomerName().contentEquals(customerName))
				.findFirst();
	}
}
