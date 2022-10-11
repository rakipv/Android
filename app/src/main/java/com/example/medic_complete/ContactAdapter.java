package com.example.medic_complete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder>{
    private ArrayList<com.example.medic_complete.ContactModelClass> listData;
    private Context context;
    private OnEditListener onEditListener;

    public ContactAdapter(Context context, ArrayList<com.example.medic_complete.ContactModelClass> list, OnEditListener onEditListener){
        this.listData=list;
        this.context=context;
        this.onEditListener=onEditListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_contact_list_layout,parent,false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        com.example.medic_complete.ContactModelClass dataObj=listData.get(position);


        holder.nameTxt.setText(dataObj.getUserName());
        holder.numberTxt.setText(dataObj.getUserNumber());
        holder.imgDelete.setOnClickListener(v->{
            listData.remove(position);
            notifyDataSetChanged();

        });
        holder.imgEdit.setOnClickListener(v->{
            onEditListener.onEditClick(listData.get(position),position);
        });


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        TextView nameTxt,numberTxt;
        ImageView imgEdit,imgDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTxt=itemView.findViewById(R.id.nameTxtId);
            imgEdit=itemView.findViewById(R.id.imgEdit);
            imgDelete=itemView.findViewById(R.id.imgDelete);
            numberTxt=itemView.findViewById(R.id.numberTxtId);

        }
    }



    public void editData(com.example.medic_complete.ContactModelClass listDataObj, int currentPosition){

        listData.get(currentPosition).setUserNumber(listDataObj.getUserNumber());
        listData.get(currentPosition).setUserName(listDataObj.getUserName());
        notifyDataSetChanged();


    }

    public interface OnEditListener{

        void onEditClick(com.example.medic_complete.ContactModelClass listCurrentData, int CurrentPosition);

    }
}
