/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.controller;

import br.com.cvlattes.model.Loggable;
import br.com.cvlattes.persistence.Persistence;

/**
 *
 * @author marco
 */
public class LoggableController extends Controller<Loggable>{
    
    public LoggableController(Persistence<Loggable> persistence) {
        super(persistence);
    }
    
}
