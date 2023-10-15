package me.ensa.pizzarecipes.data;

import android.content.Context;

import java.util.List;

import me.ensa.pizzarecipes.R;
import me.ensa.pizzarecipes.classes.Produit;
import me.ensa.pizzarecipes.service.ProduitService;

public class DataSource {
    private ProduitService ps = new ProduitService();
    private static DataSource instance;
    private Context mcontext;
    private DataSource(Context mcontext) {
        this.mcontext = mcontext;
        createPizza();
    }

    public static DataSource getInstance(Context mcontext){
        if(instance == null){
            instance = new DataSource(mcontext);
            return instance;
        }
        return instance;
    }

    public void createPizza(){
        ps.create(
                new Produit(
                        R.string.name_pizza_1, 3, R.drawable.pizza1, mcontext.getString(R.string.duree_pizza_1, 35),
                        R.string.detaisIngred_pizza_1, R.string.description_pizza_1, R.string.preparation_pizza_1
                )
        );
        ps.create(
                new Produit(
                        R.string.name_pizza_2, 5, R.drawable.pizza2, mcontext.getString(R.string.duree_pizza_2, 35),
                        R.string.detaisIngred_pizza_2, R.string.description_pizza_2, R.string.preparation_pizza_2
                )
        );
        ps.create(
                new Produit(
                        R.string.name_pizza_3, 2, R.drawable.pizza3, mcontext.getString(R.string.duree_pizza_3, 25),
                        R.string.detaisIngred_pizza_3, R.string.description_pizza_3, R.string.preparation_pizza_3
                )
        );
        ps.create(
                new Produit(
                        R.string.name_pizza_4, 8, R.drawable.pizza4, mcontext.getString(R.string.duree_pizza_4, 45),
                        R.string.detaisIngred_pizza_4, R.string.description_pizza_4, R.string.preparation_pizza_4
                )
        );
        ps.create(
                new Produit(
                        R.string.name_pizza_5, 4, R.drawable.pizza5, mcontext.getString(R.string.duree_pizza_5, 50),
                        R.string.detaisIngred_pizza_5, R.string.description_pizza_5, R.string.preparation_pizza_5
                )
        );
        ps.create(
                new Produit(
                        R.string.name_pizza_6, 3, R.drawable.pizza6, mcontext.getString(R.string.duree_pizza_6, 50),
                        R.string.detaisIngred_pizza_6, R.string.description_pizza_6, R.string.preparation_pizza_6
                )
        );
        ps.create(
                new Produit(
                        R.string.name_pizza_7, 3, R.drawable.pizza7, mcontext.getString(R.string.duree_pizza_7, 30),
                        R.string.detaisIngred_pizza_7, R.string.description_pizza_7, R.string.preparation_pizza_7
                )
        );
        ps.create(
                new Produit(
                        R.string.name_pizza_8, 2, R.drawable.pizza8, mcontext.getString(R.string.duree_pizza_8, 20),
                        R.string.detaisIngred_pizza_8, R.string.description_pizza_8, R.string.preparation_pizza_8
                )
        );
        ps.create(
                new Produit(
                        R.string.name_pizza_9, 1, R.drawable.pizza9, mcontext.getString(R.string.duree_pizza_9, 30),
                        R.string.detaisIngred_pizza_9, R.string.description_pizza_9, R.string.preparation_pizza_9
                )
        );
        ps.create(
                new Produit(
                        R.string.name_pizza_10, 5, R.drawable.pizza10, mcontext.getString(R.string.duree_pizza_10, 45),
                        R.string.detaisIngred_pizza_10, R.string.description_pizza_10, R.string.preparation_pizza_10
                )
        );
    }

    public List<Produit> getListPizza(){
        return ps.findAll();
    }
}
