package com.github.fmd00.DigitalMediaStoreAPI.tracks;

import com.github.fmd00.DigitalMediaStoreAPI.albums.Album;
import com.github.fmd00.DigitalMediaStoreAPI.mediatypes.MediaType;

import javax.persistence.*;

@Entity
@Table(name = "\"Track\"")
public class Track {
/*  Column    |          Type          | Collation | Nullable | Default
--------------+------------------------+-----------+----------+---------
 TrackId      | integer                |           | not null |
 Name         | character varying(200) |           | not null |
 AlbumId      | integer                |           |          |
 MediaTypeId  | integer                |           | not null |
 GenreId      | integer                |           |          |
 Composer     | character varying(220) |           |          |
 Milliseconds | integer                |           | not null |
 Bytes        | integer                |           |          |
 UnitPrice    | numeric(10,2)          |           | not null |         */

    @Id
    @Column(name = "\"TrackId\"")
    private Long id;

    @Column(name = "\"Name\"")
    private String name;

    @ManyToOne
    @JoinColumn(name = "\"AlbumId\"", referencedColumnName = "\"AlbumId\"")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "\"MediaTypeId\"", referencedColumnName = "\"MediaTypeId\"")
    private MediaType mediaType;

    public Track() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Album getAlbum()
    {
        return album;
    }

    public MediaType getMediaType() {
        return mediaType;
    }
}
