package com.example.sendemailintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  /*  private TextView txtview1,txtview2,txtview3; */

    private EditText edttext1,edttext2,edttext3;
    private Button btnsend1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  txtview1 = findViewById(R.id.txtview1);
        txtview2 = findViewById(R.id.txtview2);
        txtview3 = findViewById(R.id.txtview3); */

        edttext1 = findViewById(R.id.edttext1);
        edttext2 = findViewById(R.id.edttext2);
        edttext3 = findViewById(R.id.edttext3);

        btnsend1 = findViewById(R.id.btnsend);

        btnsend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

    }

    private void sendData() {

        String to = edttext1.getText().toString();
        String sub = edttext2.getText().toString();
        String msg = edttext3.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);

        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, sub);
        email.putExtra(Intent.EXTRA_TEXT, msg);

        //need this to prompts email client only

        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email,":"));

    }
}
