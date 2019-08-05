package com.liusuizhu.page.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.liusuizhu.page.interceptor.InterceptorHandler;
import com.liusuizhu.page.util.DateTimeUtil;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 拦截器、json、MyBatis配置
 *
 * @author John Liu
 */
@Configuration
@MapperScan({ "com.liusuizhu.page.dao" })
public class AppConfig extends JsonSerializer<Object> implements
		WebMvcConfigurer {

	@Value("${server.port}")
	private int port;

	@Value("${server.custom.httpPort}")
	private int httpPort;

	@Autowired
	private InterceptorHandler actionInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(actionInterceptor).addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Bean
	@Primary
	@ConditionalOnMissingBean(ObjectMapper.class)
	public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();

		// 通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
		// Include.Include.ALWAYS 默认
		// Include.NON_DEFAULT 属性为默认值不序列化
		// Include.NON_EMPTY 属性为 空（""） 或者为 NULL
		// 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
		// Include.NON_NULL 属性为NULL 不序列化,就是为null的字段不参加序列化
		objectMapper.setSerializationInclusion(Include.NON_NULL);

		// 所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
		objectMapper.setDateFormat(new SimpleDateFormat(
				DateTimeUtil.STANDARD_FORMAT));

		// this.setNullValueSerializer(objectMapper);

		return objectMapper;
	}

	@Override
	public void serialize(Object value, JsonGenerator gen,
			SerializerProvider serializers) throws IOException {
		gen.writeString("");
	}
	
	@SuppressWarnings("unused")
	private void setNullValueSerializer(ObjectMapper objectMapper) {
        objectMapper.getSerializerProvider().setNullValueSerializer(this);
    }

	@Bean
	public Connector connector(){
		Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(httpPort);
		connector.setSecure(false);
		connector.setRedirectPort(port);
		return connector;
	}

	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory()
		{
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(connector());
		return tomcat;
	}

}
