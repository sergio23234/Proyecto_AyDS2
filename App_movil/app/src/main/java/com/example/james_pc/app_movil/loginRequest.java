package com.example.james_pc.app_movil;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class loginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL="http://192.168.0.29/Login.php";
    private Map<String, String> params;
    public loginRequest(String usuario, String password, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params=new HashMap<>();
        params.put("usuario",usuario);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() { return params; }
}
