/*
package cn.zhougq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @author zhouganqing
 * @create 2020- 10- 13- 15:45
 *//*


@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class EsProperties {
    */
/**
     * http连接超时时间
     *//*

    private String connectTimeout;

    */
/**
     * socket连接超时时间
     *//*

    private String socketTimeout;

    */
/**
     * 获取连接的超时时间
     *//*

    private String connectionRequestTimeout;

    */
/**
     * 最大连接数
     *//*

    private String maxConnTotal;

    */
/**
     * 最大路由连接数
     *//*

    private String maxConnPerRoute;

    */
/**
     * 用户名
     *//*

    private String username;

    */
/**
     * 密码
     *//*

    private String password;

    */
/**
     * Elasticsearch http访问路径
     *//*

    private String httpHost;

    public String getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(String socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(String connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public String getMaxConnTotal() {
        return maxConnTotal;
    }

    public void setMaxConnTotal(String maxConnTotal) {
        this.maxConnTotal = maxConnTotal;
    }

    public String getMaxConnPerRoute() {
        return maxConnPerRoute;
    }

    public void setMaxConnPerRoute(String maxConnPerRoute) {
        this.maxConnPerRoute = maxConnPerRoute;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHttpHost() {
        return httpHost;
    }

    public void setHttpHost(String httpHost) {
        this.httpHost = httpHost;
    }
}
*/
