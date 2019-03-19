package com.example.user.sq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {

    private  ListView listView;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie>movies;
    private MovieDatabaseSource movieDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        listView=(ListView)findViewById(R.id.listview);

        movieDatabaseSource=new MovieDatabaseSource(this);
        movies=movieDatabaseSource.getAllMovie();

        movieAdapter=new MovieAdapter(this,movies);
        listView.setAdapter(movieAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=movies.get(position).getMoviename();
                String year=movies.get(position).getMvieYear();
                int rowid=movies.get(position).getMovieid();
                startActivity(new Intent(MovieListActivity.this,MovieDetails.class).putExtra("id",rowid)
                        .putExtra("name",name).
                        putExtra("year",year));
            }
        });
    }
}
