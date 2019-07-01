package demo.yanming.springboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;

/**
 * @Description: JAVAMELODY监控配置
 */
@Configuration
public class JavaMelodyConfig {

	/**
	 * 配置javamelody监控 spring boot 会按照order值的大小，从小到大的顺序来依次过滤
	 */
	@Bean
	@Order(Integer.MAX_VALUE - 1)
	public FilterRegistrationBean<MonitoringFilter> monitorFilter() {
		FilterRegistrationBean<MonitoringFilter> filterRegistrationBean = new FilterRegistrationBean<MonitoringFilter>(new MonitoringFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		// filterRegistrationBean.setName("monitoring");
		return filterRegistrationBean;
	}

	/**
	 * 配置javamelody监听器sessionListener
	 **/
	@Bean
	public ServletListenerRegistrationBean<SessionListener> sessionListener() {
		ServletListenerRegistrationBean<SessionListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<SessionListener>();
		servletListenerRegistrationBean.setListener(new SessionListener());
		return servletListenerRegistrationBean;
	}
}
