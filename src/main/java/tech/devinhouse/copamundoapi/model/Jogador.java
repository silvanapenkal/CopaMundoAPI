package tech.devinhouse.copamundoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "jogadores")
public class Jogador {

    @Id
    private Integer id;

    @Enumerated
    private Posicao posicao;







}
