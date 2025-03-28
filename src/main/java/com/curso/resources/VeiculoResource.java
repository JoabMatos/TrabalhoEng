package com.curso.resources;

import com.curso.domains.User;
import com.curso.domains.dtos.UserDTO;
import com.curso.domains.dtos.VeiculoDTO;
import com.curso.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoResource {





        @Autowired
        private VeiculoService veiculosService;

        @GetMapping
        public ResponseEntity<List<VeiculoDTO>> findAll() {
            return ResponseEntity.ok(veiculosService.findAll());
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
            User obj = this.veiculosService.findbyId(id);
            return ResponseEntity.ok().body(new VeiculoDTO(obj));
        }

        @GetMapping(value = "/cpf/{cpf}")
        public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf) {
            User obj = this.veiculosService.findbyCpf(cpf);
            return ResponseEntity.ok().body(new VeiculoDTO(obj));
        }

        @GetMapping(value = "/email/{email}")
        public ResponseEntity<VeiculoDTO> findByEmail(@PathVariable String email) {
            User obj = this.veiculosService.findbyEmail(email);
            return ResponseEntity.ok().body(new VeiculoDTO(obj));
        }
        @PostMapping
        public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO objDto) {
            User newObj = veiculosService.create(objDto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @Valid @RequestBody VeiculoDTO objDto) {
            User Obj = veiculosService.update(id,objDto);
            return ResponseEntity.ok().body(new VeiculoDTO(Obj));
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<VeiculoDTO> delete(@PathVariable Long id) {
            veiculosService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }


}
