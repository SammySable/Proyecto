package com.cta.conductor.menu.info_horariolaboral.info_horas;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cta.conductor.R;

import java.sql.Time;
import java.util.List;

public class HoraAdapter extends RecyclerView.Adapter<HoraAdapter.ViewHolder> implements View.OnClickListener
{
    List<HoraModel> horaList;
    private View.OnClickListener listenerhora;

    public HoraAdapter(Context context, List<HoraModel> horaList) {
        this.horaList = horaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_hora,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.id.setText(horaList.get(position).getId());
        holder.horalaboradaprog.setText(horaList.get(position).getHoralaboradaprog());
        holder.horalaboradareal.setText(horaList.get(position).getHoralaboradareal());
        holder.horalaboradatotal.setText(horaList.get(position).getHoralaboradatotal());
    }


    @Override
    public int getItemCount() {
        return horaList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView horalaboradaprog,horalaboradareal, horalaboradatotal, id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id =itemView.findViewById(R.id.id);
            horalaboradaprog =itemView.findViewById(R.id.horalaboradaprog);
            horalaboradareal =itemView.findViewById(R.id.horalaboradareal);
            horalaboradatotal =itemView.findViewById(R.id.horalaboradatotal);
        }
    }


    private static OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.listenerhora =listener;
    }


    @Override
    public void onClick(View view) {
        if(listenerhora !=null){
            listenerhora.onClick(view);
        }
    }


    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

}

