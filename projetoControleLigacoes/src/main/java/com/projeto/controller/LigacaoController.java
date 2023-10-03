package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.entities.Ligacao;
import com.projeto.services.LigacaoService;

@RestController
@RequestMapping("/ligacoes")
public class LigacaoController {
    
    private final LigacaoService ligacaoService;
    
    @Autowired
    public LigacaoController(LigacaoService ligacaoService) {
        this.ligacaoService = ligacaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ligacao> getProductById(@PathVariable Long id) {
    	Ligacao ligacao = ligacaoService.getLigacaoById(id);
        if (ligacao != null) {
            return ResponseEntity.ok(ligacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Ligacao>> getAllLigacoes() {
        List<Ligacao> ligacoes = ligacaoService.getAllLigacoes();
        return ResponseEntity.ok(ligacoes);
    }

    @PostMapping("/")
    public ResponseEntity<Ligacao> criarLigacao(@RequestBody Ligacao ligacao) {
    	Ligacao criarLigacao = ligacaoService.salvarLigacao(ligacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarLigacao);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Ligacao> updateLigacao(@PathVariable Long id, @RequestBody Ligacao ligacao) {
    	Ligacao updatedLigacao = ligacaoService.updateLigacao(id, ligacao);
        if (updatedLigacao != null) {
            return ResponseEntity.ok(updatedLigacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLigacao(@PathVariable Long id) {
        boolean deleted = ligacaoService.deleteLigacao(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O produto foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
       
    
}