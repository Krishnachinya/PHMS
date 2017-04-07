package com.krishnchinya.personalhealthmonitoringsystem.activity;

/**
 * Created by KrishnChinya on 2/12/17.
 */

public class DB_Setter_Getter {
    private String fName;
    private String lName;
    private String dob;
    private String gender;
    private String mailID;
    private String weight;
    private String height;
    private String phone;
    private String password;

    private String user;
    private String mailId;
    private String medicinename;
    private String start_date;
    private String end_date;
    private String wkofd;
    private String remainder;
    private String medicineType;
    private String doctorName;
    private String time;

    private String spbloodtype;
    private String spcholesterol;
    private String spbp;
    private String haemoglobin;
    private String glucose;
    private String heartrate;
    private String bmi;
    private String bodytemp;

    //for Vital Signs
    public DB_Setter_Getter(String mailId, String spbloodtype,String spcholesterol,String spbp, String haemoglobin, String glucose,String heartrate,String bmi,String bodytemp,int dummy)
    {
        this.mailId = mailId;
        this.spbloodtype=spbloodtype;
        this.spcholesterol=spcholesterol;
        this.spbp=spbp;
        this.haemoglobin=haemoglobin;
        this.glucose=glucose;
        this.heartrate=heartrate;
        this.bmi = bmi;
        this.bodytemp = bodytemp;
    }

    //for medication screen
    public DB_Setter_Getter(String user, String mailId, String medicinename, String start_date, String end_date, String wkofd, String remainder,
                            String medicineType, String doctorName,String time) {
        this.user = user;
        this.mailId = mailId;
        this.medicinename = medicinename;
        this.start_date = start_date;
        this.end_date = end_date;
        this.wkofd = wkofd;
        this.remainder = remainder;
        this.medicineType = medicineType;
        this.doctorName = doctorName;
        this.time = time;
    }




    public DB_Setter_Getter(String mailID,String password)
    {
        this.mailID = mailID;
        this.password = password;
    }

    public DB_Setter_Getter(String fName, String lName, String dob,
                            String gender, String weight,
                            String height, String phone,String mailID ) {
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.phone = phone;
        this.mailID = mailID;
    }

    public DB_Setter_Getter(String fName, String lName, String dob,
                                 String gender, String mailID, String weight,
                                 String height, String phone ,String password) {
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.gender = gender;
        this.mailID = mailID;
        this.weight = weight;
        this.height = height;
        this.phone = phone;
        this.password = password;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getdob() {
        return dob;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getWkofd() {
        return wkofd;
    }

    public void setWkofd(String wkofd) {
        this.wkofd = wkofd;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSpbloodtype() {
        return spbloodtype;
    }

    public void setSpbloodtype(String spbloodtype) {
        this.spbloodtype = spbloodtype;
    }

    public String getSpcholesterol() {
        return spcholesterol;
    }

    public void setSpcholesterol(String spcholesterol) {
        this.spcholesterol = spcholesterol;
    }

    public String getSpbp() {
        return spbp;
    }

    public void setSpbp(String spbp) {
        this.spbp = spbp;
    }

    public String getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(String haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getBodytemp() {
        return bodytemp;
    }

    public void setBodytemp(String bodytemp) {
        this.bodytemp = bodytemp;
    }
}
