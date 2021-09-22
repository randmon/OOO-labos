package domain;

public record User(String username) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof User u) {
            return (username.equals(u.username));
        } else return false;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    @Override
    public String toString() {
        return username;
    }
}
