/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.persistence;

import br.com.cvlattes.controller.exception.ItemNotFoundException;
import java.util.List;

/**
 *
 * @author marco
 * @param <T>
 */
public interface Persistence<T>{

    
    public List<T> list();

    public void create(T t);

    public T retrieve(T t) throws ItemNotFoundException;

    public void update(T t) throws ItemNotFoundException;

    public void delete(T t) throws ItemNotFoundException;

}
