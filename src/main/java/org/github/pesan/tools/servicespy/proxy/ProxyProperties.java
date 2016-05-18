package org.github.pesan.tools.servicespy.proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
@ConfigurationProperties(prefix="proxy")
public class ProxyProperties {

    public static class Mapping {
        private Pattern pattern;
        private String url;
        private boolean active = true;

        public Pattern getPattern() { return pattern; }
        public void setPattern(String pattern) { this.pattern = Pattern.compile(pattern); }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public boolean isActive() { return active; }
        public void setActive(boolean active) { this.active = active; }
    }

    private int port;
    private List<Mapping> mappings = new ArrayList<>();

    private int connectionTimeout = 5000;
    private int idleTimeout = 5000;

    @JsonIgnore
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }

    @JsonIgnore
    public int getConnectionTimeout() { return connectionTimeout; }
    public void setConnectionTimeout(int connectionTimeout) { this.connectionTimeout = connectionTimeout; }

    @JsonIgnore
    public int getIdleTimeout() { return idleTimeout; }
    public void setIdleTimeout(int idleTimeout) { this.idleTimeout = idleTimeout; }

    public List<Mapping> getMappings() { return mappings; }
}