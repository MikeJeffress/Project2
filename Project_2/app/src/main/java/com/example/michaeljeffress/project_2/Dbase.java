package com.example.michaeljeffress.project_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by michaeljeffress on 7/10/16.
 */

public class Dbase extends SQLiteOpenHelper {
    private static final String NAME = "wine_db";
    private static final int DATABASE_VERSION = 8;
    public static final String WINE_LIST_TABLE_NAME = "WINE_LIST";
    public static final String SHOPPING_CART_LIST_TABLE_NAME = "SHOPPING_CART_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "NAME";
    public static final String COL_ITEM_PRICE = "PRICE";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ITEM_RATING = "RATING";
    public static final String COL_ITEM_IMAGE = "IMAGE";
    public static final String COL_ITEM_TYPE = "TYPE";
    public static final String COL_ITEM_REGION = "REGION";

    public static final String COL_ITEM_QUANTITY = "QUANTITY";

    private static Dbase instance;



    public static final String[] WINE_COLUMNS = {
            COL_ID,
            COL_ITEM_NAME,
            COL_ITEM_DESCRIPTION,
            COL_ITEM_PRICE,
            COL_ITEM_RATING,
            COL_ITEM_IMAGE,
            COL_ITEM_TYPE,
            COL_ITEM_REGION
    };

    private static final String CREATE_WINE_LIST_TABLE =
            "CREATE TABLE " + WINE_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT, " +
                    COL_ITEM_DESCRIPTION + " TEXT, " +
                    COL_ITEM_PRICE + " DOUBLE, " +
                    COL_ITEM_RATING + " INTEGER, " +
                    COL_ITEM_IMAGE + " TEXT, " +
                    COL_ITEM_TYPE + " TEXT, " +
                    COL_ITEM_REGION + " TEXT )";

    private static final String CREATE_SHOPPING_CART_LIST_TABLE =
            "CREATE TABLE " + SHOPPING_CART_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY, " +
                    COL_ITEM_QUANTITY + " INTEGER )";


