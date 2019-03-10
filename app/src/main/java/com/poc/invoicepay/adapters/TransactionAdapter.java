package com.poc.invoicepay.adapters;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poc.invoicepay.R;
import com.poc.invoicepay.ui.ViewInvoiceActivity;
import com.poc.invoicepay.models.Transaction;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    private List<Transaction> transactionList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, reference, amount, invoiceLink;

        public MyViewHolder(View view) {
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            reference = (TextView) view.findViewById(R.id.reference);
            amount = (TextView) view.findViewById(R.id.amount);
            invoiceLink = (TextView) view.findViewById(R.id.invoiceLink);
            invoiceLink.setPaintFlags(invoiceLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            invoiceLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent viewInvoiceIntent = new Intent(context, ViewInvoiceActivity.class);
                    context.startActivity(viewInvoiceIntent);
                }
            });
        }
    }


    public TransactionAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_list_row, parent, false);
        context = parent.getContext();
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Transaction transaction = transactionList.get(position);
        holder.date.setText(transaction.getDate());
        holder.amount.setText(transaction.getAmount());
        holder.reference.setText(transaction.getReference());
        holder.invoiceLink.setText((transaction.getInvoiceLink()));
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }
}
