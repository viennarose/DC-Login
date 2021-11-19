package com.vienna.rentacar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.vienna.rentacar.R;
import com.vienna.rentacar.pojos.Rents;

import org.w3c.dom.Text;

import java.util.List;

public class RentsAdapter extends RecyclerView.Adapter<RentsAdapter.ViewHolder>
{
    public List<Rents> rentsList;
    public Context context;

    public RentsAdapter(List<Rents> rentsList, Context context) {
        this.rentsList = rentsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rents_recyclerview_layout, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RentsAdapter.ViewHolder holder, int position) {
        Rents rents = rentsList.get(position);

        holder.carType.setText(rents.getCarType());
        holder.customerName.setText(rents.getCarType());
        holder.dateRented.setText(rents.getCarType());
        holder.dateReturned.setText(rents.getCarType());
        holder.rentAmount.setText(rents.getCarType());
        holder.amountPaid.setText(rents.getCarType());
        holder.rent.setText(rents.getCarType());

    }

    @Override
    public int getItemCount() {

        return rentsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView carType, customerName, dateRented, dateReturned, rentAmount, amountPaid;
        private MaterialButton rent;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            carType = itemView.findViewById(R.id.carType);
            customerName = itemView.findViewById(R.id.customerName);
            dateRented = itemView.findViewById(R.id.dateRented);
            dateReturned = itemView.findViewById(R.id.dateReturned);
            rentAmount = itemView.findViewById(R.id.rentAmount);
            amountPaid = itemView.findViewById(R.id.amountPaid);
            rent = itemView.findViewById(R.id.rentBtn);
        }
    }
}
