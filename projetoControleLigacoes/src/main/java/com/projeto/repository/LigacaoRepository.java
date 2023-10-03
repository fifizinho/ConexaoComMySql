package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.entities.Ligacao;

public interface LigacaoRepository extends JpaRepository<Ligacao, Long> {
	
}