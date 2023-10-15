package me.ensa.pizzarecipes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import me.ensa.pizzarecipes.R;
import me.ensa.pizzarecipes.adapter.PizzaAdapter;
import me.ensa.pizzarecipes.classes.Produit;
import me.ensa.pizzarecipes.data.DataSource;

public class ListPizzaActivity extends AppCompatActivity {
    private ListView produit_list;
    private FloatingActionButton fab;
    private LinearLayout header;
    private Switch mswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        init();

        // Slide in animation from right to left
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        List<Produit> produits = DataSource.getInstance(this).getListPizza();
        PizzaAdapter adapter = new PizzaAdapter(this, produits);
        produit_list.setAdapter(adapter);

        produit_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListPizzaActivity.this, DetailsPizza.class);
                intent.putExtra("pizza", produits.get(i));
                startActivity(intent);
                finish();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Command you're pizza with our pizza recipes App!");
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });

        // switch theme
        mswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ListPizzaActivity.this.finish();
    }

    private void init(){
        fab = findViewById(R.id.fab);
        produit_list = findViewById(R.id.list_produits);
        header = findViewById(R.id.header);
        mswitch = findViewById(R.id.switch_theme);

        if (isDarkModeEnabled()) {
            mswitch.setChecked(true);
        } else {
            mswitch.setChecked(false);
        }
    }
    private boolean isDarkModeEnabled() {
        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;

        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_YES:
                return true;
            case Configuration.UI_MODE_NIGHT_NO:
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
            default:
                return false;
        }
    }
}