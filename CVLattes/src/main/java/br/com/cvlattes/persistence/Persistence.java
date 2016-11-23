/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.persistence;

import br.com.cvlattes.controller.exception.ItemNotFoundException;
import java.util.Collection;

/**
 *
 * @author marco
 * @param <T>
 */
public interface Persistence<T> {

    /* Obtem todos os itens existentes na base. Metodo com lock exclusivo para a
     * mesma instancia.
     *
     * @return
     */
    public Collection<T> list();

    /**
     * Insere um item na base.
     *
     * @param t
     */
    public void create(T t);

    /**
     * Obtem um item.
     *
     * @param t Item a ser buscado. A chave primaria devera constar no metodo
     * equals.
     * @return Retorna o item.
     * @throws ItemNotFoundException Caso o item nao seja encontrado, propaga
     * exceçao.
     */
    public T retrieve(T t) throws ItemNotFoundException;

    /**
     * Atualiza um item buscando-o pela chave primaria. A chave primaria devera
     * ser descrita no metodo equals de cada classe.
     *
     * @param t
     * @throws ItemNotFoundException
     */
    public void update(T t) throws ItemNotFoundException;

    /**
     * Remove um objeto.
     *
     * @param t
     * @throws ItemNotFoundException
     */
    public void delete(T t) throws ItemNotFoundException;
}
