package arevalosalazar.cesar.appbasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CrearBD crearBD = new CrearBD(this);
        /*SQLiteDatabase bd = crearBD.getWritableDatabase();

        bd.execSQL("INSERT INTO articulos VALUES(1,'papel');");
        bd.execSQL("INSERT INTO articulos VALUES(2,'lápiz');");
        bd.execSQL("INSERT INTO articulos VALUES(3,'carpeta');");
        bd.execSQL("INSERT INTO articulos VALUES(4,'bolígrafo');");
        bd.execSQL("UPDATE articulos SET nombre = 'papel charol' WHERE ref = 1");
        bd.execSQL("UPDATE articulos SET nombre = 'cinta adhesiva' WHERE nombre='carpeta'");
        bd.execSQL("DELETE FROM articulos WHERE nombre = 'lápiz'");
        bd.close();*/
        SQLiteDatabase bd = crearBD.getReadableDatabase();
        TextView t = findViewById(R.id.tvBase);
        Cursor c = bd.rawQuery("Select * from articulos", null);

        while(c.moveToNext())
        {
            t.append("\n" + c.getString(1));
        }
        bd.close();
    }
}