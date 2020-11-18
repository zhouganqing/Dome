package cn.zhougq.Entitys;

import javax.persistence.*;

/**
 * @author zhouganqing
 * @create 2020- 08- 04- 17:40
 */
@Entity
@Table(name = "SYS_USER_ADDRESS", schema = "DAFY_OA2", catalog = "")
public class SysUserAddress {
    private int id;
    private String province;
    private String city;
    private String region;
    private String address;
    private long addressType;
    private String street;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PROVINCE")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "REGION")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ADDRESS_TYPE")
    public long getAddressType() {
        return addressType;
    }

    public void setAddressType(long addressType) {
        this.addressType = addressType;
    }

    @Basic
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserAddress that = (SysUserAddress) o;

        if (id != that.id) return false;
        if (addressType != that.addressType) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (int) (addressType ^ (addressType >>> 32));
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }
}
