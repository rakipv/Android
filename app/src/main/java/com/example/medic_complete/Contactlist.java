package com.example.medic_complete;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class Contactlist extends AppCompatActivity implements com.example.medic_complete.ContactAdapter.OnEditListener {

    RecyclerView contactList;

    com.example.medic_complete.ContactAdapter contactAdapterList;
    ArrayList<com.example.medic_complete.ContactModelClass> contactModelClassArrayList;
    private EditText userName, userContact;
    private MaterialButton btnAdd;


    AlertDialog alertDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactlist);


        contactModelClassArrayList = new ArrayList<>();

        userContact = findViewById(R.id.userMobile);
        userName = findViewById(R.id.userName);

        btnAdd = findViewById(R.id.btnAdd);


        contactList = findViewById(R.id.contactListId);
        contactList.setHasFixedSize(true);



        contactList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        btnAdd.setOnClickListener(v -> {

            String strUserName = "", strUserContact = "";
            if (userName.getText() != null) {
                strUserName = userName.getText().toString();
            }

            if (strUserName.equals("")) {
                Toast.makeText(this, "Please enter user name", Toast.LENGTH_LONG).show();
                return;
            }

            if (userContact.getText() != null) {
                strUserContact = userContact.getText().toString();
            }
            if (strUserContact.equals("")) {
                Toast.makeText(this, "Please enter your contact number", Toast.LENGTH_LONG).show();
                return;
            }


            addContact(strUserName, strUserContact);
        });


    }


    public void addContact(String strUserName, String strUserContact) {


        com.example.medic_complete.ContactModelClass obj = new com.example.medic_complete.ContactModelClass();

        obj.setUserName(strUserName);
        obj.setUserNumber(strUserContact);


        contactModelClassArrayList.add(obj);



        contactAdapterList = new com.example.medic_complete.ContactAdapter(this, contactModelClassArrayList, this::onEditClick);
        contactList.setAdapter(contactAdapterList);


    }

    @Override
    public void onEditClick(com.example.medic_complete.ContactModelClass listCurrentData, int currentPosition) {


        AlertDialog.Builder builderObj=new AlertDialog.Builder(this);
        View view=LayoutInflater.from(this).inflate(R.layout.layout_edit_cantact,null);

        EditText userNameEtn=view.findViewById(R.id.userName);
        EditText userContactEtn=view.findViewById(R.id.userMobile);
        MaterialButton btnEdit=view.findViewById(R.id.btnEdit);

        userContactEtn.setText(listCurrentData.getUserNumber());
        userNameEtn.setText(listCurrentData.getUserName());

        ImageView closeAlert=view.findViewById(R.id.closeAlert);
        builderObj.setCancelable(false);
        builderObj.setView(view);

        closeAlert.setOnClickListener(v->{
            alertDialog.cancel();
        });

        btnEdit.setOnClickListener(v->{
            String strUserName = "", strUserContact = "";
            if (userNameEtn.getText() != null) {
                strUserName = userNameEtn.getText().toString();
            }

            if (strUserName.equals("")) {
                Toast.makeText(this, "Please enter user name", Toast.LENGTH_LONG).show();
                return;
            }

            if (userContactEtn.getText() != null) {
                strUserContact = userContactEtn.getText().toString();
            }
            if (strUserContact.equals("")) {
                Toast.makeText(this, "Please enter your contact number", Toast.LENGTH_LONG).show();
                return;
            }


            editContact(strUserName, strUserContact,currentPosition);

        });


        alertDialog=builderObj.create();
        alertDialog.show();





    }


    public void editContact(String strUserName, String strUserContact,int currentPosition){


        com.example.medic_complete.ContactModelClass obj = new com.example.medic_complete.ContactModelClass();

        obj.setUserName(strUserName);
        obj.setUserNumber(strUserContact);


        contactAdapterList.editData(obj,currentPosition);
        alertDialog.cancel();

    }


}