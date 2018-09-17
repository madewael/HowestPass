package data;

import domain.Entry;

import java.util.Collection;

public interface EntryRepository {

    Collection<Entry> findAll();
    Collection<Entry> findByUser(String user);
    Entry findByTitle(String title);

    void save(Entry e);
    void delete(Entry entity);

}
