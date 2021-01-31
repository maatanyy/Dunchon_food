package org.techtown.food;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecfoodAdapter2 extends  RecyclerView.Adapter<RecfoodAdapter2.ViewHolder> {
    ArrayList<Recfood> items = new ArrayList<Recfood>();

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textName;
        TextView textPrice;

        public ViewHolder(View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textPrice= itemView.findViewById(R.id.textPrice);
        }

        public void setItem(Recfood item){
            imageView.setImageResource(item.getResId());
            textName.setText(item.getName());
            textPrice.setText(item.getPrice());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.recfood_item2,viewGroup,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Recfood item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Recfood item){
        items.add(item);
    }

    public void setItems(ArrayList<Recfood> items){
        this.items =items;
    }

    public Recfood getItem(int position){
        return items.get(position);
    }

    public void setItem(int position,Recfood item){
        items.set(position,item);
    }
}
