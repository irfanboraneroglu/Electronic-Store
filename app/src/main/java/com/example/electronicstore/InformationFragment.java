package com.example.electronicstore;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class InformationFragment extends Fragment {

    TextView BoxName, BoxPrice, BoxDetail;
    ImageView BoxImage;
    FloatingActionButton BtnFab;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_information, container, false);

        BoxName= view.findViewById(R.id.infoName);
        BoxPrice=view.findViewById(R.id.infoPrice);
        BoxDetail=view.findViewById(R.id.infoDetails);
        BoxImage= view.findViewById(R.id.infoImage);

        Bundle bundle = this.getArguments();
        String passName = bundle.getString("passName");
        String passPrice = bundle.getString("passPrice");
        String passDescription = bundle.getString("passDescription");
        String passResorceId = bundle.getString("passResorceId");

        BoxName.setText(passName);
        BoxPrice.setText(passPrice);
        BoxDetail.setText(passDescription);
        BoxImage.setImageResource(Integer.parseInt(passResorceId));

        BtnFab= view.findViewById(R.id.fabShare);
        BtnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TextInput = passName+"\nPrice: "+passPrice+"\nDescription:\n"+passDescription;
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, TextInput);
                startActivity(intent);
            }
        });

        return view;

    }
}