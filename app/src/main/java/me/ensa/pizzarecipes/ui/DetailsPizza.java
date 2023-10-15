package me.ensa.pizzarecipes.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import me.ensa.pizzarecipes.R;
import me.ensa.pizzarecipes.classes.Produit;

public class DetailsPizza extends AppCompatActivity {
    private ImageView pizza_image, back_up;
    private TextView name, description, ingredients, preparation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pizza);
        init();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        Intent intent = getIntent();
        Produit produit = (Produit) intent.getSerializableExtra("pizza");

        pizza_image.setImageResource(produit.getPhonto());
        name.setText(produit.getNom());
        description.setText(produit.getDescription());
        ingredients.setText(produit.getDetaisIngred());
        preparation.setText(produit.getPreparation());

        back_up = findViewById(R.id.back_up);

        back_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DetailsPizza.this, ListPizzaActivity.class);
//                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
                finish();
            }
        });
    }

    private void init(){
        pizza_image = findViewById(R.id.d_pizza_image);
        name = findViewById(R.id.d_pizza_name);
        description = findViewById(R.id.details_desc);
        ingredients = findViewById(R.id.details_ingred);
        preparation = findViewById(R.id.details_preparation);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent1 = new Intent(DetailsPizza.this, ListPizzaActivity.class);
        startActivity(intent1);
        DetailsPizza.this.finish();
    }
}