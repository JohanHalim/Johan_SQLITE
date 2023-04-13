package Johan_SQLITE.SI61.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMahasiswa extends RecyclerView.Adapter<AdapterMahasiswa.ViewHolderMahasiswa> {
    private Context ctx;
    private ArrayList arrID,arrNpm, arrNama, arrProdi;

    public AdapterMahasiswa(Context ctx, ArrayList arrID,ArrayList arrNpm, ArrayList arrNama, ArrayList arrProdi) {
        this.ctx = ctx;
        this.arrID = arrID;
        this.arrNpm = arrNpm;
        this.arrNama = arrNama;
        this.arrProdi = arrProdi;
    }

    @NonNull
    @Override
    public ViewHolderMahasiswa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.activity_list_item_mahasiswa, parent, false);
        return new ViewHolderMahasiswa(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMahasiswa holder, int position) {
        holder.tvID.setText(arrID.get(position).toString());
        holder.tvNpm.setText(arrNpm.get(position).toString());
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvProdi.setText(arrProdi.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrNpm.size();
    }

    public class ViewHolderMahasiswa extends RecyclerView.ViewHolder {
        TextView tvID,tvNpm, tvNama, tvProdi;

        public ViewHolderMahasiswa(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tv_ID);
            tvNpm = itemView.findViewById(R.id.tv_NPM);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvProdi = itemView.findViewById(R.id.tv_prodi);

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