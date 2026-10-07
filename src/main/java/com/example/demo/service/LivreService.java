package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Livre;

public interface LivreService {

    Livre ajouterLivre(Livre livre);

    List<Livre> afficherTous();

    Livre chercherParId(Long id);

    Livre modifierLivre(Long id, Livre livre);

    void supprimerLivre(Long id);
}