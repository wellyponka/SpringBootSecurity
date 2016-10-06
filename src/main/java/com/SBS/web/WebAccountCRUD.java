package com.SBS.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SBS.bean.Account;
import com.SBS.bean.Result;
import com.SBS.mapper.AccountMapper;

@RestController
@RequestMapping("/api")
public class WebAccountCRUD {

	@Autowired
	private AccountMapper accMapper;
	
	@PostMapping("/WebRegister")
	public Result<?> regisert(@RequestParam String name, String pwd) {
		Account acc = new Account().setName(name).setPwd(pwd).setRole("ADMIN");
		if(this.accMapper.registerUser(acc) == 1)
			return new Result<Object>().setError(0).setMsg("Register success!!");
		else
			return new Result<Object>().setError(-1).setMsg("Register fail QQ");
	}
	
	@GetMapping("/WebAllAccount")
	public Result<Account> getAllAccount() {
		List<Account> acc = this.accMapper.getAllAccount();
		return new Result<Account>().setError(0).setMsg("Get all account success").setData(acc);
	}
	
	@PostMapping("/WebRemoveAccount")
	public Result<?> removeAccount(@RequestParam String name) {
		Account acc = new Account().setName(name);
		if(this.accMapper.removeUser(acc) == 1)
			return new Result<Object>().setError(0).setMsg("Remove user success!!");
		else
			return new Result<Object>().setError(-1).setMsg("Remove user fail QQ");
		
	}
	
	@PostMapping("/WebEditAccount")
	public Result<?> editAccount(@RequestParam String name, String pwd) {
		Account acc = new Account().setName(name).setPwd(pwd);
		if(this.accMapper.editUser(acc) == 1)
			return new Result<Object>().setError(0).setMsg("Edit user success!!");
		else
			return new Result<Object>().setError(-1).setMsg("Edit user fail QQ");
		
	}
}
