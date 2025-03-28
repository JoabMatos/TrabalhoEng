package com.curso.domains.dtos;

import com.curso.domains.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VeiculoDTO {


    private Long idVeiculo;



    @NotNull(message = "O campo descrição  não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataAquisicao = LocalDate.now();


    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorAquisicao;

    @NotNull(message = "O campo nome Proprietario não pode ser nulo")
    @NotBlank(message = "O campo nome Proprietario não pode estar vazio")
    private String nomeProprietario;

    @NotNull(message = "O campo CPF não pode ser nulo")
    @CPF
    private String cpfProprietario;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Veiculo veiculo) {
        this.idVeiculo = veiculo.getIdVeiculo();
        this.descricao = veiculo.getDescricao();
        this.dataAquisicao = veiculo.getDataAquisicao();
        this.valorAquisicao = veiculo.getValorAquisicao();
        this.nomeProprietario = veiculo.getNomeProprietario();
        this.cpfProprietario = veiculo.getCpfProprietario();
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public  @NotNull(message = "O campo codigo de barra não pode ser nulo")@NotBlank(message = "O campo codigo de barra não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao   (@NotNull(message = "O campo codigo de barra não pode ser nulo")@NotBlank(message = "O campo codigo de barra não pode estar vazio") String codigoBarra) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public  @NotNull (message = "O campo valorAquisição não pode ser nulo")@Digits(integer = 15,fraction = 3)  BigDecimal getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao( @NotNull (message = "O campo valorUnitario não pode ser nulo")@Digits(integer = 15,fraction = 3) BigDecimal valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull(message = "O campo nâo pode ser nulo")@NotBlank(message = "O campo não pode estar vazio") String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario (@NotNull(message = "O campo nâo pode ser nulo")@NotBlank(message = "O campo não pode estar vazio")String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }
}
