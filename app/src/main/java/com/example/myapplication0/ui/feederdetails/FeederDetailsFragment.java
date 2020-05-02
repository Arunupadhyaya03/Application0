package com.example.myapplication0.ui.feederdetails;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication0.BackgroundWorker;
import com.example.myapplication0.R;

import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;

public class FeederDetailsFragment extends Fragment {
    EditText userid,feederno,feedername,conductortype,totallength,dtrno,totalconsumers,connno,meterno,connname;
    Spinner mfeature,conntype;
    Button b1;

    String userid1,feederno1,feedername1,conductortype1,totallen,dtrn,totalconsumers1,connno1,mno,connname1,mfeature1,conntype1;

    //private FeederDetailsViewModel feederdetailsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_feederdetails, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);
        userid = root.findViewById(R.id.userid);
        feederno = root.findViewById(R.id.feederno);
        feedername = root.findViewById(R.id.feedername);
        conductortype = root.findViewById(R.id.typeconductor);
        totallength = root.findViewById(R.id.totallength);
        dtrno = root.findViewById(R.id.nodtrs);
        totalconsumers = root.findViewById(R.id.totalconsumers);
        connno = root.findViewById(R.id.conn_no);
        meterno = root.findViewById(R.id.meter_no);
        connname = root.findViewById(R.id.conn_name);
        mfeature = root.findViewById(R.id.meter_feature);
        conntype = root.findViewById(R.id.conn_type);
        b1 = root.findViewById(R.id.submit);

        mfeature.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //metertype.setSelection(0,true);
                mfeature1=getResources().getStringArray(R.array.meterfeature_array)[position];
                if(position>0){
                    Toast.makeText(getActivity().getApplicationContext(), "You selected  "+mfeature1, Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        conntype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //metertype.setSelection(0,true);
                conntype1=getResources().getStringArray(R.array.metertype_array)[position];
                if(position>0){
                    Toast.makeText(getActivity().getApplicationContext(), "You selected  "+conntype1, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "result gottttt");
                userid1 = userid.getText().toString();
                feederno1 = feederno.getText().toString();
                feedername1 = feedername.getText().toString();
                conductortype1 = conductortype.getText().toString();
                totallen = totallength.getText().toString();
                dtrn = dtrno.getText().toString();
                totalconsumers1 = totalconsumers.getText().toString();
                connno1 = connno.getText().toString();
                mno =  meterno.getText().toString();
                connname1 = connname.getText().toString();

                String res = "";
                try {
                    res = new BackgroundWorker().execute("metval",mno).get();
                    Log.v(TAG, "res......"+res);
                    if(res.equals("success") ) {
                        try {
                            res = new BackgroundWorker().execute("feeder", feederno1, feedername1, conductortype1, totallen, dtrn, totalconsumers1).get();
                            Log.v(TAG, "res......"+res);
                            res = new BackgroundWorker().execute("feeder_meter_map", feederno1, mno,mfeature1,conntype1,connname1).get();
                            res = new BackgroundWorker().execute("feeder_substation_map", feederno1, userid1,connno1).get();
                            if(res.equals("success") ) {
                                Toast.makeText(getActivity().getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getActivity().getApplicationContext(), "Error on submission try again", Toast.LENGTH_SHORT).show();
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                    else{

                        seterror();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }



                Log.v(TAG, "result gottttt");

                Log.v(TAG, "result gottttt");


            }

        });


        return root;
    }
    public void seterror()
    {
        meterno.setError("Invalid Meter Number");
        meterno.requestFocus();
    }
}