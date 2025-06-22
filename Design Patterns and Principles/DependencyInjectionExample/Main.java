
interface CustomerRepository {
    String findCustomerById(int id);
}


class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        
        if (id == 1) {
            return "Customer: Harshi";
        } else if (id == 2) {
            return "Customer: Rishi";
        } else {
            return "Customer not found";
        }
    }
}


class CustomerService {
    private CustomerRepository repository;

    
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerDetails(int id) {
        String customer = repository.findCustomerById(id);
        System.out.println(customer);
    }
}


public class Main {
    public static void main(String[] args) {
        
        CustomerRepository repo = new CustomerRepositoryImpl();

        
        CustomerService service = new CustomerService(repo);

        
        service.getCustomerDetails(1);  
        service.getCustomerDetails(2); 
        service.getCustomerDetails(3);  
    }
}
