package com.example.logintoolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class ImageListAdapter extends ArrayAdapter<DetailsWithImage> {
    final Handler mHandler = new Handler();
    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder
    {
        TextView name;
        TextView password;
        TextView message;
        ImageView image;
    }

    /**
     * Default constructor for the DetailsListAdapter
     *
     * @param context
     * @param resource
     * @param objects
     */
    public ImageListAdapter(Context context, int resource, ArrayList<DetailsWithImage> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the detail image information
        String name = getItem(position).getStrName();
        String Password = getItem(position).getStrPassword();
        String Message = getItem(position).getStrWelcomeMessage();
        String strImage = getItem(position).getbImage();

        //Create the person object with the information
        DetailsWithImage dets = new DetailsWithImage(name, Password, Message,strImage);

        //ViewHolder object
        ImageListAdapter.ViewHolder holder;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        holder = new ImageListAdapter.ViewHolder();
        holder.name = (TextView) convertView.findViewById(R.id.txtName);
        holder.password = (TextView) convertView.findViewById(R.id.txtPassword);
        holder.message = (TextView) convertView.findViewById(R.id.txtWelcomeMessage);
        holder.image = (ImageView) convertView.findViewById(R.id.imageView);
        convertView.setTag(holder);


        lastPosition = position;

        holder.name.setText(dets.getStrName());
        holder.password.setText(dets.getStrPassword());
        holder.message.setText(dets.getStrWelcomeMessage());

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    Bitmap temp= getBitmapFromURL(dets.getbImage());
                    mHandler.post(new Runnable() {
                        public void run() {
                            holder.image.setImageBitmap(temp);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();



        return convertView;
    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
