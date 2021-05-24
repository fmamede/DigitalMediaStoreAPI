package com.github.fmd00.DigitalMediaStoreAPI.artists;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Artist\"")
public class Artist {
/*Column  |          Type          | Collation | Nullable | Default
----------+------------------------+-----------+----------+---------
 ArtistId | integer                |           | not null |
 Name     | character varying(120) |           |          |         */

    @Id
    @Column(name = "\"ArtistId\"")
    private Long id;

    @Column(name = "\"Name\"")
    private String name;

    public Artist() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
