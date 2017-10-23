package ajil.com.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by ajilo on 23-10-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "spinnerDb";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createQuery = "CREATE TABLE IF NOT EXISTS graze (id INTEGER PRIMARY KEY, name TEXT)";
        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name","SOAP");
        db.insert("graze", null, values);

        values = new ContentValues();
        values.put("name","Grass");
        db.insert("graze", null, values);

        values = new ContentValues();
        values.put("name","Lemon");
        db.insert("graze", null, values);

        values = new ContentValues();
        values.put("name","Fig");
        db.insert("graze", null, values);

        values = new ContentValues();
        values.put("name","Orange");
        db.insert("graze", null, values);

        db.close();
    }

    public ArrayList<DataModel> getAllData() {
        ArrayList<DataModel> models = new ArrayList<>();
        String query = "SELECT * FROM graze";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DataModel model = new DataModel();
                model.setId(cursor.getInt(0));
                model.setName(cursor.getString(1));
                models.add(model);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return models;
    }

    public void deleteModel (DataModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("graze", "id = ?", new String[]{String.valueOf(model.getId())});
        db.close();
    }

}
