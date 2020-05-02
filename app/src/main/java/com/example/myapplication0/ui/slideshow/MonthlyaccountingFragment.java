package com.example.myapplication0.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.myapplication0.BackgroundWorker;
import com.example.myapplication0.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;

public class MonthlyaccountingFragment extends Fragment {


    ConstraintLayout Layout;
    LinearLayout Layout1;
    TextView meternew, newmf;
    Button button;


    EditText meterno1, mf1, outgoing, meternum;
    ArrayList<Integer> mnoc = new ArrayList<>();
    int count1;
    int count2;
    EditText editText;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    List<EditText> allEds = new ArrayList<EditText>();
    ArrayList<String> inmeter = new ArrayList<>();

    EditText m1,m2,mf_1,mf_2,prevr1,prevr2,presr1,presr2;
    Spinner connectionno;
    ArrayList<Integer> connn = new ArrayList<>();
    //ArrayList<Integer> feedern = new ArrayList<>();
    ArrayAdapter<Integer> adapter;
    ArrayAdapter<Integer> adapter1;

    String connumber;
    int cc;
    String feed;
    String meternumber = "0";
    String metername;
    String mno;
    String inmname;


    private MonthlyaccountingViewModel monthlyaccountingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_monthlyaccounting, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);


    //    m1 = root.findViewById(R.id.m2);
     //   m2 = root.findViewById(R.id.m3);



        Layout = root.findViewById(R.id.MA);
        Layout1 = root.findViewById(R.id.LL);
        button = root.findViewById(R.id.submit);

        meterno1 = root.findViewById(R.id.meterno1);
        mf1 = root.findViewById(R.id.mfnew);
        meternew = (TextView) root.findViewById(R.id.meterchange);
        newmf = (TextView) root.findViewById(R.id.mfchange);
        outgoing = root.findViewById(R.id.out);
        meternum = root.findViewById(R.id.meterno);
        connectionno = root.findViewById(R.id.connection_no);
        Log.v(TAG, "working line 4");
        getdata();

        adapter = new ArrayAdapter<>(this.getActivity(),
                android.R.layout.simple_spinner_dropdown_item, connn);
        //  adapter1 = new ArrayAdapter<>(this.getActivity(),
        //          android.R.layout.simple_spinner_dropdown_item, feedern);
        Log.v(TAG, "working line 5");
        connectionno.setAdapter(adapter);
        Log.v(TAG, "working line 6");


        Log.v(TAG, "result gottttt");
        meterno1.setVisibility(View.GONE);
        Log.v(TAG, "result gottttt");
        mf1.setVisibility(View.GONE);
        meternew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meterno1.setVisibility(View.VISIBLE);
            }
        });

        newmf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mf1.setVisibility(View.VISIBLE);
            }
        });


        connectionno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //metertype.setSelection(0,true);
                connumber = parent.getItemAtPosition(position).toString();
                // connumber=getResources().getStringArray(R.array.conn_array)[position];
                if (position > 0) {
                    Toast.makeText(getActivity().getApplicationContext(), "You selected  " + connumber, Toast.LENGTH_SHORT).show();
                }

                getfedata();
                getmeterdata();
                //getmetername();
                getinmeterno();
              //  button();

                Log.v(TAG, "working line 2");
                Log.v(TAG, "result" + connumber);
                Log.v(TAG, "result" + feed);
                Log.v(TAG, "result" + meternumber);
                Log.v(TAG, "result" + count1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                for(int i=0; i < allEds.size(); i++){
                    inmeter.add(allEds.get(i).getText().toString());
                  //  Log.v(TAG, "result" + string1[i]);
                }
                Log.v(TAG, "Incoming Meter Name" + inmeter);
            }

        });


        return root;
    }

    private void getdata() {
        String res = "";
        try {
            res = new BackgroundWorker().execute("connfe").get();
            Log.v(TAG, "res      .." + res);
            JSONObject connr = new JSONObject(res);
            JSONArray connarray = connr.getJSONArray("result");

            for (int i = 0; i < connarray.length(); i++) {
                JSONObject conn = connarray.getJSONObject(i);
                // String Meter=(subdivdata.getString("Meter"));
                //String conn_no = (conn.getString("conn_no"));

                connn.add(conn.getInt("conn_no"));
                Log.v(TAG, "working line 1");

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void getfedata() {
        String res1 = "";
        try {
            res1 = new BackgroundWorker().execute("feederconn", connumber).get();
            Log.v(TAG, "res      .." + res1);
            JSONObject feer = new JSONObject(res1);
            JSONArray feederarray = feer.getJSONArray("result");

            for (int i = 0; i < feederarray.length(); i++) {
                JSONObject feeder = feederarray.getJSONObject(i);
                // String Meter=(subdivdata.getString("Meter"));
                //String conn_no = (conn.getString("conn_no"));

                // feedern.add(feeder.getInt("feeder_no"));
                feed = (feeder.getString("feeder_no"));

                Log.v(TAG, "working line 1");

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getmeterdata() {
        String res1 = "";
        try {
            res1 = new BackgroundWorker().execute("meterconn", feed).get();
            Log.v(TAG, "res      .." + res1);
            JSONObject me = new JSONObject(res1);
            JSONArray meterarray = me.getJSONArray("result");

            for (int i = 0; i < meterarray.length(); i++) {
                JSONObject meter = meterarray.getJSONObject(i);
                // String Meter=(subdivdata.getString("Meter"));
                //String conn_no = (conn.getString("conn_no"));

                // feedern.add(feeder.getInt("feeder_no"));
                meternumber = (meter.getString("meter_no"));
                meternum.setText(meternumber);
                Log.v(TAG, "working line 1");
getmetername();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void getmetername() {
        String res1 = "";
        try {
            res1 = new BackgroundWorker().execute("mname", meternumber).get();
            Log.v(TAG, "res      .." + res1);
            JSONObject me = new JSONObject(res1);
            JSONArray meterarray = me.getJSONArray("result");

            for (int i = 0; i < meterarray.length(); i++) {
                JSONObject meter = meterarray.getJSONObject(i);
                // String Meter=(subdivdata.getString("Meter"));
                //String conn_no = (conn.getString("conn_no"));

                // feedern.add(feeder.getInt("feeder_no"));
                metername = (meter.getString("meter_name"));
                outgoing.setText(metername);
                Log.v(TAG, "working line 1");

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void getinmeterno() {
        String res2 = "";
        try {
            res2 = new BackgroundWorker().execute("meterconn2", feed).get();
            Log.v(TAG, "res      .." + res2);
            JSONObject mo = new JSONObject(res2);
            JSONArray marray = mo.getJSONArray("result");

            for (int i = 0; i < marray.length(); i++) {
                JSONObject m1 = marray.getJSONObject(i);
                // String Meter=(subdivdata.getString("Meter"));
                //String conn_no = (conn.getString("conn_no"));

                // feedern.add(feeder.getInt("feeder_no"));
                mnoc.add(m1.getInt("meter_no"));
             //   outgoing.setText(metername);




            }
            count1 = mnoc.size();
            //count2 = count1/2;
            Log.v(TAG, "mnoc count" + count1);

            for(int i=0;i<count1;i++)
            {
                editText = new EditText(getActivity().getApplicationContext());
                editText.setHint("DSS/Online Tee");
                allEds.add(editText);
               // editText.setTextAppearance(getActivity(), R.style.style);
                Layout1.addView(editText);

                editText1 = new EditText(getActivity().getApplicationContext());
                editText1.setHint("Meter Number");
               // editText1.setTextAppearance(getActivity(), R.style.style);
                Layout1.addView(editText1);

                editText2 = new EditText(getActivity().getApplicationContext());
                editText2.setHint("Previous Reading");
               // editText2.setTextAppearance(getActivity(), R.style.style);
                Layout1.addView(editText2);

                editText3 = new EditText(getActivity().getApplicationContext());
                editText3.setHint("Present Reading");
               // editText3.setTextAppearance(getActivity(), R.style.style);
                Layout1.addView(editText3);
            }



        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    /* private void button() {
        Button submit = new Button(getActivity());
        submit.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        submit.setText("SUBMIT");


        submit.setTag("button1");

        //add button to the layout
        Layout1.addView(submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                for(int i=0; i < allEds.size(); i++){
                    inmeter.add(allEds.get(i).getText().toString());
                    //  Log.v(TAG, "result" + string1[i]);
                }
                Log.v(TAG, "Incoming Meter Name" + inmeter);
            }

        });
    }*/
}

