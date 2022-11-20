package tech.devinhouse.copamundoapi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.copamundoapi.dto.SelecaoResponse;
import tech.devinhouse.copamundoapi.exception.RegistroExistenteException;
import tech.devinhouse.copamundoapi.exception.RegistroNaoEncontradoException;
import tech.devinhouse.copamundoapi.model.Selecao;
import tech.devinhouse.copamundoapi.repository.SelecaoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SelecaoService {

    private SelecaoRepository repo;


    public Selecao criar(Selecao selecao) {

        boolean existe = repo.existsById(selecao.getSigla());
        if (existe)
            throw new RegistroExistenteException(Selecao.class.getSimpleName(), selecao.getSigla());
        selecao.setDataCadastro(LocalDateTime.now());
        selecao = repo.save(selecao);
        return selecao;
    }

    public List<Selecao> consultar(){
        List<Selecao> selecoes = repo.findAll();
        return selecoes;
    }

    public Selecao consultar(String sigla){
        Optional<Selecao> opt = repo.findById(sigla);
        return opt.orElseThrow(()-> new RegistroNaoEncontradoException(Selecao.class.getSimpleName(), sigla));
    }

    public Selecao atualizar (Selecao selecao){
        final String sigla = selecao.getSigla();
        Selecao selecaoBD = repo.findById(sigla)
                .orElseThrow(()-> new RegistroNaoEncontradoException((Selecao.class.getSimpleName()),sigla));
        selecaoBD.setGrupo(selecao.getGrupo());
        selecaoBD.setNome(selecao.getNome());
        selecao = repo.save(selecaoBD);
        return selecao;
    }

    public void excluir (String sigla){
        boolean existe = repo.existsById(sigla);
        if (!existe)
            throw new RegistroNaoEncontradoException(Selecao.class.getSimpleName(), sigla);
        repo.deleteById(sigla);
    }

}
