package br.com.planosemeador.planosemeador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Autenticação
    public static final int RC_SIGN_IN = 1;
    String usuarioIdNoDb;
    DatabaseReference noDoUsuario;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    Usuario usuario;
    FirebaseUser user;

    //botoes navegacao
    Button medicos;
    Button clinicas;
    Button laboratorios;
    Button farmacias;
    Button dentistas;
    Button oticas;
    Button academias;
    Button lojas;
    Button diversos;
    Button despachantes;
    Button restaurantes;
    Button veterinarios;
    Button gaseagua;
    Button lavarapido;
    Button beleza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Semeador - Itajubá");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);


        //nova autenticacao
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //Usuario Logado
                    usuarioIdNoDb = user.getUid();
                    noDoUsuario = FirebaseDatabase.getInstance().getReference().child("usuarios").child(usuarioIdNoDb);
                    noDoUsuario.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //texta se o usuario ja existe
                            if (dataSnapshot.exists()) {
                                //Botões de navegação

                                medicos = findViewById(R.id.medicosBtId);
                                medicos.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "medicos";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                                clinicas = findViewById(R.id.clinicasBtId);
                                clinicas.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "clinicas";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                                laboratorios = findViewById(R.id.laboratoriosBtId);
                                laboratorios.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "laboratorios";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                                farmacias = findViewById(R.id.farmaciasBtId);
                                farmacias.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "farmacias";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                                dentistas = findViewById(R.id.dentistasBtId);
                                dentistas.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "odontologia";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                                oticas = findViewById(R.id.oticasBtId);
                                oticas.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "oticas";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                                academias = findViewById(R.id.academiasBtId);
                                academias.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "academias";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                                lojas = findViewById(R.id.lojasBtId);
                                lojas.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "lojas";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                                diversos = findViewById(R.id.diversosBtId);
                                diversos.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "diversos";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                despachantes = findViewById(R.id.despachantesBtId);
                                despachantes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "despachantes";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                restaurantes = findViewById(R.id.restaurantesBtId);
                                restaurantes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "restaurantes";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                veterinarios = findViewById(R.id.veterinariosBtId);
                                veterinarios.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "veterinarios";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                gaseagua = findViewById(R.id.gasAguaBtId);
                                gaseagua.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "gaseagua";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                lavarapido = findViewById(R.id.lavaRapidoBtId);
                                lavarapido.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "lavarapido";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                beleza = findViewById(R.id.belezaBtId);
                                beleza.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s = "beleza";
                                        Intent intent = new Intent(MainActivity.this, ResultadoDaBuscaActivity.class);
                                        intent.putExtra("name", s);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                            }else{
                                //Ainda nao existe, entao inicializa um novo com as configurações padrão
                                String telefoneUser = user.getPhoneNumber();
                                usuario = new Usuario();
                                usuario.setNomeUsuario("Cliente");
                                usuario.setTelefoneUsuario(telefoneUser);
                                noDoUsuario.setValue(usuario);
                                FirebaseMessaging.getInstance().subscribeToTopic("planoSemeador");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else {
                    //user is signed out
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(
                                            Arrays.asList(
                                                    new AuthUI.IdpConfig.PhoneBuilder().build()
                                            ))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };

    }

    @Override
    protected void onStop(){
        super.onStop();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
