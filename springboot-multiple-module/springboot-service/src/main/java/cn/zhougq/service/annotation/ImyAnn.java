package cn.zhougq.service.annotation;

import java.lang.annotation.*;

/**
 * @author zhouganqing
 * @create 2020- 09- 20- 15:56
 *
 * @interface 自定义注解,一个注解是一个类
 * 元注解： @Documented @Inherited @Target @Retention
 * 可注解（自定义）注解的注解叫元注解
 */

/*@Documented 表示生成javadoc时会包含注释*/
@Documented
/*@Inherited表示允许子类继承
* 如果一个使用了@Inherited 修饰的annotation 类型被用于一个class
* 则这个annotation 将被用于该class 的子类
* */
@Inherited
/*@Target注解表示该注解能加到哪些属性上
* 常用：METHOD\TYPE()\FIELD()
* CONSTRUCTOR: 用于描述构造器
  LOCAL_VARIABLE: 用于描述局部变量
  PACKAGE: 用于描述包
  PARAMETER: 用于描述参数
  METHOD: 用于描述方法
  FIELD: 成员变量、对象、属性（包括enum实例）
  TYPE: 用于描述类、接口(包括注解类型) 或enum声明
* */
@Target(ElementType.METHOD)
/*@Retention表示该注解的作用域
* SOURCE: 在编译阶段丢弃。这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。
*          @Override, @SuppressWarnings都属于这类注解。
* CLASS:  在类加载的时候丢弃。在字节码文件的处理中有用。注解默认使用这种方式
* RUNTIME:始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。
*         我们自定义的注解通常使用这种方式。
* */
@Retention(RetentionPolicy.RUNTIME)
public @interface ImyAnn {

    /*
    要获取类方法和字段的注解信息，必须通过Java的反射技术来获取 Annotation 对象
    Redis key
    */
    String key();

    int waitTime() default 5;//秒为单位

    int leaseTime() default 30;//秒为单位
}
