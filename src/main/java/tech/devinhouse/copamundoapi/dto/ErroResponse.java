package tech.devinhouse.copamundoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroResponse {

    private String messagem;

    private Map<String, String> detalhes;

    public ErroResponse(String mensagem){
        this.messagem=mensagem;
    }

}
