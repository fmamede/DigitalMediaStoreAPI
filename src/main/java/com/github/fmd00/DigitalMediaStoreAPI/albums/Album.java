package com.github.fmd00.DigitalMediaStoreAPI.albums;

import com.github.fmd00.DigitalMediaStoreAPI.artists.Artist;

import javax.persistence.*;

@Entity
@Table(name = "\"Album\"")
public class Album {
/*Column  |          Type          | Collation | Nullable | Default
----------+------------------------+-----------+----------+---------
 AlbumId  | integer                |           | not null |
 Title    | character varying(160) |           | not null |
 ArtistId | integer                |           | not null |         */

    @Id
    @Column(name = "\"AlbumId\"")
    private Long id;

    @Column(name = "\"Title\"")
    private String title;

    @ManyToOne
    @JoinColumn(name = "\"ArtistId\"", referencedColumnName = "\"ArtistId\"")
    private Artist artist;


    public Album() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public Artist getArtist() {
        return artist;
    }
}
