package com.SBS.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.SBS.bean.Account;

@Mapper
public interface AccountMapper {

	@Select("select * from Account where name = #{name}")
	Account findByName(@Param("name") String name);
}
