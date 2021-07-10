package com.example.cl12c_recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private Context ctx;

    public MyRestauranteRecyclerViewAdapter(Context context,List<Restaurante> items) {
        this.ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewNombreRestaurante.setText(holder.mItem.getNombre());
        holder.textViewDireccionRestaurante.setText(holder.mItem.getDireccion());
        holder.ratingBarValoracionRestaurante.setRating(holder.mItem.getValoracion());

        Glide.with(ctx).load(holder.mItem.getUrlPhoto()).centerCrop().into(holder.imageViewPhotoRestaurante);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewPhotoRestaurante;
        public final RatingBar ratingBarValoracionRestaurante;
        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombreRestaurante = view.findViewById(R.id.textViewNombreRestaurante);
            textViewDireccionRestaurante = view.findViewById(R.id.textViewDireccionRestaurante);
            imageViewPhotoRestaurante = view.findViewById(R.id.imageViewPhoto);
            ratingBarValoracionRestaurante = view.findViewById(R.id.ratingBarValoracion);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewDireccionRestaurante.getText() + "'";
        }
    }
}