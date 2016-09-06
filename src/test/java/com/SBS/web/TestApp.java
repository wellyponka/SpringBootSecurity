package com.SBS.web;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.test.ImportAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import com.SBS.Application;
import com.SBS.bean.Account;
import com.SBS.bean.Result;
import com.SBS.web.WebAccountCRUD;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@TestPropertySource(locations="classpath:test.properties")
@AutoConfigureMockMvc
public class TestApp {
	
	@Autowired
    private MockMvc mvc;
	
//	@MockBean
//    private WebAccountCRUD webAccount;
	
	@Test
	public void 取得所有Account() throws Exception {
//		given(this.webAccount.getAllAccount()).willReturn(new Result<Account>().setError(0).setMsg("fail"));
		
		this.mvc.perform(get("/api/WebAllAccount").accept(MediaType.APPLICATION_JSON_UTF8))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$.error").value(0))
        	.andExpect(jsonPath("$.msg").value("Get all account success"))
        	.andExpect(jsonPath("$.data").isArray())
        	.andExpect(jsonPath("$.data[0].name").value("Jerry"));
	}

}
