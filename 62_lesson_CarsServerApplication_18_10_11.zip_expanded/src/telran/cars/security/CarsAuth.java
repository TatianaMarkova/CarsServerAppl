package telran.cars.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import telran.cars.accounting.IAccounting;
@Configuration
public class CarsAuth implements UserDetailsService {
@Autowired
IAccounting accounts;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password=accounts.getPassword(username);
		
		return new User(username, "{noop}"+password,
				AuthorityUtils.createAuthorityList(accounts.getRoles(username)));
	}

}
