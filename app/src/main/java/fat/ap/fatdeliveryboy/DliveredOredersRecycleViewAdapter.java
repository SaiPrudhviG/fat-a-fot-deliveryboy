package fat.ap.fatdeliveryboy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;

public class DliveredOredersRecycleViewAdapter extends RecyclerView.Adapter<DliveredOredersRecycleViewAdapter.MyViewHolder>{
    public JSONArray myValues;
    public DliveredOredersRecycleViewAdapter (JSONArray myValues){
        this.myValues= myValues;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliveredcard, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        try {
            holder.shop_name.setText(myValues.getJSONObject(position).getJSONObject("shopkeeper").getString("name"));
            holder.shop_mobile.setText(myValues.getJSONObject(position).getJSONObject("shopkeeper").getString("mobile"));
            holder.shop_address.setText(myValues.getJSONObject(position).getJSONObject("shopkeeper").getString("address"));
            holder.user_name.setText(myValues.getJSONObject(position).getString("name"));
            holder.user_mobile.setText(myValues.getJSONObject(position).getString("mobile"));
            holder.user_address.setText(myValues.getJSONObject(position).getJSONObject("user").getString("address"));
            holder.order_id.setText(myValues.getJSONObject(position).getString("orderid"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return myValues.length();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView shop_name,user_name, order_id , user_mobile,user_address,shop_mobile,shop_address;
        public MyViewHolder(View itemView) {
            super(itemView);
            shop_name = (TextView)itemView.findViewById(R.id.shop_name);
            user_name = (TextView)itemView.findViewById(R.id.user_name);
            order_id = (TextView)itemView.findViewById(R.id.order_id);
            user_mobile = (TextView)itemView.findViewById(R.id.user_mobile);
            user_address = (TextView)itemView.findViewById(R.id.user_address);
            shop_address = (TextView)itemView.findViewById(R.id.shop_address);
            shop_mobile = (TextView)itemView.findViewById(R.id.shop_mobile);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Fragment newFragment = new OrderDetailsFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("id",order_id.getText().toString());
                        newFragment.setArguments(bundle);

                        AppCompatActivity activity1 = (AppCompatActivity) v.getContext();
                        activity1.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, newFragment).addToBackStack(null).commit();
                    }
                }
            });

        }
    }
}

