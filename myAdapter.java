package com.example.kaushik.referhub;

/**
 * Created by Kaushik on 14-Oct-18.
 */

import android.content.Intent;
import android.net.Uri;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class myAdapter extends ArrayAdapter {

    private List<User> users;
    private Context context;

    public myAdapter(@NonNull Context context, List<User> users) {

        super(context, R.layout.list_view);
        this.users = users;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_view, parent, false);

        final User new_user = users.get(position);

        TextView email = (TextView) rowView.findViewById(R.id.email);
        TextView category = (TextView) rowView.findViewById(R.id.category);
        Button link = (Button) rowView.findViewById(R.id.link);

        email.setText(new_user.getEmail());
        category.setText(new_user.getCoupon().getCategory());

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = new_user.getCoupon().getUrl();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);

            }
        });

        return rowView;

    }

    @Override
    public int getCount(){
        return users !=null ? users.size() : 0;
    }

    public void setData(List<User> users){

        this.users = users;

    }

}

