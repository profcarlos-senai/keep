package com.keep.keep2.repository;

import com.keep.keep2.model.M_Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Atividade extends JpaRepository<M_Atividade,Long> {
}
