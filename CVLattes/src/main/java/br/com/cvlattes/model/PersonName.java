/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class PersonName extends Name implements Serializable {

    private String last;
    private String middle;
    private String first;

    public PersonName(String first, String middle, String last) {
        this.last = last;
        this.middle = middle;
        this.first = first;
    }

    public PersonName(String name) {
        String[] n = name.split(" ");
        this.first = n[0];
        if (n.length == 1) {
            this.middle = "";
            this.last = "";
        } else if (n.length == 2) {
            this.middle = n[1];
            this.last = "";
        } else {
            this.middle = n[1];
            this.last = n[2];
        }
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
