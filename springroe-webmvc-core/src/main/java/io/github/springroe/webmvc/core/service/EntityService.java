package io.github.springroe.webmvc.core.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import io.github.springroe.webmvc.core.convert.EntityConvertSupport;
import io.github.springroe.data.core.criterion.DataCriterion;
import io.github.springroe.data.core.domain.Persistable;
import io.github.springroe.data.core.repository.Repository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Function;

public interface EntityService<T extends Persistable<ID>, ID extends Serializable>
        extends DataCriterion<T, ID>,
        EntityConvertSupport {

    Repository<T, ID> getRepository();

    @Override
    default Class<T> getEntityClass() {
        return getRepository().getEntityClass();
    }

    @Override
    default <S extends T> S save(S entity) {
        return getRepository().save(entity);
    }

    @Override
    default <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        return getRepository().saveAll(entities);
    }

    @Override
    default Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    default boolean existsById(ID id) {
        return getRepository().existsById(id);
    }

    @Override
    default Iterable<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    default Iterable<T> findAllById(Iterable<ID> ids) {
        return getRepository().findAllById(ids);
    }

    @Override
    default Iterable<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    default Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    default long count() {
        return getRepository().count();
    }

    @Override
    default void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    default void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    default void deleteAllById(Iterable<? extends ID> ids) {
        getRepository().deleteAllById(ids);
    }

    @Override
    default void deleteAll(Iterable<? extends T> entities) {
        getRepository().deleteAll(entities);
    }

    @Override
    default void deleteAll() {
        getRepository().deleteAll();
    }

    @Override
    default Optional<T> findOne(Predicate predicate) {
        return getRepository().findOne(predicate);
    }

    @Override
    default Iterable<T> findAll(Predicate predicate) {
        return getRepository().findAll(predicate);
    }

    @Override
    default Iterable<T> findAll(Predicate predicate, Sort sort) {
        return getRepository().findAll(predicate, sort);
    }

    @Override
    default Iterable<T> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
        return getRepository().findAll(predicate, orders);
    }

    @Override
    default Iterable<T> findAll(OrderSpecifier<?>... orders) {
        return getRepository().findAll(orders);
    }

    @Override
    default Page<T> findAll(Predicate predicate, Pageable pageable) {
        return getRepository().findAll(predicate, pageable);
    }

    @Override
    default long count(Predicate predicate) {
        return getRepository().count(predicate);
    }

    @Override
    default boolean exists(Predicate predicate) {
        return getRepository().exists(predicate);
    }

    @Override
    default <S extends T, R> R findBy(Predicate predicate, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return getRepository().findBy(predicate, queryFunction);
    }

    @Override
    default <S extends T> Optional<S> findOne(Example<S> example) {
        return getRepository().findOne(example);
    }

    @Override
    default <S extends T> Iterable<S> findAll(Example<S> example) {
        return getRepository().findAll(example);
    }

    @Override
    default <S extends T> Iterable<S> findAll(Example<S> example, Sort sort) {
        return getRepository().findAll(example, sort);
    }

    @Override
    default <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return getRepository().findAll(example, pageable);
    }

    @Override
    default <S extends T> long count(Example<S> example) {
        return getRepository().count(example);
    }

    @Override
    default <S extends T> boolean exists(Example<S> example) {
        return getRepository().exists(example);
    }

    @Override
    default <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return getRepository().findBy(example, queryFunction);
    }
}
