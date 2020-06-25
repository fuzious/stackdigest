package com.stackDigest.stackDigest.beans.database;

import javax.persistence.*;

@Entity
@Table(indexes =
        {
                @Index(columnList = "id,seen",name = "user_id_seen")
        })
public class UserD_seen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkey;

    @Column(columnDefinition = "VARCHAR(64)")
    private String id;

    @Column
    private int seen;

    public UserD_seen() {}

    public UserD_seen(String id, int seen) {
        this.id = id;
        this.seen = seen;
    }

    public int getPkey() {
        return pkey;
    }

    public void setPkey(int pkey) {
        this.pkey = pkey;
    }
}
