package com.example.james_pc.app_movil;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class principal extends AppCompatActivity {

    EditText p_usuario, p_password;
    Button btn_login;
    Button btn_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btn_registrar = (Button) findViewById(R.id.btn_registrar);
        btn_login = (Button) findViewById(R.id.bt_login);
        p_usuario = (EditText) findViewById(R.id.p_usuario);
        p_password = (EditText) findViewById(R.id.p_password);

        btn_registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentreg = new Intent(principal.this, Registrar.class);
                principal.this.startActivity(intentreg);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final String usuario = p_usuario.getText().toString();
                final String password = p_password.getText().toString();

                Response.Listener<String> responseLinstener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                String nombre = jsonResponse.getString("nombre");
                                String carnet = jsonResponse.getString("carnet");

                                Intent intent = new Intent(principal.this,Usuario.class);
                                intent.putExtra("nombre",nombre);
                                intent.putExtra("carnet",carnet);

                                principal.this.startActivity(intent);



                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(principal.this);
                                builder.setMessage("Error Login")
                                        .setNegativeButton("Retry",null )
                                        .create().show();

                            }
                        } catch(JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };

                loginRequest loRequest = new loginRequest(usuario,password, responseLinstener);

                RequestQueue queue = Volley.newRequestQueue(principal.this);
                queue.add(loRequest);
            }
        });
    }




}
