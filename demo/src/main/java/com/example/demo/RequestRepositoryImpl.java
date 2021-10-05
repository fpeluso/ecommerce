package com.example.demo;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class RequestRepositoryImpl implements JpaRepository<DemoEntityModel, Long> {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public List<DemoEntityModel> findAll() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return em.createQuery("select d from DemoEntityModel d", DemoEntityModel.class).getResultList();
    }

    @Override
    public List<DemoEntityModel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DemoEntityModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<DemoEntityModel> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(DemoEntityModel demoEntityModel) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends DemoEntityModel> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends DemoEntityModel> S save(S s) {
        return null;
    }

    @Override
    public <S extends DemoEntityModel> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<DemoEntityModel> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends DemoEntityModel> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends DemoEntityModel> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DemoEntityModel> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DemoEntityModel getOne(Long aLong) {
        return null;
    }

    @Override
    public DemoEntityModel getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DemoEntityModel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DemoEntityModel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DemoEntityModel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DemoEntityModel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DemoEntityModel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DemoEntityModel> boolean exists(Example<S> example) {
        return false;
    }
}
