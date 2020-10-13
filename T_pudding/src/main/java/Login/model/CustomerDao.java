package Login.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;








@Component("myCustomerDao")
public class CustomerDao {
	
	private final String namespace="Login.model.Customer";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	


	public void insertData(Customer customer) {
		

		sqlSessionTemplate.insert(namespace + ".InsertData", customer);
	}



	public Customer getData(String customer_id) {
		Customer customer = null;
		customer = sqlSessionTemplate.selectOne(namespace + ".GetData",customer_id); 
		return customer;
	}



	public List<Customer> getDataList(Customer customer) {
		
		List<Customer> lists = new ArrayList<Customer>();
		
		lists = sqlSessionTemplate.selectList(namespace + ".ListData",customer);
		return lists ;
	}


	public Customer getDataList(String customer_name, String customer_hpnumber) {
		Customer customer = new Customer();
		customer.setCustomer_name(customer_name);
		customer.setCustomer_hpnumber(customer_hpnumber);
		sqlSessionTemplate.selectList(namespace + ".GetDataList",customer);
		return customer; 
	}



	public Customer getDataList(String customer_name, String customer_hpnumber, String customer_id) {
		Customer customer = new Customer();
		customer.setCustomer_name(customer_name);
		customer.setCustomer_hpnumber(customer_hpnumber);
		customer.setCustomer_id(customer_id);
		sqlSessionTemplate.selectList(namespace + ".GetDataList",customer);
		return customer; 
	}


}
