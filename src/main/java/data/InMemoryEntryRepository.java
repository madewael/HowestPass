package data;

import domain.Entry;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryEntryRepository implements EntryRepository {

    private final Set<Entry> all = new HashSet<>();

    @Override
    public Collection<Entry> findAll() {
        return Collections.unmodifiableCollection(all);
    }

    @Override
    public Collection<Entry> findByUser(String user) {
        return all
                .stream()
                .filter(e -> e.getUser().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public Entry findByTitle(String title) {
        Optional<Entry> maybeEntry = all
                .stream()
                .filter(e -> e.getTitle().equals(title))
                .findAny();

        return maybeEntry.orElse(null);

    }

    @Override
    public void save(Entry e) {
        all.add(e);
    }

    @Override
    public void delete(Entry entity) {
        all.remove(entity);
    }
}
