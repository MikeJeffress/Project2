package com.example.michaeljeffress.project_2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by michaeljeffress on 7/8/16.
 */
public class ShoppingCartActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";
    private ListView listView;
    private ListCustomAdapter adapter;
    private List<Wine> winelist;
    private TextView textView;
    private Button buttonBack;
    private Dbase dbHelper;
    private double total_price = 0;
    private double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_layout);

        winelist = Dbase.getInstance(this).getWineInCart();
        adapter = new ListCustomAdapter(this, R.layout.cart_item_layout, winelist);
        listView = (ListView)findViewById(R.id.listview_shopping);
        textView = (TextView)findViewById(R.id.textview_total_price);
        buttonBack = (Button)findViewById(R.id.button_back);


        listView.setAdapter(adapter);

        dbHelper = new Dbase(ShoppingCartActivity.this);

        for (int i = 0; i < winelist.size(); i++) {
            total_price = total_price + winelist.get(i).getPrice();
        }

        textView.setText(String.valueOf(total_price));
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTypeface(null, Typeface.ITALIC);
        textView.setText(String.format("$"+"%.2f", total_price));


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                dbHelper.deleteWineFromCart(position);
                total_price = total_price - winelist.get(position).getPrice();;
                winelist.remove(position);
                //price = winelist.get(position).getPrice();
                //Log.d(TAG, "onItemClick: position: " + position + "total price: " + total_price + "price: " + price);
                textView.setText(String.format("$"+"%.2f", total_price));
                //Log.d(TAG, "onItemClick: " + dbHelper.getReadableDatabase().get);
                adapter.notifyDataSetChanged();

            }
        });



    }


}
