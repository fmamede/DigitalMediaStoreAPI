package com.github.fmd00.DigitalMediaStoreAPI.albums;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumResource {

    private AlbumRepository repository;

    public AlbumResource(AlbumRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Album> albums(Pageable page)
    {
        return repository.findAll(page);
    }

    @GetMapping("/id/{AlbumId}")
    public ResponseEntity<Album> getOne(@PathVariable Long AlbumId) {
        Optional<Album> optional = repository.findById(AlbumId);
        if (optional.isPresent()) return ResponseEntity.ok().body(optional.get());
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/artist/{ArtistId}")
    public ResponseEntity<List<Album>> getByArtistId(@PathVariable Long ArtistId)
    {
        Optional<List<Album>> optional = Optional.ofNullable(repository.findByArtistId(ArtistId));
        if (optional.isPresent()) return ResponseEntity.ok().body(optional.get());
        else return ResponseEntity.notFound().build();
    }
}
