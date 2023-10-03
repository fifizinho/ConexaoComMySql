package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	
}