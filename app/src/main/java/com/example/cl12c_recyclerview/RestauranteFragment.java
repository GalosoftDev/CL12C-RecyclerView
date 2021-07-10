package com.example.cl12c_recyclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class RestauranteFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    List<Restaurante> restauranteList;

    public RestauranteFragment() {
    }

    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Pizzeria Jorge", "https://i0.wp.com/foodandpleasure.com/wp-content/uploads/2018/06/piantao-3.jpg", 5.6f, "Zapata 22"));
            restauranteList.add(new Restaurante("Tacos Perla", "https://turistaenmexico.mx/wp-content/uploads/2019/11/Restaurantes-de-la-CDMX.jpg", 3.6f, "Juarez 34"));
            restauranteList.add(new Restaurante("Hamburguesas Jorge", "https://cdn.forbes.com.mx/2020/07/Coronavirus-Restaurantes-Covid-19-alimentos-comedor-comida-39-640x360.jpg", 5.6f, "Hidalgo 225"));
            restauranteList.add(new Restaurante("Tortas Jenny", "https://foodandtravel.mx/wp-content/uploads/2020/10/Espacios-al-aire-libre-restaurantes.jpg", 7.6f, "Carranza 22"));
            restauranteList.add(new Restaurante("Postres Gomez", "https://i2.wp.com/thehappening.com/wp-content/uploads/2019/12/terraza-chacha.jpg", 5.6f, "Villa 122"));

            adapterRestaurantes =new MyRestauranteRecyclerViewAdapter(getActivity(),restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}