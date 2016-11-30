/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.controller;

import br.com.cvlattes.controller.exception.ItemNotFoundException;
import br.com.cvlattes.persistence.Persistence;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author marco
 */
public class Controller<T> {

    Persistence persistence;

    public Controller(Persistence persistence) {
        this.persistence = persistence;
    }

    public Collection<T> getItems() {
        
        return persistence.list();
    }

    /**
     * Salva um objeto do tipo T no disco
     *
     * @param t
     */
    public void add(T t) {
        persistence.create(t);
    }

    /**
     * Remove um objeto com a mesma credencial
     *
     * @param t
     */
    public void remove(T t) throws ItemNotFoundException {
        persistence.delete(t);
    }

    public void update(T t) throws ItemNotFoundException {
        persistence.update(t);
    }

    public T get(T t) throws ItemNotFoundException {
        return (T) persistence.retrieve(t);

    }
}
