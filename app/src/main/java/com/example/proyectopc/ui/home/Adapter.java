package com.example.proyectopc.ui.home;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.proyectopc.R;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

// Extends the Adapter class to RecyclerView.Adapter
// and implement the unimplemented methods
class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList img, nombre, tiempo;
    Context context;

    // Constructor for initialization
    public Adapter(Context context, ArrayList img, ArrayList nombre, ArrayList tiempo) {
        this.context = context;
        this.img = img;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating the Layout(Instantiates list_item.xml
        // layout file into View object)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        // Passing view to ViewHolder
        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view);
        return viewHolder;
    }

    // Binding data to the into specified position
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        // TypeCast Object to int type
        int res = (int) img.get(position);
        holder.images.setImageResource(res);
        holder.text1.setText((String) nombre.get(position));
        holder.text2.setText((String) tiempo.get(position));

    }

    @Override
    public int getItemCount() {
        // Returns number of items
        // currently available in Adapter
        return img.size();
    }

    // Initializing the Views
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView text1, text2;

        public ViewHolder(View view) {
            super(view);
            images = (ImageView) view.findViewById(R.id.img);
            text1 = (TextView) view.findViewById(R.id.nombre);
            text2 = (TextView) view.findViewById(R.id.tiempo);

        }
    }
}
