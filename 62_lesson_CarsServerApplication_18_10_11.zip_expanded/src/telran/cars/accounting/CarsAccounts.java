package telran.cars.accounting;

import java.util.HashMap;

import org.springframework.stereotype.Service;
@Service
public class CarsAccounts implements IAccounting {
HashMap<String,String> accounts;
public CarsAccounts() {
	accounts=new HashMap<>();
	accounts.put("Moshe", "12345.com");
}
	@Override
	public String getPassword(String username) {
		return accounts.getOrDefault(username, "");
	}

	@Override
	public String[] getRoles(String username) {
		
		return new String[] {"ROLE_USER"};
	}

}
