package com.cta.conductor.menu.info_horariolaboral;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cta.conductor.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> implements View.OnClickListener
{
    List<PostModel> postList;
    private View.OnClickListener listener;

    public PostAdapter(Context context, List<PostModel> postList) {
        this.postList=postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_horario,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fecha,lugar_inicio,lugar_fin,hora_asist_cond,hora_fin_prog,servicio,tipo_dia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha=itemView.findViewById(R.id.fecha_calendario);
            lugar_inicio=itemView.findViewById(R.id.lugar_inicio_calendario);
            lugar_fin=itemView.findViewById(R.id.lugar_fin_calendario);
            hora_asist_cond=itemView.findViewById(R.id.hora_asist_cond_calendario);
            hora_fin_prog=itemView.findViewById(R.id.hora_fin_prog_calendario);
            servicio=itemView.findViewById(R.id.servicio_calendario);
            tipo_dia=itemView.findViewById(R.id.tipo_dia_calendario);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.fecha.setText(postList.get(position).getFecha());
        holder.lugar_inicio.setText(postList.get(position).getLugar_inicio());
        holder.lugar_fin.setText(postList.get(position).getLugar_fin());
        holder.hora_asist_cond.setText(postList.get(position).getHora_asist_cond());
        holder.hora_fin_prog.setText(postList.get(position).getHora_fin_prog());
        holder.servicio.setText(postList.get(position).getServicio());
        holder.tipo_dia.setText(postList.get(position).getServicio());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    private static OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

}

