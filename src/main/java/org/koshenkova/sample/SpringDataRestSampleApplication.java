package org.koshenkova.sample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@SpringBootApplication
public class SpringDataRestSampleApplication {

	private static Log logger = LogFactory.getLog(SpringDataRestSampleApplication.class);

	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {
			@Override
			public void contextInitialized(ServletContextEvent sce) {
				logger.info("ServletContext initialized");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				logger.info("ServletContext destroyed");
			}

		};
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.setBasePath("/api");
			}
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestSampleApplication.class, args);
	}
}
