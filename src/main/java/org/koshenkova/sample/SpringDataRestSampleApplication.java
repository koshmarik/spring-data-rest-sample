package org.koshenkova.sample;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.koshenkova.sample.domain.MapPoint;
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


	@Bean
	public Module sampleModule() {
		return new SampleModule();
	}

	@SuppressWarnings("serial")
	static class SampleModule extends SimpleModule {

		public SampleModule() {

			setMixInAnnotation(MapPoint.class, SampleModule.MapPointMixin.class);
		}

		@JsonAutoDetect
		static abstract class MapPointMixin {

			@JsonCreator
			public MapPointMixin(String name, String link) {}
		}

	}


	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestSampleApplication.class, args);
	}



}
