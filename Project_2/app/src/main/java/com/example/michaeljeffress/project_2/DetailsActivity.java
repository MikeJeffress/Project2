package com.example.michaeljeffress.project_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by michaeljeffress on 7/8/16.
 */
public class DetailsActivity extends AppCompatActivity {
    public static final String ITEM_ID = "ITEM_ID";
    private Wine item;
    private TextView textViewName;
    private TextView textViewDescription;
    private TextView textViewRegion;
    private TextView textViewType;
    private TextView textViewPrice;
    private RatingBar ratingBar;
    private ImageButton shoppingCart;
    private Button buttonBack;
    private Button buttonBuy;
    private ImageView imageViewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);


        item = Dbase.getInstance(this).getWineById(getIntent().getIntExtra(ITEM_ID, -1));
        if(item == null){
            throw new RuntimeException("Error: Invalid ID in Intent");
        }

        imageViewImage = (ImageView)findViewById(R.id.imageView);
        textViewName = (TextView)findViewById(R.id.textview_name);
        textViewDescription = (TextView)findViewById(R.id.textview_description);
        textViewRegion = (TextView)findViewById(R.id.textView_region);
        textViewType = (TextView)findViewById(R.id.textview_type);
        textViewPrice = (TextView)findViewById(R.id.textView_price_details);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        shoppingCart = (ImageButton) findViewById(R.id.button_shopping);
        buttonBack = (Button)findViewById(R.id.button_back);
        buttonBuy = (Button)findViewById(R.id.button_buy);

        Picasso.with(this).load(item.getImage()).into(imageViewImage);

        textViewName.setText(item.getName());
        textViewDescription.setText(item.getDescription());
        textViewType.setText(item.getType());
        textViewRegion.setText(item.getRegion());
        textViewPrice.setText("$" + String.valueOf(item.getPrice()));
        ratingBar.setRating(item.getRating());

        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });


        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Dbase.getInstance(DetailsActivity.this).isWineInCart(item.getId())){
                    Dbase.getInstance(DetailsActivity.this).addWineToCart(item.getId());
                }
                Intent intent = new Intent(DetailsActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

    }

}
