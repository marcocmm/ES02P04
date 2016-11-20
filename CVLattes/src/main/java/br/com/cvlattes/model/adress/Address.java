/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model.adress;

import java.util.Date;

/**
 *
 * @author marco
 */
public class Address {

    private Date initialDate;
    private Date finalDate;
    private AddressType type;
    private City city;
    private StreetType streetType;
    private String street;
    private int number;
    private int cep;
    private String complemento;

    public Address(Date initialDate, Date finalDate, AddressType type, City city, StreetType streetType, String street, int number, int cep, String complemento) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.type = type;
        this.city = city;
        this.streetType = streetType;
        this.street = street;
        this.number = number;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Address(Date initialDate, Date finalDate, AddressType type, City city, StreetType streetType, String street, String number, String cep, String complemento) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.type = type;
        this.city = city;
        this.streetType = streetType;
        this.street = street;
        int n = Integer.parseInt(number);
        this.number = n;
        int c = Integer.parseInt(cep);
        this.cep = c;
        this.complemento = complemento;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public AddressType getType() {
        return type;
    }

    public City getCity() {
        return city;
    }

    public void setStreetType(StreetType streetType) {
        this.streetType = streetType;
    }

    public StreetType getStreetType() {
        return streetType;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setNumber(byte number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getCep() {
        return cep;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

}
