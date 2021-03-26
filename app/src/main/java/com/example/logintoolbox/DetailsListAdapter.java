package com.example.logintoolbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailsListAdapter extends ArrayAdapter<Details>
{
    private Context mContext;
    private int mResource;

    /**
     * Default constructor for the DetailsListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public DetailsListAdapter(Context context, int resource, ArrayList<Details> objects)
    {
        super(context, resource, objects);
        mContext = context;// this , or where we are from ( this)
        mResource = resource; // List view Actitvity

    }
    private static class ViewHolder {// are the objects on the view - so the actully textboxs
        TextView name;
        TextView password;
        TextView message;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the detail information
        String name = getItem(position).getStrName();
        String Password = getItem(position).getStrPassword();
        String Message = getItem(position).getStrWelcomeMessage();

        //Create the detail object with the information
        Details dets = new Details(name,Password,Message);
        //ViewHolder object
        ViewHolder holder;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        holder= new ViewHolder();
        holder.name = (TextView) convertView.findViewById(R.id.txtName);
        holder.password = (TextView) convertView.findViewById(R.id.txtPassword);
        holder.message = (TextView) convertView.findViewById(R.id.txtWelcomeMessage);
        convertView.setTag(holder);

        holder.name.setText(dets.getStrName());
        holder.password.setText(dets.getStrPassword());
        holder.message.setText(dets.getStrWelcomeMessage());
        return convertView;
    }
}
