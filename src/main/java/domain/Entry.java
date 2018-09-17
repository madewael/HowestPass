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
}
