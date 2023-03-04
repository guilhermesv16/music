package br.com.music.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.inject.Inject;

import br.com.music.controller.MusicController;
import br.com.music.model.MusicModel;
import br.com.music.repository.MusicRepository;

@Path("/music")
public class MusicResource {
    @Inject
    MusicController musicController;
    @Inject
    MusicRepository musicRepository;

    // BUSCAR E LISTAR TODAS AS MUSICAS
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<MusicModel> listMusics() {
        return musicController.listMusics();
    }

    // BUSCAR MUSICAS PELO ID
    @GET
    @Path("/{id}")
    public MusicModel findMusicById(@PathParam("id") Long id) {
        return musicController.findMusicById(id);
    }

    // INSERIR MUSICAS
    @POST
    public MusicModel createMusic(MusicModel newMusic) {
        return musicController.createMusic(newMusic);
    }

    // ATUALIZAR DE ACORDO COM O ID
    @PUT
    @Path("/{id}")
    public MusicModel updateMusic(@PathParam("id") Long id, MusicModel updateMusic) {
        return musicController.updateMusic(updateMusic, id);
    }

    // DELETAR DE ACORDO COM O ID
    @DELETE
    @Path("/{id}")
    public void deleteMusic(@PathParam("id") Long id) {
        musicController.deleteMusicById(id);
    }

    @GET
    @Path("/count")
    public long count(){
        return musicRepository.count();
    }

    @GET
    @Path("/search/{nome}")
    public MusicModel search(@PathParam("nome") String name){
        return musicRepository.findByName(name);
    }
}
