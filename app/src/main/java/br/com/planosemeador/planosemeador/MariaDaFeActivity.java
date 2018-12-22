package br.com.planosemeador.planosemeador;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MariaDaFeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Busca
    DatabaseReference fornecedores;

    //Lista
    private RecyclerView recyclerView;
    private List<Fornecedor> listaFornecedores = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maria_da_fe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Semeador - Maria da Fé");


        //Lista inicio!

        recyclerView = findViewById(R.id.recyclerView);

        //Configurar adapter
        adapter = new Adapter( listaFornecedores );

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));


        // Inicio Busca

        fornecedores = FirebaseDatabase.getInstance()
                .getReference().child("fornecedores");

        listaFornecedores.clear();

        Query query2 = fornecedores.orderByChild("categoria").equalTo("maria").limitToFirst(30);
        query2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                        Fornecedor fornecedor = postSnapshot.getValue(Fornecedor.class);
                        String nomeFornecedor = fornecedor.getNomeFornecedor();
                        String enderecoFornecedor = fornecedor.getEnderecoFornecedor();
                        String telefoneFornecedor = fornecedor.getTelefoneFornecedor();
                        String desconto = fornecedor.getDesconto();
                        String subcategoria = fornecedor.getSubcategoria();
                        Fornecedor fornecedorRecycleView = new Fornecedor( nomeFornecedor, "Tel: " +telefoneFornecedor, "Endereço: " + enderecoFornecedor, subcategoria, desconto );

                        listaFornecedores.add(fornecedorRecycleView);

                    }
                    recyclerView.setAdapter( adapter );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        //Lista Fim



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.maria_da_fe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.main_activity_menu) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        } else if (id == R.id.como_funciona) {
            Intent i = new Intent(getApplicationContext(), ComoFuncionaActivity.class);
            startActivity(i);
            finish();

        } else if (id == R.id.sobre_nos) {
            Intent i = new Intent(getApplicationContext(), SobreNosActivity.class);
            startActivity(i);
            finish();
        }else if (id == R.id.brasopolis_menu) {
            Intent i = new Intent(getApplicationContext(), BrasopolisActivity.class);
            startActivity(i);
            finish();
        }else if (id == R.id.piranguinho_menu) {
            Intent i = new Intent(getApplicationContext(), PiranguinhoActivity.class);
            startActivity(i);
            finish();
        }else if (id == R.id.maria_da_fe_menu) {
            Intent i = new Intent(getApplicationContext(), MariaDaFeActivity.class);
            startActivity(i);
            finish();
        }else if (id == R.id.delfim_moreira_menu) {
            Intent i = new Intent(getApplicationContext(), DelfimMoreiraActivity.class);
            startActivity(i);
            finish();
        }else if (id == R.id.assitencia) {
            Intent i = new Intent(getApplicationContext(), AssistenciaActivity.class);
            startActivity(i);
            finish();
        }else if (id == R.id.sorteios) {
            Intent i = new Intent(getApplicationContext(), SorteiosActivity.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
