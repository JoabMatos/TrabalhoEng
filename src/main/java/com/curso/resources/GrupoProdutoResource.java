package com.curso.resources;


import com.curso.domains.GrupoProduto;
import com.curso.domains.Produto;
import com.curso.domains.dtos.GrupoProdutoDTO;
import com.curso.domains.dtos.ProdutoDTO;
import com.curso.services.GrupoProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/grupoproduto")
public class GrupoProdutoResource {

    @Autowired
    private GrupoProdutoService grupoProdutoService;

    @GetMapping
    public ResponseEntity<List<GrupoProdutoDTO>>findAll(){
        return ResponseEntity.ok().body(grupoProdutoService.findAll());
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<GrupoProdutoDTO> findById(@PathVariable Integer id) {
        GrupoProduto obj = this.grupoProdutoService.findById(id);
        return ResponseEntity.ok().body(new GrupoProdutoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<GrupoProdutoDTO> create(@Valid @RequestBody GrupoProdutoDTO dto) {
        GrupoProduto grupoProduto =  grupoProdutoService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(grupoProduto.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value="/{id}")
    public ResponseEntity<GrupoProdutoDTO> update(@PathVariable Integer id, @Valid @RequestBody GrupoProdutoDTO objDto) {
        GrupoProduto obj = grupoProdutoService.update(id, objDto);
        return ResponseEntity.ok().body(new GrupoProdutoDTO(obj));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GrupoProdutoDTO> delete(@PathVariable Integer id) {
        grupoProdutoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
