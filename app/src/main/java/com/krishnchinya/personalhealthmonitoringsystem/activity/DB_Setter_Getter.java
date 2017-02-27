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


}
