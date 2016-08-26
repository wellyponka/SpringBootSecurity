package com.SBS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.SBS.bean.Account;

@Mapper
public interface AccountMapper {

	@Select("select * from Account where name = #{name}")
	Account findByName(@Param("name") String name);
	
	@Select("select * from Account")
	List<Account> getAllAccount();
	
	@Insert("insert into Account (name, pwd, role) values (#{name}, #{pwd}, #{role})")
	int registerUser(Account acc);
}
