package com.zhougq.ListMapSet;

import java.util.Objects;

/**
 * @author zhouganqing
 * @create 2020- 05- 20- 15:05
 */
public  class  TempClass implements Comparable
{
    private int i1;
    private Integer i2;
    private  String str1;

    public  TempClass() {

    }

    public  TempClass(int _i1) {
        this.setI1(_i1);
    }

    public  TempClass(int _i1,String _str1) {
        this.setI1(_i1);
        this.setStr1(_str1);
    }

    public  TempClass(int _i1,Integer _i2) {
        this.setI1(_i1);
        this.setI2(_i2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempClass tempClass = (TempClass) o;
        return i1 == tempClass.i1 ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i1);
    }

    public Integer getI2() {
        return i2;
    }

    public void setI2(Integer i2) {
        this.i2 = i2;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    @Override
    public int compareTo(Object o) {
        TempClass tempC = (TempClass)o;
        if (this.i1==tempC.i1)
        {
            return 0;
        }
        else if(this.i1>tempC.i1)
        {
            return 1;
        }
        else {
           return -1;
        }
    }
}
