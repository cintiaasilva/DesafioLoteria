package com.api.loteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.api.loteria.domain.Apostador;

@Repository
public interface LoteriaRepository extends JpaRepository<Apostador, Long>{
	
	@Query("select fs from Apostador as fs where fs.email = :email")
	public List<Apostador> buscaFichaSorteioPeloEmail(@Param("email") String email);
	
}
