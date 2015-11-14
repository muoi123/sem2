/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.Date;
import model.DataProcess;

/**
 *
 * @author Windows 10
 */
public class User {

    private String uId;
    private String uUser;
    private String uPass;
    private String uName;
    private int uGender;
    private String uAddress;
    private Date uDateOfBirth;
    private String uPhone;
    private String uAvatar;
    private int uRole;

    public User() {
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuUser() {
        return uUser;
    }

    public void setuUser(String uUser) {
        this.uUser = uUser;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getuGender() {
        return uGender;
    }

    public void setuGender(int uGender) {
        this.uGender = uGender;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public Date getuDateOfBirth() {
        return uDateOfBirth;
    }

    public void setuDateOfBirth(Date uDateOfBirth) {
        this.uDateOfBirth = uDateOfBirth;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuAvatar() {
        return uAvatar;
    }

    public void setuAvatar(String uAvatar) {
        this.uAvatar = uAvatar;
    }

    public int getuRole() {
        return uRole;
    }

    public void setuRole(int uRole) {
        this.uRole = uRole;
    }

    @Override
    public String toString() {
        return uId + ", " + uUser + ", " + uPass + ", " + uName + ", " + uGender + ", "
                + uAddress + ", " + uDateOfBirth + ", " + uPhone + ", " + uAvatar + ", " + uRole;
    }

    public User getObject(Object[] arrObj) {
        User u = new User();
        u.setuId((String) arrObj[0]);
        u.setuUser((String) arrObj[1]);
        u.setuPass((String) arrObj[2]);
        u.setuName((String) arrObj[3]);
        u.setuGender((Integer) arrObj[4]);
        u.setuAddress((String) arrObj[5]);
        u.setuDateOfBirth((Date) arrObj[6]);
        u.setuPhone((String) arrObj[7]);
        u.setuAvatar((String) arrObj[8]);
        u.setuRole((Integer) arrObj[9]);
        return u;
    }

    public ArrayList<User> getListObject(String sql) {
        ArrayList<User> listU = new ArrayList<User>();
        for (Object[] arrObj : new DataProcess().getListObject(sql)) {
            User u = getObject(arrObj);
            listU.add(u);
        }
        return listU;
    }

    public ArrayList<User> getListUser() {
        return getListObject("SELECT * FROM tblUser");
    }

    public boolean checkLogin(String user, String pass) {
        String sql = "SELECT * FROM tblUser WHERE uUser = '" + user + "' AND uPass = '" + pass + "'";
        return new DataProcess().Check(sql);
    }

    public boolean checkManager(String user) {
        String sql = "SELECT * FROM tblUser WHERE uUser = '" + user + "' AND uRole = 2";
        return new DataProcess().Check(sql);
    }

    public User getProfileByUser(String user) {
        String sql = "SELECT * FROM tblUser WHERE uUser = '" + user + "'";
        User u = getObject(new DataProcess().getObject(sql));
        return u;
    }

    public void addUser(User u) {

    }

    public static void main(String[] args) {
        User u = new User();
        System.out.println("+" + u.checkLogin("admin", "123456"));
    }
}
