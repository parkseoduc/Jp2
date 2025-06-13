package dao;

import java.util.ArrayList;


public interface RepositoryDAO <E,K>{
    ArrayList<E> all();
    E findById(K id);
    Boolean create(E data);
    Boolean update(E data);
    Boolean delete(K id);
}
