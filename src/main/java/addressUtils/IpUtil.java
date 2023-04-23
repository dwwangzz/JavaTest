package com.sai.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IP辅助类
 * ip: "112.53.80.130",
 * ipAddress: "112.53.80.130, 192.168.32.38,192.168.32.57",
 * localIp: "192.168.32.38/112.53.80.130",
 * ip2: "192.168.32.38/112.53.80.130,192.168.32.57"
 * @author (作者) wangzz
 * @version (版本) V1.0
 * @date (开发日期) 2015年11月26日 上午10:01:21
 * @since (该版本支持的JDK版本) 1.7
 */
@Slf4j
public class IpUtil2 {

    private static final String ANYHOST_VALUE = "0.0.0.0";
    private static final String LOCALHOST_VALUE = "127.0.0.1";
    public static final boolean PREFER_IPV6_ADDRESSES = Boolean.parseBoolean(System.getProperty("java.net.preferIPv6Addresses"));
    public static final String IPV6_START_MARK = "[";
    public static final String IPV6_END_MARK = "]";
    public static final String ILLEGAL_IP_PREFIX = "illegal ip: ";
    public static final String IP_PORT_SPLITER = ":";
    public static final int SPLIT_IP_PORT_RESULT_LENGTH = 2;
    public static final String PERCENT_SIGN_IN_IPV6 = "%";
    private static final String LOCAL_HOST_IP_V4 = "127.0.0.1";
    private static final String LOCAL_HOST_IP_V6 = "[::1]";
    private static final Pattern ipv4Pattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    //private static final Pattern ipv4Pattern = Pattern.compile("^" + "(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)" + "(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}" + "$");
    private static final int IPV4_ADDRESS_LENGTH = 4;
    private static final int IPV6_ADDRESS_LENGTH = 16;
    private static final String CHECK_OK = "ok";
    private static volatile InetAddress LOCAL_ADDRESS = null;

