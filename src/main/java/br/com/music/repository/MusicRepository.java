package br.com.music.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.music.model.MusicModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class MusicRepository implements PanacheRepository<MusicModel> {
    
    // METODO PROCURA A PRIMEIRA MUSICA PELO O NOME USANDO A BIBLIOTECA PANACHEREPOSITORY 
    public MusicModel findByName(String name){
        return find("name", name).firstResult();
    }
}