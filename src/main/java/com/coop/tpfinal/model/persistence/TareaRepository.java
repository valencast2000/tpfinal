package com.coop.tpfinal.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coop.tpfinal.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{

}
