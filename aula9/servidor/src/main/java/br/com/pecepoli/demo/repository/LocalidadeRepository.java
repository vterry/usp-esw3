package br.com.pecepoli.demo.repository;

import br.com.pecepoli.demo.domain.Localidade;
import br.com.pecepoli.demo.domain.Pacote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, UUID> {

    // Incluir uma consulta adicionar por Estado;
    // Incluir uma lista q filtre por descricao ou estado;

    //Exemplos
    //    @Query("select p.id from Pacote p")
    //    Page<UUID> findIds(Pageable pageable);


}
