package tech.devinhouse.copamundoapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.copamundoapi.exception.RegistroExistenteException;
import tech.devinhouse.copamundoapi.exception.RegistroNaoEncontradoException;
import tech.devinhouse.copamundoapi.model.Jogador;
import tech.devinhouse.copamundoapi.model.Selecao;
import tech.devinhouse.copamundoapi.repository.JogadorRepository;
import tech.devinhouse.copamundoapi.repository.SelecaoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JogadorService {

    private JogadorRepository jogadorRepo;
    private SelecaoRepository selecaoRepo;


    public Jogador criar(String sigla, Jogador jogador) {
        Selecao selecao = selecaoRepo.findById(sigla)
                .orElseThrow(()->new RegistroNaoEncontradoException(Selecao.class.getSimpleName(), sigla));
        final String nome = jogador.getNome();
        boolean existeComMesmoNomeNoMesmoTime = selecao.getJogadores().stream().anyMatch(p->p.getNome().equals(nome));
        if (existeComMesmoNomeNoMesmoTime)
            throw new RegistroExistenteException(Jogador.class.getSimpleName(), nome);
        jogador.setSelecao(selecao);
        jogador = jogadorRepo.save(jogador);
        return jogador;
    }

    public List<Jogador> consultar(){
        List<Jogador> jogadores = jogadorRepo.findAll();
        return jogadores;
    }

    public Jogador consultar(Integer id){
        Optional<Jogador> opt = jogadorRepo.findById(id);
        return opt.orElseThrow(()-> new RegistroNaoEncontradoException(Selecao.class.getSimpleName(), id.toString()));
    }

    public List<Jogador> consultar(String sigla, String pesquisa){
        Selecao selecao = selecaoRepo.findById(sigla)
                .orElseThrow(()->new RegistroNaoEncontradoException(Selecao.class.getSimpleName(),sigla));
        List<Jogador> jogadores = selecao.getJogadores();
        if(pesquisa !=null){
            jogadores = jogadores.stream().filter(j->j.getNome().contains(pesquisa)).collect(Collectors.toList());
        }
        return jogadores;
    }

    public Jogador atualizar (Jogador jogador){
        final Integer id = jogador.getId();
        Jogador jogadorBD = jogadorRepo.findById(id)
                .orElseThrow(()-> new RegistroNaoEncontradoException(Jogador.class.getSimpleName(),id.toString()));
        jogadorBD.setNome(jogador.getNome());
        jogadorBD.setPosicao(jogador.getPosicao());
        jogadorBD.setSelecao(jogador.getSelecao());
        jogador = jogadorRepo.save(jogadorBD);
        return jogador;
    }

    public void excluir (Integer id){
        boolean existe = jogadorRepo.existsById(Integer.valueOf(id));
        if (!existe)
            throw new RegistroNaoEncontradoException(Selecao.class.getSimpleName(), id.toString());
        jogadorRepo.deleteById(id);
    }

    public void excluir(String sigla, Integer idJogador) {
        Optional<Jogador> opt = jogadorRepo.findBySelecaoEidJogador(sigla, idJogador);
        if (opt.isEmpty())
            throw new RegistroNaoEncontradoException(Jogador.class.getSimpleName(), idJogador.toString());
        jogadorRepo.deleteById(idJogador);
    }
}
