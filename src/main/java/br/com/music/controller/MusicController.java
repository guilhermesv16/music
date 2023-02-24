package br.com.music.controller;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.music.model.MusicModel;

@ApplicationScoped
public class MusicController {
    
    // GET
    // LISTAR MUSICAS PRESENTE NA LISTA
    public List<MusicModel> listMusics() {
        return MusicModel.listAll();
    }

    // GET POR ID
    // PROCURAR MUSICAS PELO ID
    public MusicModel findMusicById(Long id) {
        return MusicModel.findById(id);
    }

    // POST
    // CRIA NOVA MUSICA
    @Transactional
    public MusicModel createMusic(MusicModel NewMusic) {
        MusicModel music = new MusicModel();
        
        music.setName(NewMusic.getName());
        music.setArtist(NewMusic.getArtist());
        music.setFormat(NewMusic.getFormat());
        music.setDuration(NewMusic.getDuration());
        music.setAlbum(NewMusic.getAlbum());
        music.persist();

        return music;
    }

    // PUTT
    // ATUALIZAR MUSICA PELO ID
    @Transactional
    public MusicModel updateMusic(MusicModel updateMusic, Long id) {
        findMusicById(id).setName(updateMusic.getName());
        findMusicById(id).setArtist(updateMusic.getArtist());
        findMusicById(id).setFormat(updateMusic.getFormat());
        findMusicById(id).setDuration(updateMusic.getDuration());
        findMusicById(id).setAlbum(updateMusic.getAlbum());

        return findMusicById(id);
    }

    // DELETE
    // DELETAR MUSICA DA LISTA PELO O ID
    @Transactional
    public boolean deleteMusicById(Long id) {
        return MusicModel.deleteById(id);
    }
}
