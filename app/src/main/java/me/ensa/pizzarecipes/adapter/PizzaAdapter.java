package me.ensa.pizzarecipes.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import me.ensa.pizzarecipes.R;

import java.util.List;

import me.ensa.pizzarecipes.classes.Produit;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;

    public PizzaAdapter(Activity activity, List<Produit> produits) {
        this.produits = produits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.item, null);

        TextView name = convertView.findViewById(R.id.pizza_name);
        TextView duration = convertView.findViewById(R.id.duration);
        TextView nbrIngredients = convertView.findViewById(R.id.nbrIngredients);
        ImageView image = convertView.findViewById(R.id.pizza_image);
//        TextView id = convertView.findViewById(R.id.id);

        name.setText(produits.get(position).getNom());
        duration.setText(produits.get(position).getDuree());
        nbrIngredients.setText(String.valueOf(produits.get(position).getNbrIngredients()));
        image.setImageResource(produits.get(position).getPhonto());
//        id.setText(produits.get(position).getId()+"");
        return convertView;
    }
}
