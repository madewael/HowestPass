package data;

import domain.Entry;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InMemoryEntryRepositoryTest {

    private EntryRepository repo;

    @Before
    public void initRepository() {
        repo = new InMemoryEntryRepository();
    }


    @Test
    public void createEmptyRepository() {
        assertEquals(0, repo.findAll().size());
    }

    @Test
    public void findAll() {
        Entry e1 = new Entry("title1","user1","p1", "url1");
        repo.save(e1);
        assertEquals(1, repo.findAll().size());

        Entry e2 = new Entry("title2","user2","p2", "url2");
        repo.save(e2);
        assertEquals(2, repo.findAll().size());

        Entry e3 = new Entry("title3","user3","p3", "url3");
        repo.save(e3);
        assertEquals(3, repo.findAll().size());

        assertTrue(repo.findAll().containsAll(Arrays.asList(e1, e2, e3)));
    }

    @Test
    public void findByUser() {
        Entry e1 = new Entry("title1","user","p1", "url1");
        repo.save(e1);

        Entry e2 = new Entry("title2","user2","p2", "url2");
        repo.save(e2);

        Entry e3 = new Entry("title3","user","p3", "url3");
        repo.save(e3);

        assertTrue(repo.findByUser("user").containsAll(Arrays.asList(e1, e3)));
    }

    @Test
    public void findByTitle() {
        Entry e1 = new Entry("title1","user","p1", "url1");
        repo.save(e1);

        Entry e2 = new Entry("title2","user2","p2", "url2");
        repo.save(e2);

        Entry e3 = new Entry("title3","user","p3", "url3");
        repo.save(e3);

        assertEquals(e2, repo.findByTitle("title2"));
        assertNull(repo.findByTitle("azerty"));
    }

    @Test
    public void save() {
        Entry e1 = new Entry("title1","user1","p1", "url1");
        repo.save(e1);
        assertEquals(e1, repo.findByTitle("title1"));
    }

    @Test
    public void delete() {
        Entry e1 = new Entry("title1","user1","p1", "url1");
        repo.save(e1);
        assertEquals(1, repo.findAll().size());
        assertEquals(e1, repo.findByTitle("title1"));
        repo.delete(e1);
        assertNull(repo.findByTitle("title1"));
        assertEquals(0, repo.findAll().size());
    }
}