package com.alibou1.security1.repository;

import com.alibou1.security1.dto.CotegoryDTO;
import com.alibou1.security1.entity.Category; // Correct the entity class name to Category
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MainRepository extends JpaRepository<Category, Integer> {
    Category findById(int id);

    List<Category> findAll();



    @Modifying
    @Transactional
    @Query("update Category category set category.salary = :moneyCount where category.id = :id")
    void update(@Param("id") int id, @Param("moneyCount") String moneyCount);

    @Modifying
    @Transactional
    @Query("delete Category category where category.id = ?1") // Correct the entity name and the field name
    void deleteById(int id);
}
