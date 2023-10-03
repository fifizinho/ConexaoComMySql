package com.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.entities.Agenda;
import com.projeto.repository.AgendaRepository;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;
    
    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }

    public Agenda getAgendaById(Long id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        return agenda.orElse(null);
    }

    public Agenda salvarAgenda(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Agenda updateAgenda(Long id, Agenda updatedAgenda) {
        Optional<Agenda> existingAgenda = agendaRepository.findById(id);
        if (existingAgenda.isPresent()) {
            updatedAgenda.setId(id);
            return agendaRepository.save(updatedAgenda);
        }
        return null;
    }

    public boolean deleteAgenda(Long id) {
        Optional<Agenda> existingAgenda = agendaRepository.findById(id);
        if (existingAgenda.isPresent()) {
        	agendaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}