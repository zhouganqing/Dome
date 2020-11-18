package com.zhougq.ref;

/**
 * @author zhouganqing
 * @create 2020- 05- 27- 11:34
 */
public class CustomerMod {

    private final static String TAG = "BookTag";

    private Long id;
    private String name;
    private int age;

    public CustomerMod() {}

    private CustomerMod(String name,int age) {
        this.name = name;
        this.age = age;
    }

    private String declaredMethod(int index,String index2) {
        String string1 = null;
        switch (index) {
            case 1:
                string1 = index2 +"I am declaredMethod 1 !";
                break;
            case 2:
                string1 = index2 +"I am declaredMethod 2 !";
                break;
            default:
                string1 = index2 +"I am declaredMethod "+index+" !";
        }
        return string1;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name +
                "', age='" + age +
                "'}";
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id=id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age=age;
    }

}
