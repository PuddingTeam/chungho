package Login.model;

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



	public int idcheck(String customer_id) {
		int cnt = sqlSessionTemplate.selectOne(namespace + ".idcheck",customer_id);
		return cnt;
	}


	
	
}
