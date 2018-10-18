package zyf.msi.com.hellonotes;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectAct extends Activity implements View.OnClickListener{
    private Button s_delete,s_back;
    private TextView s_tv;
    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);
        s_delete = findViewById(R.id.s_delete);
        s_back = findViewById(R.id.s_back);
        s_tv = findViewById(R.id.s_tv);
        notesDB = new NotesDB(this);
        dbWriter = notesDB.getWritableDatabase();
        s_delete.setOnClickListener(this);
        s_back.setOnClickListener(this);
        s_tv.setText(getIntent().getStringExtra(NotesDB.CONTENT));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.s_delete:
                deleteData();
                finish();
                break;
            case R.id.s_back:
                finish();
                break;
        }
    }
    public void deleteData() {
        dbWriter.delete(NotesDB.TABLE_NAME,
                "_id="+getIntent().getIntExtra(NotesDB.ID,0),null);
    }
}
