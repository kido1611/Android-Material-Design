package id.kido1611.androidmaterialdesign.model;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import id.kido1611.androidmaterialdesign.R;

/**
 * Created by Kido1611 on 22-Apr-16.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder>{

    List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    int selection_position = 0;

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());

        if(current.isSeparator()){
            holder.separator.setVisibility(View.VISIBLE);
            holder.title.setVisibility(View.GONE);
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }else{
            holder.separator.setVisibility(View.GONE);
            holder.title.setVisibility(View.VISIBLE);
            if(selection_position==position){
                holder.itemView.setBackgroundResource(R.color.colorPrimary);
                holder.title.setTextColor(context.getResources().getColor(R.color.textColorPrimary));
            }else{
                holder.itemView.setBackgroundColor(Color.TRANSPARENT);
                holder.title.setTextColor(Color.BLACK);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    notifyItemChanged(selection_position);
                    selection_position = position;
                    notifyItemChanged(selection_position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        View separator;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            separator = itemView.findViewById(R.id.separator);
        }
    }
}
