package com.example.michaeljeffress.project_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

/**
 * Created by michaeljeffress on 7/8/16.
 */
public class ShoppingCartActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";
    private ListView listView;
    private ListCustomAdapter adapter;
    private List<Wine> winelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_layout);

        winelist = Dbase.getInstance(this).getWineInCart();
        adapter = new ListCustomAdapter(this, R.layout.cart_item_layout, winelist);
        listView = (ListView)findViewById(R.id.listview_shopping);

        listView.setAdapter(adapter);

        //for loop on winelist - textview & double sum = 0;


    }


}
