package com.autorost.myfavoritecar.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.autorost.myfavoritecar.R;
import com.autorost.myfavoritecar.entity.Invoice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Adapter extends ArrayAdapter<Invoice> {
    private Context context;

    public Adapter(Context context, int resourceId, List<Invoice> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Invoice invoice = getItem(position);
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.itemImageView = (ImageView) convertView.findViewById(R.id.itemImageView);
            holder.itemTextViewDate = (TextView) convertView.findViewById(R.id.itemTextViewDate);
            holder.itemTextViewServices = (TextView) convertView.findViewById(R.id.itemTextViewServices);
            holder.itemTextViewSumInvoice = (TextView) convertView.findViewById(R.id.itemTextViewSumInvoice);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        switch (invoice.getServices()) {
            case "FILLING": {
                holder.itemImageView.setImageResource(R.drawable.ic_filling);
                break;
            }
            case "WASHING": {
                holder.itemImageView.setImageResource(R.drawable.ic_washing);
                break;
            }
            case "TIRE": {
                holder.itemImageView.setImageResource(R.drawable.ic_tire);
                break;
            }
            case "BUYPARTS": {
                holder.itemImageView.setImageResource(R.drawable.ic_buyparts);
                break;
            }
            case "REPAIR": {
                holder.itemImageView.setImageResource(R.drawable.ic_repair);
                break;
            }
        }


        invoice.getDateInvoice().get(Calendar.MONTH);

        holder.itemTextViewDate.setText("" + invoice.getDateInvoice().get(Calendar.DAY_OF_MONTH)
                + "/" + invoice.getDateInvoice().get(Calendar.MONTH) + "/" + invoice.getDateInvoice().get(Calendar.YEAR));
        holder.itemTextViewServices.setText(invoice.getServices());
        holder.itemTextViewSumInvoice.setText("" + invoice.getSumInvoice());

        return convertView;
    }


    private class ViewHolder {

        ImageView itemImageView;
        TextView itemTextViewDate;
        TextView itemTextViewServices;
        TextView itemTextViewSumInvoice;

    }

}

