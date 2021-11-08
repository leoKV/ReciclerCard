package mx.edu.utng.reciclercard01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {
    //Clase adaptadora de vista y modelo
    private List<Usuario> usuarioList;
    private Context context;

    //Crear Constructor con parametros


    public UsuarioAdaptador(List<Usuario> usuarioList, Context context) {
        this.usuarioList = usuarioList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Pasar la tarjeta en un inflante para que se muestre
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarjeta_usuario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Se manipulan
        holder.tvNombre.setText(usuarioList.get(position).getNombre());
        holder.tvEmail.setText(usuarioList.get(position).getEmail());

        //Para la imagen se utilizara una libreria denomidada Glide
        //la cual permite acceder a las imagenes por medio de INTERNET.
        Glide.with(context)
                .load(usuarioList.get(position).getFoto())
                .circleCrop()
                .into(holder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    //Definir una clase interna que herede de RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder{
        //Enlazar los componentes en Layout o tarjeta
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvEmail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Enlaza elementos con la tarjeta de Usuario
            imgFoto =itemView.findViewById(R.id.img_foto);
            tvNombre= itemView.findViewById(R.id.tv_nombre);
            tvEmail= itemView.findViewById(R.id.tv_email);
        }
    }
}
