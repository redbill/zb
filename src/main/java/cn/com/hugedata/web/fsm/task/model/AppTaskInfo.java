package cn.com.hugedata.web.fsm.task.model;

public class AppTaskInfo {
    private Integer id;

    private String taskName;

    private Integer taskType;

    private Integer appId;

    private String creatTime;

    private String startTime;

    private String endTime;

    private Integer monitoringFrequency;

    private Integer userId;

    private Integer smsSum;

    private String status;

    private String cancelTime;

    private String imsptaskid;

    private String taskNodeType;

    private Long orderId;

    private Integer testnum;

    private String realstarttime;

    private String realendtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime == null ? null : creatTime.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getMonitoringFrequency() {
        return monitoringFrequency;
    }

    public void setMonitoringFrequency(Integer monitoringFrequency) {
        this.monitoringFrequency = monitoringFrequency;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSmsSum() {
        return smsSum;
    }

    public void setSmsSum(Integer smsSum) {
        this.smsSum = smsSum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime == null ? null : cancelTime.trim();
    }

    public String getImsptaskid() {
        return imsptaskid;
    }

    public void setImsptaskid(String imsptaskid) {
        this.imsptaskid = imsptaskid == null ? null : imsptaskid.trim();
    }

    public String getTaskNodeType() {
        return taskNodeType;
    }

    public void setTaskNodeType(String taskNodeType) {
        this.taskNodeType = taskNodeType == null ? null : taskNodeType.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getTestnum() {
        return testnum;
    }

    public void setTestnum(Integer testnum) {
        this.testnum = testnum;
    }

    public String getRealstarttime() {
        return realstarttime;
    }

    public void setRealstarttime(String realstarttime) {
        this.realstarttime = realstarttime == null ? null : realstarttime.trim();
    }

    public String getRealendtime() {
        return realendtime;
    }

    public void setRealendtime(String realendtime) {
        this.realendtime = realendtime == null ? null : realendtime.trim();
    }
}