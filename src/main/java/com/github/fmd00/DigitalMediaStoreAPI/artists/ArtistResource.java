package com.github.fmd00.DigitalMediaStoreAPI.artists;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistResource {

    private ArtistRepository repository;

    public ArtistResource(ArtistRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Artist> artists(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{ArtistId}")
    public ResponseEntity<Artist> getOne(@PathVariable Long ArtistId) {
        Optional<Artist> optional = repository.findById(ArtistId);
        if (optional.isPresent()) return ResponseEntity.ok().body(optional.get());
        else return ResponseEntity.notFound().build();
    }

}
