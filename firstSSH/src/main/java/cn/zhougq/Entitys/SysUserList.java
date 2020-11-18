package cn.zhougq.Entitys;

import javax.persistence.*;
import java.sql.Time;

/**
 * @author zhouganqing
 * @create 2020- 08- 04- 17:40
 */
@Entity
@Table(name = "SYS_USER_LIST", schema = "DAFY_OA2", catalog = "")
public class SysUserList {
    private int id;
    private String userName;
    private boolean status;
    private String roleId;
    private String ident;
    private String password;
    private String phone;
    private String email;
    private String province;
    private String city;
    private String remark;
    private String easeMobName;
    private String updateUser;
    private Time updateTime;
    private String updateIp;
    private String prodType;
    private Long onlineFlag;
    private String gender;
    private boolean wxAttentionFlag;
    private String workingProperty;
    private String workingDate;
    private String duty;
    private String major;
    private String school;
    private String graduationDate;
    private String competency;
    private String education;
    private String degree;
    private String telphone;
    private String qq;
    private String emergencyContact;
    private Time confirmTime;
    private Time createTime;
    private String photoName;
    private String national;
    private Integer hrId;
    private String uuid;
    private String companyName;
    private String companyAddress;
    private String companyNo;
    private String deviceNumber;
    private String phoneSysType;
    private String manageArea;
    private String department2;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "STATUS")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "IDENT")
    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "EASE_MOB_NAME")
    public String getEaseMobName() {
        return easeMobName;
    }

    public void setEaseMobName(String easeMobName) {
        this.easeMobName = easeMobName;
    }

    @Basic
    @Column(name = "UPDATE_USER")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "UPDATE_TIME")
    public Time getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Time updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "UPDATE_IP")
    public String getUpdateIp() {
        return updateIp;
    }

    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp;
    }

    @Basic
    @Column(name = "PROD_TYPE")
    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    @Basic
    @Column(name = "ONLINE_FLAG")
    public Long getOnlineFlag() {
        return onlineFlag;
    }

    public void setOnlineFlag(Long onlineFlag) {
        this.onlineFlag = onlineFlag;
    }

    @Basic
    @Column(name = "GENDER")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "WX_ATTENTION_FLAG")
    public boolean isWxAttentionFlag() {
        return wxAttentionFlag;
    }

    public void setWxAttentionFlag(boolean wxAttentionFlag) {
        this.wxAttentionFlag = wxAttentionFlag;
    }

    @Basic
    @Column(name = "WORKING_PROPERTY")
    public String getWorkingProperty() {
        return workingProperty;
    }

    public void setWorkingProperty(String workingProperty) {
        this.workingProperty = workingProperty;
    }

    @Basic
    @Column(name = "WORKING_DATE")
    public String getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(String workingDate) {
        this.workingDate = workingDate;
    }

    @Basic
    @Column(name = "DUTY")
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Basic
    @Column(name = "MAJOR")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "SCHOOL")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "GRADUATION_DATE")
    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    @Basic
    @Column(name = "COMPETENCY")
    public String getCompetency() {
        return competency;
    }

    public void setCompetency(String competency) {
        this.competency = competency;
    }

    @Basic
    @Column(name = "EDUCATION")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "DEGREE")
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Basic
    @Column(name = "TELPHONE")
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Basic
    @Column(name = "QQ")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "EMERGENCY_CONTACT")
    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    @Basic
    @Column(name = "CONFIRM_TIME")
    public Time getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Time confirmTime) {
        this.confirmTime = confirmTime;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Time getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Time createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "PHOTO_NAME")
    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Basic
    @Column(name = "NATIONAL")
    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    @Basic
    @Column(name = "HR_ID")
    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    @Basic
    @Column(name = "UUID")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "COMPANY_ADDRESS")
    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Basic
    @Column(name = "COMPANY_NO")
    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    @Basic
    @Column(name = "DEVICE_NUMBER")
    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    @Basic
    @Column(name = "PHONE_SYS_TYPE")
    public String getPhoneSysType() {
        return phoneSysType;
    }

    public void setPhoneSysType(String phoneSysType) {
        this.phoneSysType = phoneSysType;
    }

    @Basic
    @Column(name = "MANAGE_AREA")
    public String getManageArea() {
        return manageArea;
    }

    public void setManageArea(String manageArea) {
        this.manageArea = manageArea;
    }

    @Basic
    @Column(name = "DEPARTMENT2")
    public String getDepartment2() {
        return department2;
    }

    public void setDepartment2(String department2) {
        this.department2 = department2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserList that = (SysUserList) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (wxAttentionFlag != that.wxAttentionFlag) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (ident != null ? !ident.equals(that.ident) : that.ident != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (easeMobName != null ? !easeMobName.equals(that.easeMobName) : that.easeMobName != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateIp != null ? !updateIp.equals(that.updateIp) : that.updateIp != null) return false;
        if (prodType != null ? !prodType.equals(that.prodType) : that.prodType != null) return false;
        if (onlineFlag != null ? !onlineFlag.equals(that.onlineFlag) : that.onlineFlag != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (workingProperty != null ? !workingProperty.equals(that.workingProperty) : that.workingProperty != null)
            return false;
        if (workingDate != null ? !workingDate.equals(that.workingDate) : that.workingDate != null) return false;
        if (duty != null ? !duty.equals(that.duty) : that.duty != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (school != null ? !school.equals(that.school) : that.school != null) return false;
        if (graduationDate != null ? !graduationDate.equals(that.graduationDate) : that.graduationDate != null)
            return false;
        if (competency != null ? !competency.equals(that.competency) : that.competency != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (telphone != null ? !telphone.equals(that.telphone) : that.telphone != null) return false;
        if (qq != null ? !qq.equals(that.qq) : that.qq != null) return false;
        if (emergencyContact != null ? !emergencyContact.equals(that.emergencyContact) : that.emergencyContact != null)
            return false;
        if (confirmTime != null ? !confirmTime.equals(that.confirmTime) : that.confirmTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (photoName != null ? !photoName.equals(that.photoName) : that.photoName != null) return false;
        if (national != null ? !national.equals(that.national) : that.national != null) return false;
        if (hrId != null ? !hrId.equals(that.hrId) : that.hrId != null) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (companyAddress != null ? !companyAddress.equals(that.companyAddress) : that.companyAddress != null)
            return false;
        if (companyNo != null ? !companyNo.equals(that.companyNo) : that.companyNo != null) return false;
        if (deviceNumber != null ? !deviceNumber.equals(that.deviceNumber) : that.deviceNumber != null) return false;
        if (phoneSysType != null ? !phoneSysType.equals(that.phoneSysType) : that.phoneSysType != null) return false;
        if (manageArea != null ? !manageArea.equals(that.manageArea) : that.manageArea != null) return false;
        if (department2 != null ? !department2.equals(that.department2) : that.department2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (ident != null ? ident.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (easeMobName != null ? easeMobName.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateIp != null ? updateIp.hashCode() : 0);
        result = 31 * result + (prodType != null ? prodType.hashCode() : 0);
        result = 31 * result + (onlineFlag != null ? onlineFlag.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (wxAttentionFlag ? 1 : 0);
        result = 31 * result + (workingProperty != null ? workingProperty.hashCode() : 0);
        result = 31 * result + (workingDate != null ? workingDate.hashCode() : 0);
        result = 31 * result + (duty != null ? duty.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (graduationDate != null ? graduationDate.hashCode() : 0);
        result = 31 * result + (competency != null ? competency.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (telphone != null ? telphone.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (emergencyContact != null ? emergencyContact.hashCode() : 0);
        result = 31 * result + (confirmTime != null ? confirmTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (photoName != null ? photoName.hashCode() : 0);
        result = 31 * result + (national != null ? national.hashCode() : 0);
        result = 31 * result + (hrId != null ? hrId.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        result = 31 * result + (companyNo != null ? companyNo.hashCode() : 0);
        result = 31 * result + (deviceNumber != null ? deviceNumber.hashCode() : 0);
        result = 31 * result + (phoneSysType != null ? phoneSysType.hashCode() : 0);
        result = 31 * result + (manageArea != null ? manageArea.hashCode() : 0);
        result = 31 * result + (department2 != null ? department2.hashCode() : 0);
        return result;
    }
}
