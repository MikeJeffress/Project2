package com.example.michaeljeffress.project_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

/**
 * Created by michaeljeffress on 7/8/16.
 */
public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";
    private ImageButton shoppingCart;
    private ListView listView;
    private ListCustomAdapter adapter;
    private List<Wine> winelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        winelist = Dbase.getInstance(this).getWine();
        adapter = new ListCustomAdapter(this, R.layout.list_item_layout, winelist);
        shoppingCart = (ImageButton) findViewById(R.id.button_shopping);
        listView = (ListView) findViewById(R.id.list_wine);

        listView.setAdapter(adapter);

        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                intent.putExtra(DetailsActivity.ITEM_ID, winelist.get(position).getId());
                startActivity(intent);
                Log.d(TAG, "onItemClick: Yes, it clicked.");
            }
        });


    }
}