    public Dbase(Context context) {
        super(context, NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(CREATE_WINE_LIST_TABLE);
        db.execSQL(CREATE_SHOPPING_CART_LIST_TABLE);

        addWine(db, "Romanee-Conti", "Critics have rated this as the best available among French wines: the 2013 vintage was given a score of 96 by The Wine Advocate and the 2013 vintage was given a score of 19/20 by Jancis Robinson.", 13253.99, 5, "http://sr3.wine-searcher.net/images/labels/79/21/domaine-de-la-romanee-conti-romanee-conti-grand-cru-cote-de-nuits-france-10607921.jpg", "Red", "France");
        addWine(db, "Montrachet Grand Cru", "Critics have scored this as one of the top 5 Puligny-Montrachet wines: The Wine Advocate gave the 2013 vintage a score of 98 and Jancis Robinson gave the 2010 vintage a score of 19/20.", 5879.99, 5, "http://sr3.wine-searcher.net/images/labels/05/82/domaine-leflaive-montrachet-grand-cru-cote-de-beaune-france-10580582.jpg", "White", "France");
        addWine(db, "Musigny Grand Cru", "Critics have scored this as one of the top 5 Chambolle-Musigny wines: The Wine Advocate gave the 2012 vintage a score of 99 and Jancis Robinson gave the 2013 vintage a score of 19/20.", 5389.99, 5, "http://sr3.wine-searcher.net/images/labels/17/02/domaine-leroy-musigny-grand-cru-cote-de-nuits-france-10151702.jpg", "Red", "France");
        addWine(db, "Joh. Jos. Prum", "Critics have scored this as one of the top 5 Wehlen wines: Jancis Robinson gave the 1959 vintage a score of 20/20; and Wine Spectator gave the 1971 vintage a score of 99.", 4811.01, 5, "http://sr3.wine-searcher.net/images/labels/13/71/joh-jos-prum-wehlener-sonnenuhr-riesling-trockenbeerenauslese-mosel-germany-10641371.jpg", "White", "Germany");
        addWine(db, "Screaming Eagle", "Critics have scored this as one of the top 5 Napa Valley wines: The Wine Advocate gave the 2013 vintage a score of 97 and Jancis Robinson gave the 2006 vintage a score of 19/20.", 2889.99, 5, "http://sr3.wine-searcher.net/images/labels/90/78/screaming-eagle-cabernet-sauvignon-napa-valley-usa-10399078.jpg", "Red", "Napa");
        addWine(db, "Corton-Charlemagne", "This is the second most highly rated Cote de Beaune wine (based on critic scores): the 2012 vintage was given a score of 97 by The Wine Advocate and the 2012 vintage was given a score of 19/20 by Jancis Robinson.", 2824.99, 5, "http://sr3.wine-searcher.net/images/labels/22/28/coche-dury-corton-charlemagne-grand-cru-cote-de-beaune-france-10462228.jpg", "White", "France");
        addWine(db, "Petrus", "Critics have scored this as one of the top 5 Napa Valley wines: The Wine Advocate gave the 2013 vintage a score of 97 and Jancis Robinson gave the 2006 vintage a score of 19/20.", 2660.99, 5, "http://sr3.wine-searcher.net/images/labels/56/38/petrus-pomerol-france-10115638.jpg", "Red", "France");
        addWine(db, "Kaiken Reserva", "The wines have tremendous structure, complexity, and a long finish. They have persistent tannins that are both firm and rounded. The wines are known for their minerality, fresh fruit, elegance, and sensuousness.", 10.99, 4, "http://sr3.wine-searcher.net/images/labels/16/21/kaiken-reserva-malbec-mendoza-argentina-10681621.jpg", "Red", "Argentina");
        addWine(db, "Muruve", "The palate is complex, rich and very expressive displaying notes of roasted spiced black cherries. There’s a lingering spicy mineral finish.", 10.99, 4, "http://sr3.wine-searcher.net/images/labels/06/36/bodegas-frutos-villar-muruve-crianza-toro-spain-10540636.jpg", "Red", "Spain");
        addWine(db, "Black Box", "Black Box, which produces vintage Merlot, Cabernet Sauvignon, Shiraz and Pinot Grigio, claims that once opened, its wines will remain fresh for more than a month. The Chardonnay shows off aromas of pineapple, citrus blossom and sugar cookie, mixing with crisp flavors of juicy lemon, apple and sweet oak.", 21.99, 3, "http://www.gayot.com/images/wine/boxwine/black-box.jpg", "White", "Monterey");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + WINE_LIST_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SHOPPING_CART_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    public long addWine(SQLiteDatabase db, String name, String description, Double price, Integer rating, String image, String type, String region){
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_NAME, name);
        values.put(COL_ITEM_DESCRIPTION, description);
        values.put(COL_ITEM_PRICE, price);
        values.put(COL_ITEM_RATING, rating);
        values.put(COL_ITEM_IMAGE, image);
        values.put(COL_ITEM_TYPE, type);
        values.put(COL_ITEM_REGION, region);

        long returnId = db.insert(WINE_LIST_TABLE_NAME, null, values);
        return returnId;
    }

    public List<Wine> getWine() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(WINE_LIST_TABLE_NAME, // a. table
                WINE_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        cursor.moveToFirst();

        ArrayList<Wine> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            list.add(new Wine(
                    cursor.getInt(cursor.getColumnIndex(COL_ID)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION)),
                    cursor.getDouble(cursor.getColumnIndex(COL_ITEM_PRICE)),
                    cursor.getInt(cursor.getColumnIndex(COL_ITEM_RATING)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_IMAGE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_TYPE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_REGION))

            ));
            cursor.moveToNext();
        }
        return list;
    }

    public Wine getWineById (int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(WINE_LIST_TABLE_NAME, // a. table
                WINE_COLUMNS, // b. column names
                COL_ID + " = ?", // c. selections
                new String[] {String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                "1"); // h. limit

        cursor.moveToFirst();

        Wine item = null;
        if (!cursor.isAfterLast()) {
            item = new Wine(
                    cursor.getInt(cursor.getColumnIndex(COL_ID)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION)),
                    cursor.getDouble(cursor.getColumnIndex(COL_ITEM_PRICE)),
                    cursor.getInt(cursor.getColumnIndex(COL_ITEM_RATING)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_IMAGE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_TYPE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_REGION))
            );
        }
        return item;
    }

    public static Dbase getInstance(Context context) {
        if (instance == null){
            instance = new Dbase(context);
        }
        return instance;
    }

    public long addWineToCart (int id) {
        ContentValues values = new ContentValues();
        values.put(COL_ID, id);

        SQLiteDatabase db = getWritableDatabase();
        long returnId = db.insert(SHOPPING_CART_LIST_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }

    public List<Wine> getWineInCart (){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(WINE_LIST_TABLE_NAME, // a. table
                WINE_COLUMNS, // b. column names
                COL_ID + " IN (SELECT " + COL_ID + " FROM " + SHOPPING_CART_LIST_TABLE_NAME + ")", // c. selections --- see if there is another way = Join  ******
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        cursor.moveToFirst();

        ArrayList<Wine> shoppingList = new ArrayList<>();

        while (!cursor.isAfterLast()) {
            shoppingList.add(new Wine(
                    cursor.getInt(cursor.getColumnIndex(COL_ID)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION)),
                    cursor.getDouble(cursor.getColumnIndex(COL_ITEM_PRICE)),
                    cursor.getInt(cursor.getColumnIndex(COL_ITEM_RATING)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_IMAGE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_TYPE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_REGION))
            ));
            cursor.moveToNext();
        }
        return shoppingList;
    }

    public boolean isWineInCart (int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(SHOPPING_CART_LIST_TABLE_NAME, // a. table
                new String[] {COL_ID} , // b. column names
                COL_ID + " = ? ", // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        boolean isInCart = cursor.getCount() == 1;
        cursor.close();
        db.close();
        return isInCart;
    }

    public void deleteWineFromCart(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COL_ID + " = ?";
        String[] selectionArgs = new String[] {String.valueOf(id)};
        db.delete(SHOPPING_CART_LIST_TABLE_NAME, selection, selectionArgs );

    }

    public ArrayList searchWineList(String query){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(WINE_LIST_TABLE_NAME, // a. table
                WINE_COLUMNS, // b. column names
                COL_ITEM_NAME + " LIKE ? OR " + COL_ITEM_REGION +  " LIKE ? OR " + COL_ITEM_TYPE +  " LIKE ? ", // c. selections
                new String[]{"%"+query+"%", "%"+query+"%", "%"+query+"%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        cursor.moveToFirst();

        ArrayList<Wine> searchList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            searchList.add(new Wine(
                    cursor.getInt(cursor.getColumnIndex(COL_ID)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION)),
                    cursor.getDouble(cursor.getColumnIndex(COL_ITEM_PRICE)),
                    cursor.getInt(cursor.getColumnIndex(COL_ITEM_RATING)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_IMAGE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_TYPE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_REGION))

            ));
            cursor.moveToNext();
        }
        return searchList;
    }
}


