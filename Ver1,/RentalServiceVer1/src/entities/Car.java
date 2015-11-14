/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import model.DataProcess;

/**
 *
 * @author Windows 10
 */
public class Car {

    private String cId;
    private String cName;
    private String cType;
    private String cBrand;
    private int cSeat;
    private String cImage;
    private float cRentCost;
    private int cStatus;
    private String uId;

    public Car() {
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getcBrand() {
        return cBrand;
    }

    public void setcBrand(String cBrand) {
        this.cBrand = cBrand;
    }

    public int getcSeat() {
        return cSeat;
    }

    public void setcSeat(int cSeat) {
        this.cSeat = cSeat;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }

    public float getcRentCost() {
        return cRentCost;
    }

    public void setcRentCost(float cRentCost) {
        this.cRentCost = cRentCost;
    }

    public int getcStatus() {
        return cStatus;
    }

    public void setcStatus(int cStatus) {
        this.cStatus = cStatus;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return cId + ", " + cName + ", " + cType + ", " + cBrand + ", " + cSeat + ", "
                + cImage + ", " + cRentCost + ", " + cStatus + ", " + uId;
    }

    public Car getObject(Object[] arrObj) {
        Car c = new Car();
        c.setcId((String) arrObj[0]);
        c.setcName((String) arrObj[1]);
        c.setcType((String) arrObj[2]);
        c.setcBrand((String) arrObj[3]);
        c.setcSeat((Integer) arrObj[4]);
        c.setcImage((String) arrObj[5]);
        c.setcRentCost((Float) arrObj[6]);
        c.setcStatus((Integer) arrObj[7]);
        c.setuId((String) arrObj[8]);
        return c;
    }

    public ArrayList<Car> getListObject(String sql) {
        ArrayList<Car> listC = new ArrayList<Car>();
        for (Object[] arrObj : new DataProcess().getListObject(sql)) {
            listC.add(getObject(arrObj));
        }
        return listC;
    }

    public ArrayList<Car> getListCar() {
        return getListObject("SELECT * FROM tblCar");
    }

    public Car getDetailCar(String carId) {
        return getObject(new DataProcess().getObject("SELECT * FROM tblCar WHERE cId = '" + carId + "'"));
    }

    public static void main(String[] args) {
        
    }
}
