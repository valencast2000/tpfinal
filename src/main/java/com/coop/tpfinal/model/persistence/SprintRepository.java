package com.coop.tpfinal.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coop.tpfinal.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long>{

	public List<Sprint> findByName(String name);
}
