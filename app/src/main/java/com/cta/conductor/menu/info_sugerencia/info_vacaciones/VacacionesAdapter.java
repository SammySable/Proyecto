package com.cta.conductor.menu.info_sugerencia.info_vacaciones;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cta.conductor.R;

import java.util.List;

public class VacacionesAdapter extends RecyclerView.Adapter<VacacionesAdapter.ViewHolder> implements View.OnClickListener
{
    List<VacacionesModel> vacacionesList;
    private View.OnClickListener listenervacaciones;

    public VacacionesAdapter(Context context, List<VacacionesModel> vacacionesList) {
        this.vacacionesList=vacacionesList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_vacaciones,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.fecha_solicitud.setText(vacacionesList.get(position).getFecha_solicitud());
        holder.tipovacaciones.setText(vacacionesList.get(position).getTipovacaciones());
        holder.fecha_inicial.setText(vacacionesList.get(position).getFecha_inicial());
        holder.fecha_final.setText(vacacionesList.get(position).getFecha_final());
        holder.numero_dias.setText(vacacionesList.get(position).getNumero_dias());
        holder.estado_vac.setText(vacacionesList.get(position).getEstado());

    }
    @Override
    public int getItemCount() {
        return vacacionesList.size();
    }

    private static OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.listenervacaciones=listener;
    }

    @Override
    public void onClick(View view) {
        if(listenervacaciones!=null){
            listenervacaciones.onClick(view);
        }
    }

    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fecha_solicitud,tipovacaciones,fecha_inicial,fecha_final,numero_dias,estado_vac;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha_solicitud=itemView.findViewById(R.id.vacaSolicitud);
            tipovacaciones=itemView.findViewById(R.id.vacaTipo);
            fecha_inicial=itemView.findViewById(R.id.vacaInicio);
            fecha_final=itemView.findViewById(R.id.vacaFin);
            numero_dias=itemView.findViewById(R.id.vacaDias);
            estado_vac=itemView.findViewById(R.id.vacaEstado);

        }
    }

}



