package lveapp.fr.retrofitnumbertwo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Maranatha on 10/10/2017.
 */

public interface ApiInterface {

    // ?m=1 equal end of webservice url
    @POST("?m=1")
    Call<List<Pays>> getAllPays();
}
