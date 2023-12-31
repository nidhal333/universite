package tn.esprit.uniiversite.service;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import tn.esprit.uniiversite.Reosotiris.FoyerRepository;
import tn.esprit.uniiversite.Reosotiris.UniversiteRepository;
import tn.esprit.uniiversite.entite.Foyer;
import tn.esprit.uniiversite.entite.Universite;

import java.util.Optional;


@AllArgsConstructor
@Service
@Getter
@Setter
public class universiteService implements IUniversiteService{
    UniversiteRepository UniversiteRepository;
    FoyerRepository FoyerRepository;

    public void affecterFoyerAUniversite (long idFoyer, String nomuniversite){
        Universite Universites = UniversiteRepository.findByNomuniversite(nomuniversite);
        Foyer Foyers = FoyerRepository.findById(idFoyer).get();

        Universites.setFoyers(Foyers);
        UniversiteRepository.save(Universites);
    }
    @Override
    public Universite addUniversite(Universite e) {
        return UniversiteRepository.save(e);
    }
    public void desaffecterFoyerAUniversite (long idUniversite){
        Universite Universites = UniversiteRepository.findUniversiteById(idUniversite);
        Universites.setFoyers(null);
        UniversiteRepository.save(Universites);
    }
}
