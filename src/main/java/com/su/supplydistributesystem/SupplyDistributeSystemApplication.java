package com.su.supplydistributesystem;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PreDestroy;
import java.lang.reflect.Field;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.su",
		"com.sug.core.platform.web",
		"com.sug.core.rest"
})
public class SupplyDistributeSystemApplication {

	@Autowired
	private HikariDataSource dataSource;

	@PreDestroy
	public void disconnect() throws NoSuchFieldException, IllegalAccessException {
		System.out.println("application exits,disconnect with HikariDataSource");
		Field pool = HikariDataSource.class.getDeclaredField("pool");
		pool.setAccessible(true);
		((HikariPoolMXBean) pool.get(dataSource)).softEvictConnections();
	}

	public static void main(String[] args) {
		SpringApplication.run(SupplyDistributeSystemApplication.class, args);
	}

}

