/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.controller;

import br.com.cvlattes.controller.exception.ItemNotFoundException;
import br.com.cvlattes.model.Credential;
import br.com.cvlattes.model.Loggable;
import br.com.cvlattes.persistence.LoggablePersistence;

/**
 *
 * @author marco
 */
public class LoggableController extends Controller<Loggable> {

    private Loggable loggable;

    public LoggableController(LoggablePersistence persistence) {
        super(persistence);
    }

    public Loggable login(Credential credential) throws ItemNotFoundException {
        loggable = new Loggable(credential) {
        };
        return (Loggable) get(loggable);
    }

}

/**
 *
 * @param persistence
 */
