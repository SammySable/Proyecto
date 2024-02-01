package com.cta.conductor.menu.info_horariolaboral.info_detallehorario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cta.conductor.R;

import java.util.List;

public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.ViewHolder> implements View.OnClickListener
{
    List<DetalleModel> detalleList;
    private View.OnClickListener listenerdetalle;

    public DetalleAdapter(Context context, List<DetalleModel> detalleList) {
        this.detalleList = detalleList;
    }

    @NonNull
    @Override
    public DetalleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_detallehorario,parent,false);
        view.setOnClickListener(this);
        return new DetalleAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final DetalleAdapter.ViewHolder holder, int position) {
        holder.ftime.setText(detalleList.get(position).getFtime());
        holder.fnode.setText(detalleList.get(position).getFnode());
        holder.ttime.setText(detalleList.get(position).getTtime());
        holder.tnode.setText(detalleList.get(position).getTnode());
        holder.servicio.setText(detalleList.get(position).getServicio());
    }

    @Override
    public int getItemCount() {
        return detalleList.size();
    }

    private static DetalleAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener listenerdetalle) {
        this.listenerdetalle =listenerdetalle;
    }


    @Override
    public void onClick(View view) {
        if(listenerdetalle !=null){
            listenerdetalle.onClick(view);
        }
    }

    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ftime,fnode,ttime,tnode,servicio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ftime =itemView.findViewById(R.id.detalle_horainicio);
            fnode =itemView.findViewById(R.id.detalle_lugarinicio);
            ttime =itemView.findViewById(R.id.detalle_horafinal);
            tnode =itemView.findViewById(R.id.detalle_lugarfinal);
            servicio =itemView.findViewById(R.id.detalle_servicio);
        }
    }

}

