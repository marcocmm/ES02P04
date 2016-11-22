/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.persistence;

import br.com.cvlattes.controller.exception.ItemNotFoundException;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author marco
 */
public class SerializePersistence<T> implements Persistence<T>{

    private List<T> items;

    public SerializePersistence() {
        List<T> items;
        try {
            items = deserialize();
        } catch (IOException | ClassNotFoundException ex) {
            items = new ArrayList<>();
            try {
                serialize(items);
            } catch (IOException ex1) {
                Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        this.items = items;
    }

    private synchronized void serialize(List<T> items) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/dados/Documents/BCC/ES2/ES02P04/CVLattes/database");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(items);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    private synchronized List<T> deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("/dados/Documents/BCC/ES2/ES02P04/CVLattes/database");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<T> items = (List<T>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return items;
    }

    @Override
    public synchronized List<T> list() {
        try {
            items = deserialize();
        } catch (IOException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    @Override
    public synchronized void create(T t) {
        try {
            items = deserialize();
            items.add(t);
            serialize(items);
        } catch (IOException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public synchronized T retrieve(T t) throws ItemNotFoundException {
        try {
            items = deserialize();
            for (T item : items) {
                if (item.equals(t)) {
                    return item;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new ItemNotFoundException("Item não encontrado");
    }

    @Override
    public synchronized void update(T t) throws ItemNotFoundException {
        try {
            items = deserialize();
            boolean remove = this.items.remove(t);
            if (!remove) {
                throw new ItemNotFoundException("Item não encontrado");
            }
            this.items.add(t);
            serialize(items);
        } catch (IOException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public synchronized void delete(T t) throws ItemNotFoundException {
        try {
            items = deserialize();
            boolean remove = this.items.remove(t);
            if (!remove) {
                throw new ItemNotFoundException("Item não encontrado");
            }
            serialize(items);
        } catch (IOException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializePersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
