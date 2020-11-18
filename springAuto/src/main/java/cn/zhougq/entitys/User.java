package cn.zhougq.entitys;

import org.springframework.stereotype.Component;

/**
 * @author zhouganqing
 * @create 2020- 07- 18- 14:26
 */
@Component
public class User {
    private String userName;
    private String passWord;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
