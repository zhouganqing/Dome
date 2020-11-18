package cn.zhougq.util.jdk;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.*;
import java.util.Enumeration;

/**
 * @author zhouganqing
 * @create 2020- 09- 14- 20:21
 */
public class IPUtil {
    public static final String IP_UNKNOWN = "unknown";

    public static final String IP_LOCAL = "127.0.0.1";

    public static final String IP6_LOCAL = "0:0:0:0:0:0:0:1";

    public static final String MULTI_PROXY_IP_SEPERATOR = ",";

    public static final String UNKNOW = "unknown";

    /**
     * 字符串转换成整形
     */
    public static long ip2long(String ipAddress) {
        long result = 0;
        String[] ipAddressInArray = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {
            long ip = Long.parseLong(ipAddressInArray[3 - i]);
            result |= ip << (i * 8);
        }

        return result;
    }

    /**
     * 整形转换成字符串
     */
    public static String long2ip(long ip) {
        return ((ip >> 24) & 0xFF) + "."
                + ((ip >> 16) & 0xFF) + "."
                + ((ip >> 8) & 0xFF) + "."
                + (ip & 0xFF);
    }

    /**
     * 获取客户端IP地址
     * @param request
     * @return
     */
    public static String getClientIP(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !IP_UNKNOWN.equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(MULTI_PROXY_IP_SEPERATOR);

            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }

        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !IP_UNKNOWN.equalsIgnoreCase(ip)) {
            return ip;
        }

        return request.getRemoteAddr();
    }

    /**
     * 获取本地ip
     * @return null if 获取ip失败
     */
    public static String getLocalIp() {
        Enumeration allNetInterfaces = null;
        String ipv4Ip = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ignore) {
        }
        if (allNetInterfaces != null) {
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address) {
                        if (IP_LOCAL.equalsIgnoreCase(ip.getHostAddress())) {
                            continue;
                        }
                        ipv4Ip = ip.getHostAddress();
                    }
                }
            }
        }
        return ipv4Ip;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getLocalIp());

        try {
            InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
            String hostAddress = address.getHostAddress();
            InetAddress address1 = InetAddress.getByName("www.wodexiangce.cn");//获取的是该网站的ip地址，比如我们所有的请求都通过nginx的，所以这里获取到的其实是nginx服务器的IP地
            String hostAddress1 = address1.getHostAddress();//124.237.121.122
            InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");//根据主机名返回其可能的所有InetAddress对象
            for(InetAddress addr:addresses){
                System.out.println(hostAddress);//www.baidu.com/14.215.177.38
                //www.baidu.com/14.215.177.37
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Real-IP");
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("x-forwarded-for");
        }
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals(IP_LOCAL) || ipAddress.equals(IP6_LOCAL)) {
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(MULTI_PROXY_IP_SEPERATOR) > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(MULTI_PROXY_IP_SEPERATOR));
            }
        }
        return ipAddress;
    }
}
