package br.com.pecepoli.demo.domain;

import com.github.f4b6a3.ulid.UlidCreator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class UlidGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor s,
                                 Object o) throws HibernateException {
        UUID uuid = UlidCreator.getMonotonicUlid().toUuid();
        return uuid;
    }

    @Override
    public boolean supportsJdbcBatchInserts() {
        return true;
    }
}