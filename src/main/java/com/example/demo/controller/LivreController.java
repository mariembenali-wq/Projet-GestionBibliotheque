
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Livre;
import com.example.demo.repository.LivreRepository;

@RestController
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreRepository livreRepository;

    // Afficher tous les livres
    @GetMapping
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // Ajouter un livre
    @PostMapping
    public Livre addLivre(@RequestBody Livre livre) {
        return livreRepository.save(livre);
    }

    // Chercher un livre par id
    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable("id") Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    // Modifier un livre
    @PutMapping("/{id}")
    public Livre updateLivre(@PathVariable("id") Long id,
                             @RequestBody Livre newLivre) {

        return livreRepository.findById(id).map(livre -> {

            livre.setTitre(newLivre.getTitre());
            livre.setAuteur(newLivre.getAuteur());
            livre.setPrix(newLivre.getPrix());

            return livreRepository.save(livre);

        }).orElse(null);
    }

    // Supprimer un livre
    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable("id") Long id) {
        livreRepository.deleteById(id);
    }
}