package com.example.user.sq;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetails extends AppCompatActivity {
    private String mviename,mvieyear;
    private int rowid;
    private TextView nametv,yeartv;
    private MovieDatabaseSource movieDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        movieDatabaseSource=new MovieDatabaseSource(this);

        nametv=(TextView)findViewById(R.id.dettxt);
        yeartv=(TextView)findViewById(R.id.dettxt2);

        mviename=getIntent().getStringExtra("name");
        mvieyear=getIntent().getStringExtra("year");
        rowid=getIntent().getIntExtra("id",0);

        nametv.setText(mviename);
        yeartv.setText(mvieyear);
    }

    public void update(View view) {
        startActivity(new Intent(MovieDetails.this,MainActivity.class).putExtra("id",rowid)
                .putExtra("name",mviename).
                        putExtra("year",mvieyear));
    }

    public void delete(View view) {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Delete item");
        alert.setMessage("are you sureto delete this item");
        alert.setPositiveButton("sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean status= movieDatabaseSource.deleteMovive(rowid);
                if (status){
                    Toast.makeText(MovieDetails.this,"item deleted",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MovieDetails.this,MovieListActivity.class));
                }else {
                    Toast.makeText(MovieDetails.this,"Couldn't deleted",Toast.LENGTH_SHORT).show();
                }

            }
        });
        alert.setNegativeButton("cancel",null);
        alert.show();



    }
}
