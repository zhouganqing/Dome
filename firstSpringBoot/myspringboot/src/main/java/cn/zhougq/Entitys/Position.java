package cn.zhougq.Entitys;

import org.springframework.stereotype.Component;

/**
 * @author zhouganqing
 * @create 2020- 08- 23- 13:32
 */

@Component
public class Position {
    private String name;
    private Double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
