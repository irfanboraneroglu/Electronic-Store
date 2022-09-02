package com.example.electronicstore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class CategoryFragment extends Fragment {

    CardView cardTelevision, cardLaptops, cardMobilPhone, cardSmartwatch, cardHeadphone, cardMouse;
    Bundle bundle;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_category, container, false);

        cardTelevision=view.findViewById(R.id.cardTelevision);
        cardLaptops=view.findViewById(R.id.cardLaptop);
        cardMobilPhone=view.findViewById(R.id.cardMobilePhone);
        cardSmartwatch=view.findViewById(R.id.cardSmartwatch);
        cardHeadphone=view.findViewById(R.id.cardHeadphone);
        cardMouse=view.findViewById(R.id.cardMouse);


        cardTelevision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle = new Bundle();
                bundle.putString("SearchValue","Television");
                GoProductsFragmnet();

            }
        });

        cardLaptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("SearchValue","Laptop");
                GoProductsFragmnet();
            }
        });

        cardMobilPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("SearchValue","MobilePhone");
                GoProductsFragmnet();
            }
        });

        cardSmartwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("SearchValue","Smartwatch");
                GoProductsFragmnet();
            }
        });

        cardHeadphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("SearchValue","Headphone");
                GoProductsFragmnet();
            }
        });

        cardMouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("SearchValue","Mouse");
                GoProductsFragmnet();
            }
        });

        return view;

    }

    void GoProductsFragmnet(){

        ProductsFragment productsFragment= new ProductsFragment();
        productsFragment.setArguments(bundle);
        FragmentTransaction ft= getParentFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,productsFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }



}