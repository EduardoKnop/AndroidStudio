package com.pucpr.cadastropessoas.controller;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pucpr.cadastropessoas.R;
import com.pucpr.cadastropessoas.model.Country;
import com.pucpr.cadastropessoas.model.DataStore;
import com.pucpr.cadastropessoas.view.PersonAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPeople;
    private FloatingActionButton floatingButton;
    private View dialogAddCountry;
    private PersonAdapter adapter;
    private ActivityResultLauncher<Intent> resultAddPerson;
    private ActivityResultLauncher<Intent> resultAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Cadastro de Pessoas");

        DataStore.sharedInstance().setContext(this);

        recyclerViewPeople = findViewById(R.id.recycleViewPeople);
        floatingButton = findViewById(R.id.floatingButtonAdd);

        resultAddPerson = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {

                    adapter.notifyDataSetChanged();
                }
        );

        resultAbout = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                }
        );

        floatingButton.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, AddEditActivity.class);
            //intent.putExtra("type", 1);
            resultAddPerson.launch(intent);
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_primary, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menuAbout:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                resultAbout.launch(intent);
                break;

            case R.id.menuAddCountry:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Add New Country");
                alertDialog.setMessage("Enter the Name of the Country you want to add: ");

                final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);

                alertDialog.setPositiveButton("OK",
                        (dialog, which) -> {
                            String country = input.getText().toString();
                            Country a =
                                    new Country(DataStore.sharedInstance().getCountries(this).size(),
                                    country);
                            a.saveCountry(a, MainActivity.this);
                            Toast.makeText(MainActivity.this,
                                    country + " salvo com Sucesso!",
                                    Toast.LENGTH_SHORT).show();
                        });

                alertDialog.setNegativeButton("Cancel",
                        (dialog, which) -> dialog.cancel());

                alertDialog.show();
                break;

            case R.id.menuClear:
                AlertDialog.Builder dialogClear = new AlertDialog.Builder(MainActivity.this);
                dialogClear.setTitle("Delete All Data");
                dialogClear.setMessage("Are you sure that want to delete ALL registered people?");
                dialogClear.setPositiveButton("Yes", (dialogInterface, i) -> {



                });
                dialogClear.setNegativeButton("No", null);
                dialogClear.show();
                break;

            case R.id.menuDarkMode:

                break;

            case R.id.menuOrderByBirth:
                //
                break;

            case R.id.menuOrderByCity:
                //
                break;

            case R.id.menuOrderByCountry:
                //
                break;

            case R.id.menuOrderByName:
                //
                break;

            case R.id.menuSearch:
                //
                break;
        }

        return true;
    }
}