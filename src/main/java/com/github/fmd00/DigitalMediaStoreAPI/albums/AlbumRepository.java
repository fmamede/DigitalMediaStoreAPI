package com.github.fmd00.DigitalMediaStoreAPI.albums;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByArtistId(Long ArtistId);
}
