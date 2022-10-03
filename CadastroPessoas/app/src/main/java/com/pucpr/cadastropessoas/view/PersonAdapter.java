package com.pucpr.cadastropessoas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pucpr.cadastropessoas.R;
import com.pucpr.cadastropessoas.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonHolder> {

    private List<Person> people;
    private Context context;


    public PersonAdapter(List<Person> people, Context context) {
        this.people = people;
        this.context = context;
    }


    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_people,
                parent,
                false);

        return new PersonHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }


    class PersonHolder extends RecyclerView.ViewHolder {

        LinearLayout layoutPerson;
        TextView textName;
        TextView textBirthDate;


        public PersonHolder(@NonNull View itemView) {
            super(itemView);

            layoutPerson = itemView.findViewById(R.id.layoutPerson);
            textName = itemView.findViewById(R.id.textName);
            textBirthDate = itemView.findViewById(R.id.textBirthDate);
        }
    }
}
