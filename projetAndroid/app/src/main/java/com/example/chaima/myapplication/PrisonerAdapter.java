package com.example.chaima.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class PrisonerAdapter extends ArrayAdapter<PrisonerContent.PrisonerItem> {

    Context context;
    int layoutResourceId;
    List<Prisoner> prisoners = null;

    private int resourceId = 0;
    private LayoutInflater inflater;
    public Context mContext;

    public PrisonerAdapter(Context context, int resourceId, ArrayList<PrisonerContent.PrisonerItem> mediaItems) {
        super(context, 0, mediaItems);
        this.resourceId = resourceId;
        this.mContext = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //ViewHolder Design Pattern
    static class ViewHolder {
        public TextView textTitle, DescText,adresse;
        public ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        //Réutiliser les Views
        if (rowView == null) {
            rowView = inflater.inflate(resourceId, parent, false);
        }

        //Configuration du ViewHolder
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.image = (ImageView) rowView.findViewById(R.id.thumbnail);
        viewHolder.textTitle = (TextView) rowView.findViewById(R.id.tvName);
        viewHolder.DescText = (TextView) rowView.findViewById(R.id.tvMatricule);
        viewHolder.adresse = (TextView) rowView.findViewById(R.id.tvAddress);

        rowView.setTag(viewHolder);

        //Affecter les données aux Views
        ViewHolder holder = (ViewHolder) rowView.getTag();
        PrisonerContent.PrisonerItem article = getItem(position);

        holder.textTitle.setText(article.name);
        holder.DescText.setText(article.matricule);
        holder.adresse.setText(article.address);

        Picasso.with(mContext).load(article.smallPictureId)
                .into(holder.image);


       viewHolder.image.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {

               Intent details=new Intent(getContext(),PrisonerDetailsFragment.class);

           }
        });

        return rowView;
    }
}