package Johan_SQLITE.SI61.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TambahActivity extends AppCompatActivity {
    private EditText etNpm, etNama, etProdi;
    private Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNpm = findViewById(R.id.et_npm);
        etNama = findViewById(R.id.et_nama);
        etProdi = findViewById(R.id.et_prodi);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Npm, Nama, Prodi;

                Npm = etNama.getText().toString();
                Nama = etNama.getText().toString();
                Prodi = etProdi.getText().toString();

                if(Npm.trim().equals("")){
                    etNpm.setError("Npm Tidak Boleh Kosong");
                }
                else if(Nama.trim().equals("")){
                    etNama.setError("Nama Tidak Boleh Kosong");
                }
                else if(Prodi.trim().equals("")){
                    etProdi.setError("Prodi Tidak Boleh Kosong");
                }
                else{
                    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);
                    long eks = myDB.tambahData(Npm, Nama, Prodi);

                    if(eks == -1){
                        Toast.makeText(TambahActivity.this, "Tambah Data Gagal!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(TambahActivity.this, "Tambah Data Sukses!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}