    private static final Pattern IPV4_PATTERN = Pattern
            .compile("^" + "(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)" + "(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}" + "$");
    private static final Pattern IPV6_STD_PATTERN = Pattern
            .compile("^" + "(?:[0-9a-fA-F]{1,4}:){7}" + "[0-9a-fA-F]{1,4}" + "$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern
            .compile("^" + "(" + "(?:[0-9A-Fa-f]{1,4}" + "(?::[0-9A-Fa-f]{1,4})*)?" + ")" + "::"
                    + "(" + "(?:[0-9A-Fa-f]{1,4}" + "(?::[0-9A-Fa-f]{1,4})*)?" + ")" + "$");
    private static final Pattern IPV6_MIXED_COMPRESSED_REGEX = Pattern.compile(
            "^" + "(" + "(?:[0-9A-Fa-f]{1,4}" + "(?::[0-9A-Fa-f]{1,4})*)?" + ")" + "::" + "(" + "(?:[0-9A-Fa-f]{1,4}:"
                    + "(?:[0-9A-Fa-f]{1,4}:)*)?" + ")" + "$");
    private static final Pattern IPV6_MIXED_UNCOMPRESSED_REGEX = Pattern
            .compile("^" + "(?:[0-9a-fA-F]{1,4}:){6}" + "$");


    /**
     * 获得用户的真实IP地址
     * @param request
     * @return 真实IP地址字符串(如果request为null则返回 " unknown " 字符串)
     * @author wangzz
     * @date 2015年11月27日 上午11:22:12
     */
    public static String getIpAddress(HttpServletRequest request) {
        try {
            if (request == null) {
                return null;
            }
            String ip = request.getHeader("x-forwarded-for");
            if (EmptyUtil.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (EmptyUtil.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (EmptyUtil.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
                ip = request.getHeader("X-Real-IP");
            }
            if (EmptyUtil.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
                ip = request.getRemoteAddr();
            }
            if ("0:0:0:0:0:0:0:1".equals(ip)) {
                ip = "127.0.0.1";
            }
            return ip;
        } catch (Exception e) {
            log.warn(Logz.log("IpUtil.getIpAddress", "获取ip错误"));
        }
        return null;
    }


    /**
     * 从Request对象中获得客户端IP，处理了HTTP代理服务器和Nginx的反向代理截取了ip
     * @param request
     * @return ip
     * @author wangzz
     */
    public static String getLocalIp(HttpServletRequest request) {
        try {
            if (request == null) {
                return null;
            }
            String remoteAddr = request.getRemoteAddr();
            String forwarded = request.getHeader("X-Forwarded-For");
            String realIp = request.getHeader("X-Real-IP");

            String ip = null;
            if (realIp == null) {
                if (forwarded == null) {
                    ip = remoteAddr;
                } else {
                    ip = remoteAddr + "/" + forwarded.split(",")[0];
                }
            } else {
                if (realIp.equals(forwarded)) {
                    ip = realIp;
                } else {
                    if (forwarded != null) {
                        forwarded = forwarded.split(",")[0];
                    }
                    ip = realIp + "/" + forwarded;
                }
            }
            return ip;
        } catch (Exception e) {
            log.warn(Logz.log("IpUtil.getLocalIp", "获取ip错误"));
        }
        return null;
    }

    /**
     * 获取客户端ip地址(推荐)
     * @param request
     * @return ip
     * @author wangzz
     */
    public static String getIp(HttpServletRequest request) {
        try {
            if (request == null) {
                return null;
            }
            String ip = request.getHeader("X-Forwarded-For");
            if (EmptyUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
                //多次反向代理后会有多个ip值，第一个ip才是真实ip
                int index = ip.indexOf(",");
                if (index != -1) {
                    return ip.substring(0, index);
                } else {
                    return ip;
                }
            }
            ip = request.getHeader("X-Real-IP");
            if (EmptyUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
                return ip;
            }
            ip = request.getRemoteAddr();
            ip = ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
            return ip;
        } catch (Exception e) {
            log.warn(Logz.log("IpUtil.getIp", "获取ip错误"));
        }
        return null;
    }

    /**
     * 获取客户端ip地址
     * @param request
     * @return ip
     * @author wangzz
     */
    public static String getIp2(HttpServletRequest request) {
        try {
            if (request == null) {
                return null;
            }
            String remoteAddr = request.getRemoteAddr();
            String forwarded = request.getHeader("X-Forwarded-For");
            String realIp = request.getHeader("X-Real-IP");

            String ip = null;
            if (realIp == null) {
                if (forwarded == null) {
                    ip = remoteAddr;
                } else {
                    ip = remoteAddr + "/" + forwarded;
                }
            } else {
                if (realIp.equals(forwarded)) {
                    ip = realIp;
                } else {
                    ip = realIp + "/" + forwarded.replaceAll(", " + realIp, "");
                }
            }
            return ip;
        } catch (Exception e) {
            log.warn(Logz.log("IpUtil.getIp2", "获取ip错误"));
        }
        return null;
    }

    /**
     * 验证网卡
     * @param address
     * @return
     */
    private static InetAddress toValidAddress(InetAddress address) {
        if (address instanceof Inet6Address) {
            Inet6Address v6Address = (Inet6Address) address;
            if (PREFER_IPV6_ADDRESSES) {
                return normalizeV6Address(v6Address);
            }
        }
        if (isValidV4Address(address)) {
            return address;
        }
        return null;
    }

    /**
     * valid Inet4Address
     * @param address
     * @return
     */
    private static boolean isValidV4Address(InetAddress address) {
        if (address == null || address.isLoopbackAddress()) {
            return false;
        }
        String name = address.getHostAddress();
        boolean result = (name != null
                && ipv4Pattern.matcher(name).matches()
                && !ANYHOST_VALUE.equals(name)
                && !LOCALHOST_VALUE.equals(name));
        return result;
    }


    /**
     * normalize the ipv6 Address, convert scope name to scope id.
     * e.g.
     * convert
     * fe80:0:0:0:894:aeec:f37d:23e1%en0
     * to
     * fe80:0:0:0:894:aeec:f37d:23e1%5
     * <p>
     * The %5 after ipv6 address is called scope id.
     * see java doc of {@link Inet6Address} for more details.
     * @param address the input address
     * @return the normalized address, with scope id converted to int
     */
    private static InetAddress normalizeV6Address(Inet6Address address) {
        String addr = address.getHostAddress();
        int i = addr.lastIndexOf('%');
        if (i > 0) {
            try {
                return InetAddress.getByName(addr.substring(0, i) + '%' + address.getScopeId());
            } catch (UnknownHostException e) {
                // ignore
                log.debug("Unknown IPV6 address: ", e);
            }
        }
        return address;
    }

    /**
     * 获取本机ip
     * @return
     */
    private static InetAddress getLocalAddress0() {
        InetAddress localAddress = null;
        try {
            localAddress = InetAddress.getLocalHost();
            InetAddress addressItem = toValidAddress(localAddress);
            if (addressItem != null) {
                return addressItem;
            }
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (null == interfaces) {
                return localAddress;
            }
            while (interfaces.hasMoreElements()) {
                try {
                    NetworkInterface network = interfaces.nextElement();
                    if (network.isLoopback() || network.isVirtual() || !network.isUp()) {
                        continue;
                    }
                    Enumeration<InetAddress> addresses = network.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        try {
                            InetAddress addressItem = toValidAddress(addresses.nextElement());
                            if (addressItem != null) {
                                try {
                                    // 地址是否可达
                                    if (addressItem.isReachable(100)) {
                                        return addressItem;
                                    }
                                } catch (IOException e) {
                                    // ignore
                                }
                            }
                        } catch (Throwable e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                } catch (Throwable e) {
                    log.error(e.getMessage(), e);
                }
            }
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
        return localAddress;
    }


    // ---------------------- tool ----------------------

    /**
     * Find first valid IP from local network card
     * @return first valid local IP
     */
    public static InetAddress getLocalAddress() {
        if (LOCAL_ADDRESS != null) {
            return LOCAL_ADDRESS;
        }
        InetAddress localAddress = getLocalAddress0();
        LOCAL_ADDRESS = localAddress;
        return localAddress;
    }

    /**
     * get ip address
     * @return String
     */
    public static String getIp() {
        return getLocalAddress().getHostAddress();
    }

    /**
     * get ip:port
     * @param port
     * @return String
     */
    public static String getIpPort(int port) {
        String ip = getIp();
        return getIpPort(ip, port);
    }

    public static String getIpPort(String ip, int port) {
        if (ip == null) {
            return null;
        }
        return ip.concat(IP_PORT_SPLITER).concat(String.valueOf(port));
    }

    public static String localHostIP() {
        return PREFER_IPV6_ADDRESSES ? "[::1]" : "127.0.0.1";
    }

    public static boolean isIPv4(String addr) {
        try {
            return InetAddress.getByName(addr).getAddress().length == IPV4_ADDRESS_LENGTH;
        } catch (UnknownHostException var2) {
            return false;
        }
    }

    public static boolean isIPv6(String addr) {
        try {
            return InetAddress.getByName(addr).getAddress().length == IPV6_ADDRESS_LENGTH;
        } catch (UnknownHostException var2) {
            return false;
        }
    }

    /**
     * 判断字符串是否为ip
     * 支持ipv4和ipv6，如：192.168.1.1，[1::1]，1::1，www.baidu.com
     * @param addr
     * @return
     */
    public static boolean isIP(String addr) {
        try {
            InetAddress.getByName(addr);
            return true;
        } catch (UnknownHostException var2) {
            return false;
        }
    }

    /**
     * 判断ip是否带端口
     * @param address
     * @return
     */
    public static boolean containsPort(String address) {
        return splitIPPortStr(address).length == SPLIT_IP_PORT_RESULT_LENGTH;
    }

    /**
     * 分割ip和端口号
     * @param str
     * @return
     */
    public static String[] splitIPPortStr(String str) {
        if (StringUtils.isBlank(str)) {
            throw new IllegalArgumentException("ip and port string cannot be empty!");
        } else {
            String[] serverAddrArr;
            if (str.startsWith("[") && StringUtils.containsIgnoreCase(str, "]")) {
                if (str.endsWith("]")) {
                    serverAddrArr = new String[]{str};
                } else {
                    serverAddrArr = new String[]{str.substring(0, str.indexOf("]") + 1), str.substring(str.indexOf("]") + 2)};
                }

                if (!isIPv6(serverAddrArr[0])) {
                    throw new IllegalArgumentException("The IPv6 address(\"" + serverAddrArr[0] + "\") is incorrect.");
                }
            } else {
                serverAddrArr = str.split(IP_PORT_SPLITER);
                if (serverAddrArr.length > 2) {
                    throw new IllegalArgumentException("The IP address(\"" + str + "\") is incorrect. If it is an IPv6 address, please use [] to enclose the IP part!");
                }

                if (!isIPv4(serverAddrArr[0])) {
                    throw new IllegalArgumentException("The IPv4 address(\"" + serverAddrArr[0] + "\") is incorrect.");
                }
            }

            return serverAddrArr;
        }
    }

    /**
     * 获取ip地址，根据全url,支持ipv4和ipv4
     * 如：http://192.168.1.1:443/xxx -> 192.168.1.1
     * @param str
     * @return
     */
    public static String getIPFromString(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        } else {
            String result = "";
            if (StringUtils.containsIgnoreCase(str, "[") && StringUtils.containsIgnoreCase(str, "]")) {
                result = str.substring(str.indexOf("["), str.indexOf("]") + 1);
                if (!isIPv6(result)) {
                    result = "";
                }
            } else {
                Matcher m = ipv4Pattern.matcher(str);
                if (m.find()) {
                    result = m.group();
                    if (!isIPv4(result)) {
                        result = "";
                    }
                }
            }

            return result;
        }
    }

    public static String checkIPs(String... ips) {
        if (ips != null && ips.length != 0) {
            StringBuilder illegalResponse = new StringBuilder();
            String[] var2 = ips;
            int var3 = ips.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                String ip = var2[var4];
                if (!isIP(ip)) {
                    illegalResponse.append(ip + ",");
                }
            }

            if (illegalResponse.length() == 0) {
                return "ok";
            } else {
                return "illegal ip: " + illegalResponse.substring(0, illegalResponse.length() - 1);
            }
        } else {
            return "ok";
        }
    }

    public static boolean checkOK(String checkIPsResult) {
        return "ok".equals(checkIPsResult);
    }

}

