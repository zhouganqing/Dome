package cn.zhou.pojo;

import java.util.*;

/**
 * @author zhouganqing
 * @create 2020- 07- 17- 14:17
 */
public class TestEntity {
    private String specialChar1;//特殊字符1
    private String specialChar2;//特殊字符2
    private User user;
    private String[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties props;//属性文件格式
    private String emptyValue;//空字符串
    private String nullValue ="init value";//null值,先给个初始值,用于判断赋值null是否成功

    public String getSpecialChar1() {
        return specialChar1;
    }

    public void setSpecialChar1(String specialChar1) {
        this.specialChar1 = specialChar1;
    }

    public String getSpecialChar2() {
        return specialChar2;
    }

    public void setSpecialChar2(String specialChar2) {
        this.specialChar2 = specialChar2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public String getEmptyValue() {
        return emptyValue;
    }

    public void setEmptyValue(String emptyValue) {
        this.emptyValue = emptyValue;
    }

    public String getNullValue() {
        return nullValue;
    }

    public void setNullValue(String nullValue) {
        this.nullValue = nullValue;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "specialChar1='" + specialChar1 + '\'' +
                ", specialChar2='" + specialChar2 + '\'' +
                ", user=" + user.toString() +
                ", array=" + Arrays.toString(array) +
                ", list=" + list.toString() +
                ", set=" + set +
                ", map=" + map +
                ", props=" + props +
                ", emptyValue='" + emptyValue + '\'' +
                ", nullValue='" + nullValue + '\'' +
                '}';
    }
}
