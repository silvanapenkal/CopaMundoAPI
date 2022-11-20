package tech.devinhouse.copamundoapi.dto;

import lombok.Data;
import tech.devinhouse.copamundoapi.model.Posicao;
import tech.devinhouse.copamundoapi.model.Selecao;

import javax.persistence.*;

@Data
public class JogadorResponse {

    private Integer id;

    private String nome;

    private Posicao posicao;

}
