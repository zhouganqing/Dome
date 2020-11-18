package cn.zhougq.config;

/**
 * @author zhouganqing
 * @create 2020- 08- 27- 11:47
 */

public class Position {
    private String name;
    private Double salary;

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

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
}
