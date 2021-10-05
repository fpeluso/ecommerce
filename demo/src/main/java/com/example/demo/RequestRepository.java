package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<DemoEntityModel, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE DemoEntityModel d SET d.field1 = :field1 WHERE d.version = :version")
    int updateField1(@Param("field1") String field1, @Param("version") int version);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT d FROM DemoEntityModel d WHERE d.field1 = :field1")
    List<DemoEntityModel> findAllByField1(@Param("field1") String field1);


}
