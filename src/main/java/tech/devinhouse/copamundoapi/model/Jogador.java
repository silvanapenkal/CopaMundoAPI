package tech.devinhouse.copamundoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "JOGADORES")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_JOGADOR")
    private Integer id;


    private String nome;

    @Enumerated (EnumType.STRING)
    private Posicao posicao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="sigla", referencedColumnName = "sigla")
    private Selecao selecao;

}
