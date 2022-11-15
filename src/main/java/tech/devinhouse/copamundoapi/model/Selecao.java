package tech.devinhouse.copamundoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name="selecoes")
public class Selecao {

    @Id
    private String sigla;

    private String nome;

    private String grupo;

    private LocalDateTime dataCadastro;

    private List<Jogador> jogadores;

}
