package Johan_SQLITE.SI61.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMahasiswa extends RecyclerView.Adapter<AdapterMahasiswa.ViewHolderDestinasi> {
    private Context ctx;
    private ArrayList arrID,arrNama, arrAlamat, arrJam;

    public AdapterMahasiswa(Context ctx, ArrayList arrID,ArrayList arrNama, ArrayList arrAlamat, ArrayList arrJam) {
        this.ctx = ctx;
        this.arrID = arrID;
        this.arrNama = arrNama;
        this.arrAlamat = arrAlamat;
        this.arrJam = arrJam;
    }

    @NonNull
    @Override
    public ViewHolderMahasiswa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.activity_list_item_mahasiswa, parent, false);
        return new ViewHolderMahasiswa(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDestinasi holder, int position) {
        holder.tvID.setText(arrID.get(position).toString());
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvAlamat.setText(arrAlamat.get(position).toString());
        holder.tvJam.setText(arrJam.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrNama.size();
    }

    public class ViewHolderDestinasi extends RecyclerView.ViewHolder {
        TextView tvID,tvNama, tvAlamat, tvJam;

        public ViewHolderDestinasi(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tv_ID);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvJam = itemView.findViewById(R.id.tv_jam);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder pesan = new AlertDialog.Builder(ctx);
                    pesan.setTitle("Perhatian");
                    pesan.setMessage("Perhatian Apa Yang Akan Dilakukan");
                    pesan.setCancelable(true);


                    pesan.show();
                    return false;
                }
            });

        }
    }
}