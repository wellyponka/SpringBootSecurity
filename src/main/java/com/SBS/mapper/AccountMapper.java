package com.SBS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.SBS.bean.Account;

@Mapper
public interface AccountMapper {

	@Select("select * from Account where name = #{name}")
	Account findByName(@Param("name") String name);
	
	@Select("select * from Account")
	List<Account> getAllAccount();
	
	@Insert("insert into Account (name, pwd, role) values (#{name}, #{pwd}, #{role})")
	int registerUser(Account acc);
	
	@Delete("DELETE FROM Account WHERE name=#{name}")
	int removeUser(Account acc);
	
	@Update("UPDATE Account SET pwd = #{pwd} WHERE name = #{name}")
	int editUser(Account acc);
}
