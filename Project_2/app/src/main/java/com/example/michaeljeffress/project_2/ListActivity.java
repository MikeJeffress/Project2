package com.example.michaeljeffress.project_2;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
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

    private Dbase dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        winelist = Dbase.getInstance(this).getWine();
        adapter = new ListCustomAdapter(this, R.layout.list_item_layout, winelist);
        shoppingCart = (ImageButton) findViewById(R.id.button_shopping);
        listView = (ListView) findViewById(R.id.list_wine);

        dbHelper = new Dbase(ListActivity.this);

        handleIntent(getIntent());

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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            winelist = dbHelper.searchWineList(query);
            adapter.clear();
            adapter.addAll(winelist);
            adapter.notifyDataSetChanged();
        }
    }

}


