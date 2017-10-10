package lveapp.fr.retrofitnumbertwo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<Pays> allPays;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progress_pays);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        if(isMobileConnected()){
            apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
            Call<List<Pays>> call = apiInterface.getAllPays();
            call.enqueue(new Callback<List<Pays>>() {
                @Override
                public void onResponse(Call<List<Pays>> call, Response<List<Pays>> response) {
                    allPays = response.body();
                    adapter = new RecyclerAdapter(allPays);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<List<Pays>> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                }
            });
        }
        else{
            Toast.makeText(MainActivity.this, "AUCUNE CONNEXION", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isMobileConnected(){
        int[] networkTypes = {ConnectivityManager.TYPE_MOBILE, ConnectivityManager.TYPE_WIFI};
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            for (int networkType : networkTypes) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == networkType) return true;
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }
}
