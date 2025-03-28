package com.curso.services;

import com.curso.domains.GrupoProduto;
import com.curso.domains.Produto;
import com.curso.domains.Veiculo;
import com.curso.domains.dtos.ProdutoDTO;
import com.curso.domains.dtos.VeiculoDTO;
import com.curso.repositories.GrupoProdutoRepository;
import com.curso.repositories.ProdutoRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private ProdutoRepository veiculosRepo;


    public List<VeiculoDTO> findAll() {
        return veiculoRepo.findAll().stream().
                map(obj -> new VeiculoDTO(obj)).
                collect(Collectors.toList());
    }

    public Veiculo findById(Long id) {
        Optional<Veiculo> obj = veiculosRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veiculo não encontrado! Id: " + id));
    }




    public Veiculo create(VeiculoDTO dto){
        dto.setIdVeiculo(null);
        validaVeiculo(dto);
        veiculo obj=new Veiculo(dto);
        return veiculoRepo.save(obj);
    }


    }

    public Veiculo update(Long id, VeiculoDTO objDto) {
        objDto.setIdVeiculo(id);
        Veiculo oldObj=findById(id);
        validaVeiculo(objDto);
        oldObj=new Veiculo(objDto);
        return veiculoRepo.save(oldObj);
    }
    public void delete(Long id) {
        Veiculo obj=findById(id);
        veiculoRepo.delete(obj);
    }
}
