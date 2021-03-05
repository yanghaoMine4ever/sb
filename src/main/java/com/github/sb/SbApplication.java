package com.github.sb;

import com.github.sb.web.model.SbResult;
import com.github.sb.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@SpringBootApplication
@MapperScan
@EnableWebMvc
public class SbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbApplication.class, args);
	}

	@Autowired
	private UserMapper userMapper;

	@GetMapping(value = "/")
	public String index() {
		List<Map<String, Object>> userList = userMapper.selectList();
		userList.forEach(System.out::println);
		return "<h1>Hello SB!</h1>";
	}

	@GetMapping("t")
	public SbResult<String> testAdvice() {
		return SbResult.success("测试数据");
	}

}
