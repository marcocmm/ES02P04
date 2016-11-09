/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marco
 */
public class PersonName extends Name {

    private String last;
    private String middle;
    private String first;

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

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
