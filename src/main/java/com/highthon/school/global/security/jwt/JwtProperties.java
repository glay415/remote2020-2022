package com.highthon.school.global.security.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

	private final String secretKey;
	private final Long accessExp;
	private final String header;
	private final String prefix;

	public JwtProperties(String secretKey, Long accessExp, Long refreshExp, String header, String prefix) {
		this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
		this.accessExp = accessExp;
		this.header = header;
		this.prefix = prefix;
	}
}
