package com.example.asiancountries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.RecyclerViewHolder> {

    // creating a variable for our array list and context.
    private ArrayList<Country> countriesDataArrayList;
    private Context mcontext;

    // creating a constructor class.
    public CountryAdapter(ArrayList<Country> recyclerDataArrayList, Context mcontext) {
        this.countriesDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview from our country class.
        Country country = countriesDataArrayList.get(position);
        holder.countryName.setText(country.getName());
        holder.capitalName.setText(country.getCapital());
        holder.region.setText(country.getRegion());
        holder.subregion.setText(country.getSubregion());
        holder.population.setText(country.getPopulation());
        holder.borders.setText(country.getBorderCountries());
        holder.languages.setText(country.getLanguages());
        Picasso.get().load(country.getFlag()).into(holder.flag);
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return countriesDataArrayList.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView countryName, capitalName, region, subregion, population, borders, languages;
        private ImageView flag;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our views with their ids.
            countryName = itemView.findViewById(R.id.idCountryName);
            capitalName = itemView.findViewById(R.id.idCapital);
            region = itemView.findViewById(R.id.idRegion);
            subregion = itemView.findViewById(R.id.idSubregion);
            population = itemView.findViewById(R.id.idPopulation);
            borders = itemView.findViewById(R.id.idborders);
            languages = itemView.findViewById(R.id.idlanguages);
            flag = itemView.findViewById(R.id.idFlag);
        }
    }
}
