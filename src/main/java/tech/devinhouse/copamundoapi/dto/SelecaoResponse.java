package tech.devinhouse.copamundoapi.dto;

import lombok.Data;

import javax.persistence.Id;

import java.time.LocalDateTime;


@Data
public class SelecaoResponse {

    private String sigla;

    private String nome;

    private String grupo;

    private LocalDateTime dataCadastro;

}
