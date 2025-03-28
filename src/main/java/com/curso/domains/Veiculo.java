package com.curso.domains;

import com.curso.domains.dtos.ProdutoDTO;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long idVeiculo;



    @NotBlank @NotBlank
    private String descricao;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataAquisicao = LocalDate.now();


    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorAquisicao;

    @NotBlank @NotBlank
    private String nomeProprietario;

    @NotBlank @NotBlank
    private String cpfProprietario;

    public Veiculo() {
        this.valorAquisicao= BigDecimal.ZERO;

    }

    public Veiculo(Long idVeiculo, String descricao, LocalDate dataAquisicao, BigDecimal valorAquisicao, String nomeProprietario, String cpfProprietario) {
        this.idVeiculo = idVeiculo;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.nomeProprietario = nomeProprietario;
        this.cpfProprietario = cpfProprietario;
    }




    public Veiculo( VeiculoDTO dto) {
        this.idVeiculo = obj.idVeiculo();
        this.descricao = obj.descricao;
        this.dataAquisicao = obj.dataAquisicao;
        this.valorAquisicao = obj.valorAquisicao;
        this.nomeProprietario = obj.nomeProprietario;
        this.cpfProprietario = obj.cpfProprietario;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public BigDecimal getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(BigDecimal valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(idVeiculo, veiculo.idVeiculo) && Objects.equals(descricao, veiculo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, descricao);
    }
}
