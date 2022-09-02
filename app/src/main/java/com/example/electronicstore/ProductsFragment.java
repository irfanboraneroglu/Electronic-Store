package com.example.electronicstore;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsFragment extends Fragment {

    private Cursor cursor;
    private SQLiteDatabase db;
    ElectronicDatabaseHelper dbHelper;
    RecyclerView recyclerView;
    ArrayList<String> Iid, Icategory, Iname, Iprice, Idescription, IresourceId, Istar;
    CardViewAdapter cardViewAdapter;
    String SearchValue;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_products, container, false);

        dbHelper= new ElectronicDatabaseHelper(view.getContext());
        Iid = new ArrayList<>();
        Icategory = new ArrayList<>();
        Iname = new ArrayList<>();
        Iprice = new ArrayList<>();
        Idescription = new ArrayList<>();
        IresourceId = new ArrayList<>();
        Istar = new ArrayList<>();

        Bundle bundle = this.getArguments();
        SearchValue = bundle.getString("SearchValue");

        DatabaseToArrays();

        recyclerView= view.findViewById(R.id.recyclerProducts);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        cardViewAdapter = new CardViewAdapter(Icategory, Iname, Iprice, Idescription, IresourceId, Istar);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cardViewAdapter);

        cardViewAdapter.setListener(new CardViewAdapter.Listener() {
            public void onClick(int position) {
                Bundle bundle = new Bundle();

                bundle.putString("passName",Iname.get(position));
                bundle.putString("passPrice",Iprice.get(position));
                bundle.putString("passDescription",Idescription.get(position));
                bundle.putString("passResorceId",IresourceId.get(position));

                InformationFragment informationFragment= new InformationFragment();
                informationFragment.setArguments(bundle);

                FragmentTransaction ft= getParentFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,informationFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }

            @Override
            public void onUpdateClick(int position) {
                String tempId= Iid.get(position);
                String tempCategory= Icategory.get(position);
                String tempName= Iname.get(position);
                String tempPrice= Iprice.get(position);
                String tempDescription= Idescription.get(position);
                int tempIresourceId= Integer.parseInt(IresourceId.get(position));
                int tempStar= Integer.parseInt(Istar.get(position));

                dbHelper.UpdateOneRow(db, tempId, tempCategory, tempName, tempPrice, tempDescription, tempIresourceId, tempStar);
            }
        });

        return view;

    }


    void DatabaseToArrays(){
        cursor= dbHelper.SearchDueToCategory(SearchValue);
        if(cursor.getCount()==0){
            Toast.makeText(getContext(), "No data", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                Iid.add(cursor.getString(0));
                Icategory.add(cursor.getString(1));
                Iname.add(cursor.getString(2));
                Iprice.add(cursor.getString(3));
                Idescription.add(cursor.getString(4));
                IresourceId.add(cursor.getString(5));
                Istar.add(cursor.getString(6));

            }
        }
    }


}