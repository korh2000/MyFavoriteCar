package com.autorost.myfavoritecar.entity;


import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * автомобиль
 */
public class Car {
    private String brand;          //    марка
    private String model;          //    модель
    private int year;              //    год
    private String vin;            //vin код
    // private String govNumber;      //  гос.номер
    private int mileageStart;  // начальный пробег значение+дата
    private Date dateStart;// дата начального пробега
    private String mileageUnit;  // единица измерения пробега км, милли
    // 1 mile = 1,609 км  1 км = 0.6 mile
    //  private Currency currency;  // валюта учета
    private String currency;
    private String fuel;
    //   private String photoCar;          //   фото автомобиля


    public Car(String brand, String model, int year, String vin, int mileageStart, Date dateStart, String mileageUnit, String currency, String fuel) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.mileageStart = mileageStart;
        this.dateStart = dateStart;
        this.mileageUnit = mileageUnit;
        this.currency = currency;
        this.fuel = fuel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getMileageStart() {
        return mileageStart;
    }

    public void setMileageStart(int mileageStart) {
        this.mileageStart = mileageStart;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getMileageUnit() {
        return mileageUnit;
    }

    public void setMileageUnit(String mileageUnit) {
        this.mileageUnit = mileageUnit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public class PartsOfCar {
    }

}
