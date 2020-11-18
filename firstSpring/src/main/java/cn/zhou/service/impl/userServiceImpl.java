package cn.zhou.service.impl;


import cn.zhou.InterFaces.UserBase;
import cn.zhou.pojo.User;
import cn.zhou.service.userService;

/**
 * @author zhouganqing
 * @create 2020- 07- 16- 18:01
 */
public class userServiceImpl implements userService {

    /*声明数据层接口类型的引用，和具体的实体实现解耦合*/
    private UserBase dao;

    /*用于setter构造*/
    public void setDao(UserBase dao) {
        this.dao = dao;
    }

    private String str1 = "";
    private String str2 = "";
    private Integer int1 =0;
    //无参构造函数
    public userServiceImpl(){}

    /*只有一个实体参数*/
    public userServiceImpl(UserBase dao) {
        this.dao =dao;
    }


    /*通过索引指定构造函数顺序*/
    public userServiceImpl(String str1, UserBase dao){
        this.str1=str1;
        this.dao = dao;
    }

    /*为dao赋值的有参构造函数*/
    public userServiceImpl(UserBase dao, String str2){
        this.str2=str2;
        this.dao = dao;
    }
    public userServiceImpl(UserBase dao, int int1){
        this.int1=int1;
        this.dao = dao;
    }


    @Override
    public void addUser(User user) {
        System.out.println("s1:"+this.str1);
        System.out.println("s2:"+this.str2);
        System.out.println("i1:"+this.int1);
        this.dao.save(user);
    }
}
