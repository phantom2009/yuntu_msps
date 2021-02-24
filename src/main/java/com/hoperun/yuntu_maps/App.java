package com.hoperun.yuntu_maps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.hoperun.yuntu_maps.mapper"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
