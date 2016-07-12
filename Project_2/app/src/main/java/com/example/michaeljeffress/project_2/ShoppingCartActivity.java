package com.example.michaeljeffress.project_2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_layout);

        winelist = Dbase.getInstance(this).getWineInCart();
        adapter = new ListCustomAdapter(this, R.layout.cart_item_layout, winelist);
        listView = (ListView)findViewById(R.id.listview_shopping);
        textView = (TextView)findViewById(R.id.textview_total_price);
        double total_price = 0;

        listView.setAdapter(adapter);

        for (int i = 0; i < winelist.size(); i++) {
            total_price = total_price + winelist.get(i).getPrice();
        }

        textView.setText(String.valueOf(total_price));
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTypeface(null, Typeface.ITALIC);
        textView.setText(String.format("$"+"%.2f", total_price));


    }


}
