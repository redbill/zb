package cn.com.hugedata.web.fsm.user.model;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String email;

    private String password;

    private String realName;

    private String nickName;

    private String mobilephoneNumber;

    private String qq;

    private String weibo;

    private Date signUpTime;

    private Date lastSignInTime;

    private String lastSignInIp;

    private Integer userTypeId;

    private Integer status;

    private String memo;

    private String companyName;

    private String companyHomepage;

    private String companyProfession;

    private String smsVerificationCode;

    private String emailVerificationCode;

    private Date smsVerificationCodeGenerateTime;

    private Date emailVerificationCodeGenerateTime;

    private String idenfityCardId;

    private String institutionalId;

    private String legalPersonal;

    private String telephone;

    private Integer roletype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getMobilephoneNumber() {
        return mobilephoneNumber;
    }

    public void setMobilephoneNumber(String mobilephoneNumber) {
        this.mobilephoneNumber = mobilephoneNumber == null ? null : mobilephoneNumber.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo == null ? null : weibo.trim();
    }

    public Date getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
    }

    public Date getLastSignInTime() {
        return lastSignInTime;
    }

    public void setLastSignInTime(Date lastSignInTime) {
        this.lastSignInTime = lastSignInTime;
    }

    public String getLastSignInIp() {
        return lastSignInIp;
    }

    public void setLastSignInIp(String lastSignInIp) {
        this.lastSignInIp = lastSignInIp == null ? null : lastSignInIp.trim();
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyHomepage() {
        return companyHomepage;
    }

    public void setCompanyHomepage(String companyHomepage) {
        this.companyHomepage = companyHomepage == null ? null : companyHomepage.trim();
    }

    public String getCompanyProfession() {
        return companyProfession;
    }

    public void setCompanyProfession(String companyProfession) {
        this.companyProfession = companyProfession == null ? null : companyProfession.trim();
    }

    public String getSmsVerificationCode() {
        return smsVerificationCode;
    }

    public void setSmsVerificationCode(String smsVerificationCode) {
        this.smsVerificationCode = smsVerificationCode == null ? null : smsVerificationCode.trim();
    }

    public String getEmailVerificationCode() {
        return emailVerificationCode;
    }

    public void setEmailVerificationCode(String emailVerificationCode) {
        this.emailVerificationCode = emailVerificationCode == null ? null : emailVerificationCode.trim();
    }

    public Date getSmsVerificationCodeGenerateTime() {
        return smsVerificationCodeGenerateTime;
    }

    public void setSmsVerificationCodeGenerateTime(Date smsVerificationCodeGenerateTime) {
        this.smsVerificationCodeGenerateTime = smsVerificationCodeGenerateTime;
    }

    public Date getEmailVerificationCodeGenerateTime() {
        return emailVerificationCodeGenerateTime;
    }

    public void setEmailVerificationCodeGenerateTime(Date emailVerificationCodeGenerateTime) {
        this.emailVerificationCodeGenerateTime = emailVerificationCodeGenerateTime;
    }

    public String getIdenfityCardId() {
        return idenfityCardId;
    }

    public void setIdenfityCardId(String idenfityCardId) {
        this.idenfityCardId = idenfityCardId == null ? null : idenfityCardId.trim();
    }

    public String getInstitutionalId() {
        return institutionalId;
    }

    public void setInstitutionalId(String institutionalId) {
        this.institutionalId = institutionalId == null ? null : institutionalId.trim();
    }

    public String getLegalPersonal() {
        return legalPersonal;
    }

    public void setLegalPersonal(String legalPersonal) {
        this.legalPersonal = legalPersonal == null ? null : legalPersonal.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getRoletype() {
        return roletype;
    }

    public void setRoletype(Integer roletype) {
        this.roletype = roletype;
    }
}