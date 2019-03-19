package com.example.user.sq;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {

    private Context context;
    private ArrayList<Movie>persons;

    public MovieAdapter(@NonNull Context context, ArrayList<Movie>persons) {
        super(context, R.layout.row_item,persons);

        this.context=context;
        this.persons=persons;
    }
    class Viewholder{
        TextView moviename;
        TextView mvieYear;
        ImageView MyImage;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        Viewholder holder;
        if (convertView==null){
            holder=new Viewholder();
            convertView=inflater.inflate(R.layout.row_item,parent,false);
            holder.moviename=(TextView)convertView.findViewById(R.id.moviename);
            holder.mvieYear=(TextView)convertView.findViewById(R.id.movieyear);
            holder.MyImage=(ImageView)convertView.findViewById(R.id.myimage);
            convertView.setTag(holder);

        }else {
            holder=(Viewholder)convertView.getTag();
        }
        holder.moviename.setText(persons.get(position).getMoviename());
        holder.mvieYear.setText(persons.get(position).getMvieYear());
        return convertView;




    }
}
