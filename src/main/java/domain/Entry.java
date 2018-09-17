package domain;

public class Entry {


    private final String title, user, password, url;

    public Entry(String title, String user, String password, String url) {
        this.title = title;
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        return title.equals(entry.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
