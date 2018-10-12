package com.vibrant.disasterrecoverysupport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {
    public static final String TAG = "Signup";
    EditText firstName, lastName, email, password;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firstName = (EditText) findViewById(R.id.signup_first_name);
        lastName = (EditText) findViewById(R.id.signup_last_name);
        email = (EditText) findViewById(R.id.signup_email);
        password = (EditText) findViewById(R.id.signup_password);
        button = (Button) findViewById(R.id.btn_signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestMethod();
            }
        });
        textView = (TextView) findViewById(R.id.link_login);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.getInstance(), Login.class));
                finish();
            }
        });

    }

    public void requestMethod() {
        StringRequest stringRequest = new StringRequest( Request.Method.POST, "https://vibranttech6.000webhostapp.com/phpFiles/signUp.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                clearEditTexts();
                Log.w(TAG, "gvnvhmvjbk" + response );
                Toast.makeText(MainActivity.getInstance(), response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w(TAG, "gvnvhmvjbk" + error);
            }
        })

        {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<String, String>();
                header.put("QuoD", "QuoD");
                return header;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("firstName", firstName.getText().toString());
                params.put("lastName", lastName.getText().toString());
                params.put("email", email.getText().toString());
                params.put("password", password.getText().toString());
                return params;
            }
        };
        MySingleton.getInstance(MainActivity.getInstance()).addToRequestQueue(stringRequest);
    }

    private  void clearEditTexts(){
        firstName.setText("");
         lastName.setText("");
         email.setText("");
         password.setText("");
    }
}
