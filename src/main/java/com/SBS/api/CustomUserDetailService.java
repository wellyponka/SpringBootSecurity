package com.SBS.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.SBS.bean.Account;
import com.SBS.mapper.AccountMapper;

public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private AccountMapper accMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username == null)
			throw new UsernameNotFoundException("User Not Found!!!");
		Account acc = this.accMapper.findByName(username);
		System.out.println("-----"+ username +"--------");
		System.out.println("-----"+ acc.getName() +"--------");
		System.out.println("-----"+ acc.getPwd() +"--------");
		System.out.println("-----"+ acc.getRole() +"--------");
		User user = new User(acc.getName(), acc.getPwd(), getAuthorities(acc.getRole()));
		return user;
	}

	private List<SimpleGrantedAuthority> getAuthorities(String role) {
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority(role));
 
        return authList;
    }
}
