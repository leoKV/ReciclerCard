 package mx.edu.utng.reciclercard01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {
//Declarar un Reciclet y un Adaptador
    RecyclerView recyclerUsuarios;
    UsuarioAdaptador usuarioAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarElementos();
    }

    private void inicializarElementos() {
        recyclerUsuarios= findViewById(R.id.recycler);
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(this));
        List<Usuario> usuarioList= new ArrayList<>();//Se define estructura de datos
        //para poder usar los metodos como add entre otros de las clase list

        //Se cargaran datos de prueba mediante un ciclo for
        for(int i=0;i<20;i++){
            usuarioList.add(new Usuario(i,("Nombre..." + i),"ApellidoX", "mail@mail.com",
                    "https://s22.postimg.cc/572fvlmg1/vlad-baranov-767980-unsplash.jpg"));
            Log.d("Msg", "Se ha creado el objeto"+ usuarioList.size());
        }
        usuarioAdaptador= new UsuarioAdaptador(usuarioList, this);
        recyclerUsuarios.setAdapter(usuarioAdaptador);//Relacionando el Recycler con su adaptador
        Log.d("Msg","El tamaño de la lista es: "+usuarioList.size());
    }
}