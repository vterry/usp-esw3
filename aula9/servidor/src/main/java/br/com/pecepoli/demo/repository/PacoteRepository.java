package br.com.pecepoli.demo.repository;

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
public interface PacoteRepository extends JpaRepository<Pacote, UUID> {

    @Query("select p.id from Pacote p")
    Page<UUID> findIds(Pageable pageable);

    @Query("select p.id from Pacote p where p.descricao like :criteria or p.localidade.descricao like :criteria")
    Page<UUID> findIds(@Param("criteria") String criteria, Pageable pageable);

    @Override
    @Query("select p from Pacote p join fetch p.items where p.id in :ids")
    List<Pacote> findAllById(@Param("ids") Iterable<UUID> ids);
}
