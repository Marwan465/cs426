package com.example.sec_lab;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class To_Do_Adapter extends RecyclerView.Adapter<To_Do_Adapter.ViewHolder> {
    Context contxt;
    int res = R.layout.row;

    List<To_Do> items;


    public To_Do_Adapter(Context contxt, int res, List<To_Do> items) {
        this.contxt = contxt;
        this.res = res;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        String txt = items.get(position).getName();
        String desc = items.get(position).getDesc();
        int ic = items.get(position).getIconIndex();
        holder.txt.setText(txt);
        holder.desc.setText(desc);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView img;
        TextView txt, desc;
        int pos;

        //ArrayList<Integer> DeletedItems=new ArrayList<>();
        ViewHolder(View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setLongClickable(true);
            itemView.setOnLongClickListener(this);
            img = (ImageView) itemView.findViewById(R.id.imageView2);
            txt = (TextView) itemView.findViewById(R.id.textView);
            desc = (TextView) itemView.findViewById(R.id.textView1);
        }

        @Override
        public void onClick(View v) {
            pos = getAdapterPosition();

            Intent nex = new Intent(contxt.getApplicationContext(), SecondActivity.class);
            nex.putExtra("key", items.get(pos));

            //nex.putIntegerArrayListExtra("Del", DeletedItems);
            contxt.startActivity(nex);


        }


        @Override
        public boolean onLongClick(View v) {
            pos = getAdapterPosition();
            AlertDialog.Builder alert = new AlertDialog.Builder(contxt);
            alert.setTitle("DELETE");
            alert.setMessage("Are you sure to delete this item?");
            alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //DeletedItems.add(pos);
                    items.remove(pos);
                    notifyItemRemoved(pos);
                    notifyItemRangeChanged(pos, items.size());

                    //itemView.setVisibility(View.GONE);
                    dialog.dismiss();

                }
            });
            alert.show();
            return true;
        }
    }

}

