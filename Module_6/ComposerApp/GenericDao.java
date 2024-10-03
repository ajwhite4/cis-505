/*
    Shelanskey, T. (2024). CIS Intermediate Java Programming. Bellevue University.
    Modified by A. White 2024
*/
package Module_6.ComposerApp;

import java.util.List;

// Generic Data Access Object (DAO) interface for basic Create, Read, Update, Delete (CRUD) operations.
public interface GenericDao<E, K> {
    // returns list of entities
    List<E> findAll();
    
    // finds entity by key
    E findBy(K key);
    
    // inserts new entity
    void insert(E entity);
} // End GenericDao
