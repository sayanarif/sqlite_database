package com.example.user.sq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    TextView textView1,textView2;
    private ArrayList<Movie>persons;
    private Movie movie;
    private MovieAdapter movieAdapter;
    private MovieDatabaseSource movieDatabaseSource;
    private String mviename,mvieyear;
    private int rowid;
    private Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=(TextView)findViewById(R.id.moviename);
        textView2=(TextView)findViewById(R.id.movieyear);
        addbtn=(Button)findViewById(R.id.addbtn);
        movieDatabaseSource=new MovieDatabaseSource(this);

        mviename=getIntent().getStringExtra("name");
        mvieyear=getIntent().getStringExtra("year");
        rowid=getIntent().getIntExtra("id",0);

        textView1.setText(mviename);
        textView2.setText(mvieyear);
        if (rowid>0){
            addbtn.setText("update");

        }

    }

    public void addMvie(View view) {

        String Name=textView1.getText().toString();
        String Year=textView2.getText().toString();
        if (Name.isEmpty()){
            textView1.setError("This field must not be empty");}
            else if (Year.isEmpty()){
                textView2.setError("This field must not be empty");}
                else{
            if (rowid > 0) {
                movie=new Movie(Name,Year,rowid);
                boolean status=movieDatabaseSource.updateMovie(movie,rowid);
                if (status){
                    Toast.makeText(this,"Updated",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,MovieListActivity.class));
                }else {
                    Toast.makeText(this," failed to Updated",Toast.LENGTH_SHORT).show();
                }

            }else {

                movie=new Movie(Name,Year);
                boolean status=movieDatabaseSource.addMovie(movie);
                if (status){
                    Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,MovieListActivity.class));
                }else{
                    Toast.makeText(this,"could not save",Toast.LENGTH_SHORT).show();
                }
            }
            }
                }





    public void Viewmvie(View view) {

        startActivity(new Intent(MainActivity.this,MovieListActivity.class));
    }
}
