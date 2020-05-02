package com.example.myapplication0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_custom_layout extends AppCompatActivity {

    EditText mno,nmf,osdate,oedate,ctpt,ctr,ptr,nsdate,r;
    Button submit;

    String metern,newmf,oldsdate,oldedate,ctptnumber,ctratio,ptratio,newsdate,reason;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout);

        mno = findViewById(R.id.mno);
        nmf = findViewById(R.id.nmf);
        osdate = findViewById(R.id.osdate);
        oedate = findViewById(R.id.oedate);
        ctpt = findViewById(R.id.ctpt);
        ctr = findViewById(R.id.ctr);
        ptr = findViewById(R.id.ptr);
        nsdate = findViewById(R.id.nsdate);
        r = findViewById(R.id.reason);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                metern = mno.getText().toString();
                newmf = nmf.getText().toString();
                oldsdate = osdate.getText().toString();
                oldedate = oedate.getText().toString();
                ctptnumber = ctpt.getText().toString();
                ctratio = ctr.getText().toString();
                ptratio = ptr.getText().toString();
                newsdate = nsdate.getText().toString();
                reason = r.getText().toString();
            }
        });



    }
}
