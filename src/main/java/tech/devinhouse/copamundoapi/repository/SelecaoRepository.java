package tech.devinhouse.copamundoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.copamundoapi.model.Selecao;

@Repository
public interface SelecaoRepository extends JpaRepository<Selecao,String > {
}
