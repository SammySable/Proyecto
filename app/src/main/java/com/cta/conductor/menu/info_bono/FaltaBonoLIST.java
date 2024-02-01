package com.cta.conductor.menu.info_bono;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cta.conductor.R;

import java.util.List;

public class FaltaBonoLIST extends RecyclerView.Adapter<FaltaBonoLIST.ViewHolder> implements View.OnClickListener
{
    List<FaltaBonoMODEL> faltaList;
    private View.OnClickListener listenerfaltas;

    public FaltaBonoLIST(Context context, List<FaltaBonoMODEL> FaltaList) {
        this.faltaList=FaltaList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_faltas,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final FaltaBonoLIST.ViewHolder holder, int position) {
        holder.datos_fecha.setText(faltaList.get(position).getDatos_fecha());
        holder.datos_evasion.setText(faltaList.get(position).getDatos_evasion());
        holder.datos_video.setText(faltaList.get(position).getDatos_video());
    }
    @Override
    public int getItemCount() {
        return faltaList.size();
    }

    private static FaltaBonoLIST.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.listenerfaltas=listener;
    }

    @Override
    public void onClick(View view) {
        if(listenerfaltas!=null){
            listenerfaltas.onClick(view);
        }
    }

    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView datos_fecha,datos_evasion,datos_video;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            datos_fecha=itemView.findViewById(R.id.datos_fecha);
            datos_evasion=itemView.findViewById(R.id.datos_evasion);
            datos_video=itemView.findViewById(R.id.datos_video);

        }
    }

}



