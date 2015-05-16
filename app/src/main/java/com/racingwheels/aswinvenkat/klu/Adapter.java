package com.racingwheels.aswinvenkat.klu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by aswin venkat on 3/19/2015.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewholder> {

    List<Manager> data = Collections.emptyList();
    private final LayoutInflater inflater;
    private Context context;
    private ClickListner clickListner;

    public Adapter(Context context, List<Manager> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_row, viewGroup, false);
        MyViewholder holder = new MyViewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewholder viewHolder, int position) {
        Manager current = data.get(position);
        viewHolder.title.setText(current.title);
        viewHolder.icon.setImageResource(current.iconId);

    }

    public void setClickListner(ClickListner clickListner) {
        this.clickListner = clickListner;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;

        public MyViewholder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.list_icon);

        }

        @Override
        public void onClick(View v) {

            if (clickListner != null) {
                clickListner.itemClicked(v, getPosition());
            }
        }
    }

    public interface ClickListner {
        public void itemClicked(View view, int position);
    }
}
