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

public class PostAdapterFranco extends RecyclerView.Adapter<PostAdapterFranco.ViewHolder>
{
    List<PostModelFranco> francoList;
    private View.OnClickListener listenerfranco;

    public PostAdapterFranco(Context context, List<PostModelFranco> francoList) {
        this.francoList = francoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_franco,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostAdapterFranco.ViewHolder holder, int position) {
        holder.franco.setText(francoList.get(position).getFranco());
    }

    @Override
    public int getItemCount() {
        return francoList.size();
    }

    private static PostAdapterFranco.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.listenerfranco =listener;
    }

    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView franco;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            franco =itemView.findViewById(R.id.franco);
        }
    }

}
