package com.cta.conductor.menu.info_sugerencia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cta.conductor.R;

import java.util.List;

public class SugeAdapter extends RecyclerView.Adapter<SugeAdapter.ViewHolder> implements View.OnClickListener
{
    List<SugeModel> sugeModelList;
    private View.OnClickListener listenersuge;

    public SugeAdapter(Context context, List<SugeModel> sugeList) {
        this.sugeModelList=sugeList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_sugerencia,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SugeAdapter.ViewHolder holder, int position) {
        holder.fecha.setText(sugeModelList.get(position).getFecha());
        holder.tipo.setText(sugeModelList.get(position).getTipo());
        holder.area.setText(sugeModelList.get(position).getArea());
        holder.informe.setText(sugeModelList.get(position).getInforme());
        holder.estado.setText(sugeModelList.get(position).getEstado());
    }

    @Override
    public int getItemCount() {
        return sugeModelList.size();
    }

    private static SugeAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.listenersuge=listener;
    }

    @Override
    public void onClick(View view) {
        if(listenersuge!=null){
            listenersuge.onClick(view);
        }
    }

    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fecha,tipo,area,informe,estado;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha=itemView.findViewById(R.id.suge_fecha);
            tipo=itemView.findViewById(R.id.suge_tipo);
            area=itemView.findViewById(R.id.suge_area);
            informe=itemView.findViewById(R.id.suge_informe);
            estado=itemView.findViewById(R.id.suge_estado);
        }
    }

}


