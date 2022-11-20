package tech.devinhouse.copamundoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name="SELECOES")
public class Selecao {

    @Id
    private String sigla;

    private String nome;

    private String grupo;

    private LocalDateTime dataCadastro;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "selecao")
    private List<Jogador> jogadores;

}
