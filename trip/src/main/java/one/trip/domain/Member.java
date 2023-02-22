package one.trip.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Member {
    private Long idx;
    private String id;
    private String pw;
    private Timestamp accessDate;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Timestamp getAccessDate() {
        return accessDate;
    }

    public Object setAccessDate() {
        this.accessDate = accessDate;
        return Timestamp.valueOf(LocalDateTime.now());
    }
}
