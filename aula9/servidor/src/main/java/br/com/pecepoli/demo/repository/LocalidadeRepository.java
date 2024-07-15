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

    @Query("select l.id from Localidade l where l.descricao like :criteria or l.estado like :criteria")
    Page<UUID> findIds(@Param("criteria") String criteria, Pageable pageable);

    @Query("select l.id from Localidade l")
    Page<UUID> findIds(Pageable pageable);

}
