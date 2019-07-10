package huynh198.com.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"huynh198.com.github.entity"})
public class ShopppingCartSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopppingCartSpringBootApplication.class, args);
	}

}
