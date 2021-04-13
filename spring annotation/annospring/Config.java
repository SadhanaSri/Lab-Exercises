package annospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean(name="getH")
	public HelloWorld get() {
		return new HelloWorld();
	}
}

class HelloWorld {
	
}