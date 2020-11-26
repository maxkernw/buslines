package com.topBusLines.topBusLines;

import com.topBusLines.topBusLines.interceptors.RequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TopBusLinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopBusLinesApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		var restTemplate = builder.build();

		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

		if (CollectionUtils.isEmpty(interceptors)) {
			interceptors = new ArrayList<>();
		}

		interceptors.add(new RequestInterceptor());
		restTemplate.setInterceptors(interceptors);

		return restTemplate;
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Logger logger(InjectionPoint injectionPoint){
		return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getContainingClass());
	}
}
