package com.github.fmd00.DigitalMediaStoreAPI.mediatypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"MediaType\"")
public class MediaType {
/* Column    |          Type          | Collation | Nullable | Default
-------------+------------------------+-----------+----------+---------
 MediaTypeId | integer                |           | not null |
 Name        | character varying(120) |           |          |         */

    @Id
    @Column(name = "\"MediaTypeId\"")
    private Long id;

    @Column(name = "\"Name\"")
    private String name;

    public MediaType() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
