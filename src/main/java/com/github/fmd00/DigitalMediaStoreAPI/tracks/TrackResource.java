package com.github.fmd00.DigitalMediaStoreAPI.tracks;

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
@RequestMapping("/tracks")
public class TrackResource {

    private TrackRepository repository;

    public TrackResource(TrackRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Track> tracks(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/id/{TrackId}")
    public ResponseEntity<Track> getOne(@PathVariable Long TrackId) {
        Optional<Track> optional = repository.findById(TrackId);
        if (optional.isPresent()) return ResponseEntity.ok().body(optional.get());
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/album/{AlbumId}")
    public ResponseEntity<List<Track>> findByAlbumId(@PathVariable Long AlbumId) {
        Optional<List<Track>> optional = Optional.ofNullable(repository.findByAlbumId(AlbumId));
        if (optional.isPresent()) return ResponseEntity.ok().body(optional.get());
        else return ResponseEntity.notFound().build();
    }

}
