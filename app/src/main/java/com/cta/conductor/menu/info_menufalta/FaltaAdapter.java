package com.cta.conductor.menu.info_menufalta;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cta.conductor.R;

import java.util.List;

public class FaltaAdapter extends RecyclerView.Adapter<FaltaAdapter.ViewHolder> {

    List<FaltaLista> faltaLista;

    public FaltaAdapter(Context context, List<FaltaLista> faltaListas) {
        this.faltaLista = faltaListas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_faltas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.falta_Fecha.setText(faltaLista.get(position).getFalta_Fecha());
        holder.falta_Tipo_PA.setText(faltaLista.get(position).getFalta_Tipo_PA());
        holder.falta_NivelFalta.setText(faltaLista.get(position).getFalta_NivelFalta());
        holder.falta_Ocurrencia.setText(faltaLista.get(position).getFalta_Ocurrencia());
        holder.falta_Estado.setText(faltaLista.get(position).getFalta_Estado());

    }

    @Override
    public int getItemCount() {
        return faltaLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView falta_Fecha, falta_Tipo_PA, falta_NivelFalta, falta_Ocurrencia, falta_Estado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            falta_Fecha = itemView.findViewById(R.id.falta_fecha);
            falta_Tipo_PA = itemView.findViewById(R.id.falta_tipo_pa);
            falta_NivelFalta = itemView.findViewById(R.id.falta_nivelfalta);
            falta_Ocurrencia = itemView.findViewById(R.id.falta_ocurrencia);
            falta_Estado = itemView.findViewById(R.id.falta_estado);

            estadofalto();
        }

        private void estadofalto() {
            if ("Responsable" == falta_Estado.toString()) {
                LinearLayout caja_estadofalta;
                caja_estadofalta = itemView.findViewById(R.id.caja_estadofalta);
                caja_estadofalta.setBackgroundColor(Color.parseColor("#A00000"));
            } else if ("No Procede" == falta_Estado.toString()) {
                LinearLayout caja_estadofalta;
                caja_estadofalta = itemView.findViewById(R.id.caja_estadofalta);
                caja_estadofalta.setBackgroundColor(Color.parseColor("#007828"));
            }


        }
    }
}




