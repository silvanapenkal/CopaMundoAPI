package tech.devinhouse.copamundoapi.dto;

import lombok.Data;
import tech.devinhouse.copamundoapi.model.Posicao;

@Data
public class JogadorResponse {

    private Integer id;

    private String nome;

    private Posicao posicao;

}
