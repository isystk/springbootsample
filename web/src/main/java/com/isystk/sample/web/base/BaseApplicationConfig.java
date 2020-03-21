package com.isystk.sample.web.base;

import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.isystk.sample.web.base.aop.LoggingFunctionNameInterceptor;
import com.isystk.sample.web.base.aop.RequestTrackingInterceptor;

public abstract class BaseApplicationConfig
		implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, WebMvcConfigurer {

	@Override
	public void customize(ConfigurableServletWebServerFactory container) {
	}

    @Bean
    public RequestTrackingInterceptor requestTrackingInterceptor() {
        // MDCにIDを設定してリクエストをトラッキングする
        return new RequestTrackingInterceptor();
    }

	@Bean
	public LoggingFunctionNameInterceptor loggingFunctionNameInterceptor() {
		// MDCに機能名を設定してログに出力する
		return new LoggingFunctionNameInterceptor();
	}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestTrackingInterceptor());
        registry.addInterceptor(loggingFunctionNameInterceptor());
    }

	/**
	 * [] を含むURLをGETしようとするとTomcatが400を返す 問題に対応
	 * @return
	 */
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory>
	    containerCustomizer(){
	    return new EmbeddedTomcatCustomizer();
	}
	private static class EmbeddedTomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
	    @Override
	    public void customize(TomcatServletWebServerFactory factory) {
	        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
	            connector.setAttribute("relaxedPathChars", "<>[\\]^`{|}");
	            connector.setAttribute("relaxedQueryChars", "<>[\\]^`{|}");
	        });
	    }
	}
}