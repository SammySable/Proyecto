package com.cta.conductor.menu.info_peticion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cta.conductor.R;

import java.util.List;

public class PetiAdapter extends RecyclerView.Adapter<PetiAdapter.ViewHolder> implements View.OnClickListener
{
    List<PetiModel> petiModelList;
    private View.OnClickListener listenerpeti;

    public PetiAdapter(Context context, List<PetiModel> petiModel) {
        this.petiModelList = petiModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_peticion,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetiAdapter.ViewHolder holder, int position) {
        holder.fecha.setText(petiModelList.get(position).getFecha());
        holder.tipo.setText(petiModelList.get(position).getTipo());
        holder.motivo.setText(petiModelList.get(position).getMotivo());
        holder.informe.setText(petiModelList.get(position).getInforme());
        holder.estado.setText(petiModelList.get(position).getEstado());
        holder.comentario.setText(petiModelList.get(position).getComentario());
    }

    @Override
    public int getItemCount() {
        return petiModelList.size();
    }

    private static PetiAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.listenerpeti =listener;
    }

    @Override
    public void onClick(View view) {
        if(listenerpeti !=null){
            listenerpeti.onClick(view);
        }
    }

    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fecha,tipo,motivo,informe,estado,comentario;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha =itemView.findViewById(R.id.peti_fecha);
            tipo =itemView.findViewById(R.id.peti_tipo);
            motivo =itemView.findViewById(R.id.peti_motivo);
            informe =itemView.findViewById(R.id.peti_informe);
            estado =itemView.findViewById(R.id.peti_estado);
            comentario =itemView.findViewById(R.id.peti_comentario);

        }
    }
}

