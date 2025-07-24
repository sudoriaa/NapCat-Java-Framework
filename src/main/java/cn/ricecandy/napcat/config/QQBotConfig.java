package cn.ricecandy.napcat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "qq.bot")
@Data
public class QQBotConfig {
    private String qqId;
    private String token;
    private String callbackUrl;
    private String apiBaseUrl;
}