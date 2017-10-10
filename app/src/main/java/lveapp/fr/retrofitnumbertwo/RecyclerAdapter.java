package lveapp.fr.retrofitnumbertwo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Maranatha on 10/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Pays> allPays;

    public RecyclerAdapter(List<Pays> allPays) {
        this.allPays = allPays;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pays, parent, false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.libellePays.setText(allPays.get(position).getNom_fr_fr());
    }

    @Override
    public int getItemCount() {
        return allPays.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView libellePays;
        public MyViewHolder(View itemView) {
            super(itemView);
            libellePays = itemView.findViewById(R.id.textview_pays);
        }
    }
}
