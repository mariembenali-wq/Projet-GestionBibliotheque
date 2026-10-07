package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Livre;
import com.example.demo.repository.LivreRepository;

@Service
public class LivreServiceImpl implements LivreService {

    @Autowired
    private LivreRepository repository;

    @Override
    public Livre ajouterLivre(Livre livre) {
        return repository.save(livre);
    }

    @Override
    public List<Livre> afficherTous() {
        return repository.findAll();
    }

    @Override
    public Livre chercherParId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Livre modifierLivre(Long id, Livre livre) {
        Livre l = repository.findById(id).orElse(null);

        if (l != null) {
            l.setTitre(livre.getTitre());
            l.setAuteur(livre.getAuteur());
            l.setPrix(livre.getPrix());

            return repository.save(l);
        }

        return null;
    }

    @Override
    public void supprimerLivre(Long id) {
        repository.deleteById(id);
    }
}