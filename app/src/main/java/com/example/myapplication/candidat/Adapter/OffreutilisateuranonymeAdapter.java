package com.example.myapplication.candidat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.candidat.model.Offre;
import com.example.myapplication.candidat.view.CandidaterActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OffreutilisateuranonymeAdapter extends BaseAdapter {

    private Context context;
    private List<Offre> offreItems;

    private LayoutInflater inflater;

    public OffreutilisateuranonymeAdapter (Context context, List<Offre> offreItems){
        this.context= context;
        this.offreItems = offreItems;
        this.inflater = LayoutInflater.from(context);
    }

    // recuperation de date courantes
    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();



    @Override
    public int getCount() {
        return offreItems.size();
    }

    @Override
    public Offre getItem(int position) {

        return offreItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.liste_offre_anonyme, null );


        // recuperation des data
        Offre currantItem = getItem(position);
        String poste = currantItem.title;
        String entreprise = currantItem.organization;
        String region = currantItem.cite;
        String salaire= currantItem.salary;

        // get item name view
        TextView itempost= convertView.findViewById(R.id.txtDeveloppeurWeb);
        itempost.setText(poste);
        TextView itentreprise= convertView.findViewById(R.id.txtentreprise);
        itentreprise.setText(entreprise);
        TextView itemregion= convertView.findViewById(R.id.txtregion);
        itemregion.setText(region);
        TextView itemsalaire= convertView.findViewById(R.id.txtPrice);
        itemsalaire.setText(salaire);
        Button boutonPostuler = convertView.findViewById(R.id.txtpostuler);



        // Ajout de l'offre à l'intent
        Gson gson = new GsonBuilder().create();
        String offreJson = gson.toJson(currantItem);

        boutonPostuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent().setClass(v.getContext(), CandidaterActivity.class);
                intent.putExtra("offre", offreJson);
                context.startActivity(intent);
            }
        });




        return convertView;
    }

}
