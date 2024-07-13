package br.com.pecepoli.demo.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "LOCALIDADES")
public class Localidade {

    @Id
    @Column(name = "ID")
    @JdbcTypeCode(Types.VARCHAR)
    @GeneratedValue(generator = "ulid_generator")
    private UUID id;

    @Column(name = "DESCRICAO")
    private String descricao;

    private String estado;

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) {this.descricao = descricao; }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Localidade{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
