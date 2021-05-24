package com.github.fmd00.DigitalMediaStoreAPI.mediatypes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/mediatypes")
public class MediaTypeResource {

    private MediaTypeRepository repository;

    public MediaTypeResource(MediaTypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<MediaType> mediaTypes(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{MediaTypeId}")
    public ResponseEntity<MediaType> getOne(@PathVariable Long MediaTypeId) {
        Optional<MediaType> optional = repository.findById(MediaTypeId);
        if (optional.isPresent()) return ResponseEntity.ok().body(optional.get());
        else return ResponseEntity.notFound().build();
    }
}
