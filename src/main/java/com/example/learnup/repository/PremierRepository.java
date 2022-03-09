package com.example.learnup.repository;

import com.example.learnup.model.Premier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PremierRepository extends JpaRepository<Premier, String> {

    @Modifying
    @Query("update Premier u set u.description = :description, u.ageGroup = :ageGroup where u.name = :name")
    void updatePremier(@Param(value = "name") String name, @Param(value = "description") String description, @Param(value = "ageGroup") String ageGroup);

}
