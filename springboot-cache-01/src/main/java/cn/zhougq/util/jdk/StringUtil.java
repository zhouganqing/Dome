package cn.zhougq.util.jdk;

import cn.zhougq.constants.GlobalConstants;
import cn.zhougq.constants.enums.CharsetEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collection;

/**
 * @author zhouganqing
 * @create 2020- 09- 14- 20:12
 */
public class StringUtil {
    public static boolean isEmpty(CharSequence cs) {
        return StringUtils.isEmpty(cs);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static boolean isBlank(CharSequence cs) {
        return StringUtils.isBlank(cs);
    }

    public static boolean isNoneBlank(CharSequence cs) {
        return StringUtils.isNoneBlank(cs);
    }

    public static boolean isNotBlank(CharSequence cs) {
        return StringUtils.isNotBlank(cs);
    }

    /**
     * 将字符串有某种编码转变成另一种编码
     * @param string 编码的字符串
     * @param originCharset 原始编码格式
     * @param targetCharset 目标编码格式
     * @return String 编码后的字符串
     */
    public static String encodeString(String string, Charset originCharset, Charset targetCharset) {
        return new String(string.getBytes(originCharset), targetCharset);
    }

    /**
     * URL编码
     * @param string 编码字符串
     * @param charset 编码格式
     * @return String
     */
    public static String encodeUrl(String string, String charset) {
        if(isEmpty(charset)) {
            charset = GlobalConstants.CHARSET_CODE;
        }
        try {
            return URLEncoder.encode(string, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeUrl(String string) {
        return encodeUrl(string, GlobalConstants.CHARSET_CODE);
    }

    /**
     * URL编码
     * @param string 解码字符串
     * @param charset 解码格式
     * @return String
     */
    public static String decodeUrl(String string,String charset) {
        if(isEmpty(charset)) {
            charset = GlobalConstants.CHARSET_CODE;
        }
        try {
            return URLDecoder.decode(string,charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decodeUrl(String string) {
        return decodeUrl(string, GlobalConstants.CHARSET_CODE);
    }

    /**
     * 首字母转大写
     * @param str
     * @return
     */
    public static String firstCharToUpperCase(String str){
        if(Character.isUpperCase(str.charAt(0))){
            return str;
        }else{
            char[] cs=str.toCharArray();
            cs[0]-=32;
            return String.valueOf(cs);
        }
    }

    /**
     * 首字母转小写
     * @param str
     * @return
     */
    public static String firstCharToLowerCase(String str){
        if(Character.isLowerCase(str.charAt(0))){
            return str;
        }else{
            char[] cs=str.toCharArray();
            cs[0]+=32;
            return String.valueOf(cs);
        }
    }

    /**
     * 去字符串两端空格
     * @param str
     * @return
     */
    public static String trim(String str){
        return StringUtils.trim(str);
    }

    /**
     * 字符串判断是否相等
     * @return
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2){
        return StringUtils.equals(cs1, cs2);
    }

    /**
     * 字符串判断是否相等,忽略大小写
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equalsIgnoreCase(CharSequence str1, CharSequence str2){
        return StringUtils.equalsIgnoreCase(str1, str2);
    }

    /**
     * 去掉所有的空格，中文空格，Tab制表符，中文全角空格
     * @param str
     * @return
     */
    public static String trimAll(String str){
        return str.trim().replace(" ","").replace(" ","").replace("	","").replace("　","");
    }

    /**
     * 格式化字符串 如 "字符串%1$s字符串%2$s"
     * @param format
     * @param args
     * @return
     */
    public static String format(String format, Object...args){
        return String.format(format, args);
    }

    public static String[] split(String str){
        String[] arr = null;
        if(StringUtil.isNotBlank(str)){
            arr = StringUtils.split(str, CharsetEnum.SPLIT_CHARSET.getCharset());
        }
        return arr;
    }

    public static String getHasDefaultValue(String str) {
        if(StringUtil.isBlank(str)) {
            return CharsetEnum.EMPTY_CHARSET.getCharset();
        }
        return str;
    }

    /**
     * 把unicode编码转换为中文
     *
     * @param str
     * @return
     */
    public static String decodeUnicodeToUTF8(String str) {
        if (isBlank(str)) {
            return null;
        }
        StringBuilder resultSB = new StringBuilder();
        String sg = "\\u";
        int firstIndex;
        /**
         * 若字符串中没有需要unicode解码的，直接将原字符串返回
         */
        if (!str.contains(sg)) {
            return str;
        }

        while (str.contains(sg)) {
            String substring;
            if (str.startsWith(sg)) {
                /**
                 * 以\\u开头，需要先截去开头的\\u
                 */
                str = str.substring(2);
                //要转换的unicode码
                substring = str.substring(0, 4);
                str = str.substring(4);

                //把16进制的字符串转为int数字之后强转为char
                resultSB.append((char) Integer.parseInt(substring, 16));
            } else {
                firstIndex = str.indexOf(sg);
                //截取非unicode部分
                substring = str.substring(0, firstIndex);
                resultSB.append(substring);
                str = str.substring(firstIndex);
            }
        }

        return resultSB.append(str).toString();
    }
}
