package mobile.umn.mobileapp.adapter;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mobile.umn.mobileapp.HomeActivity;
import mobile.umn.mobileapp.R;
import mobile.umn.mobileapp.model.RequestHeader;

/**
 * Created by User on 24/05/2018.
 */

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder>{
    private ArrayList<RequestHeader> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView request_id;
        public TextView request_type;
        public TextView request_name;
        public TextView request_date;
        public TextView request_total;
        public ViewHolder(CardView v) {
            super(v);
            request_id = (TextView)v.findViewById(R.id.text_request_id);
            request_type = (TextView)v.findViewById(R.id.text_request_type);
            request_name = (TextView)v.findViewById(R.id.text_request_name);
            request_date = (TextView)v.findViewById(R.id.text_request_date);
            request_total = (TextView)v.findViewById(R.id.text_request_total);
            v.findViewById(R.id.button_approve).setOnClickListener((view)->{
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            });
        }
    }

    public HomeListAdapter(ArrayList<RequestHeader> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HomeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        CardView v = (CardView)LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_home, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.request_id.setText(mDataset.get(position).getRequest_header_id());
        holder.request_name.setText(mDataset.get(position).getName());
        holder.request_type.setText(mDataset.get(position).getType());
        holder.request_total.setText(mDataset.get(position).getTotal());
        holder.request_date.setText(mDataset.get(position).getDate());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
