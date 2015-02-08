package com.example.hibernate.dao;

/**
 * Created by Cannibal on 8.2.2015 г..
 */
public interface SampleDao<E> {
    public E create(E toBeSaved);

    public E rename(E toBeRenamed);

    public E update(E toBeUpdated);

    public E delete(E toBeDeleted);

}
