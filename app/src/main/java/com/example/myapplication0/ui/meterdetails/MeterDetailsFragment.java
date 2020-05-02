package com.example.myapplication0.ui.meterdetails;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication0.BackgroundWorker;
import com.example.myapplication0.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MeterDetailsFragment extends Fragment {
    EditText meterno, metername, installdate, mf, initialreading, displaydigits, makename, protocol, installby, userid;
    Spinner  accuracy, status,metertype;
    Button button1,button2;
    String userid1;
    String meternumber = "";
    String metern = "";
    String installationdate = "";
    String mf1 = "";
    String inreading = "";
    String ddigits = "";
    String metert = "";
    String accur = "";
    String mname = "";
    String pro = "";
    String installationby = "";
    String accuracy1;
    String status1 = "";
    int mSelectedItem;
    //String[] metertype = { "Static", "Electronic", "Prepaid", "Smart Meter"};
    final String TAG = MeterDetailsFragment.class.getName();
    private MeterDetailsViewModel meterDetailsViewModel;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_meterdetails, container, false);
       // TextView textView = root.findViewById(R.id.text_home);
        userid = root.findViewById(R.id.user_id);
        meterno = root.findViewById(R.id.meter_no);
        metername = root.findViewById(R.id.metername);
        installdate = root.findViewById(R.id.in_date);
        mf = root.findViewById(R.id.mf);
        initialreading = root.findViewById(R.id.initialreading);
        displaydigits = root.findViewById(R.id.displaydigits);
        makename = root.findViewById(R.id.makename);
        protocol = root.findViewById(R.id.protocol);
        installby = root.findViewById(R.id.installationby);
        metertype = root.findViewById(R.id.meter_type);
        accuracy = root.findViewById(R.id.accuracy);
        status = root.findViewById(R.id.status);
        button1 = root.findViewById(R.id.b1);
        button2 = root.findViewById(R.id.b2);




        installdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                final Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);
                //  Log.v(TAG, "result enetred40...");
                DatePickerDialog mDatePicker=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        installdate.setText(selectedday + "/" + selectedmonth + "/" + selectedyear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.getDatePicker().setCalendarViewShown(false);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();  }
        });



   /*     meterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(meterno.length()==0)
                {
                    meterno.setError("Please enter a valid meter number");
                }
            }
        });

        metername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(metername.length()==0)
                {
                    metername.setError("Please enter a valid meter name");
                }
            }
        });

        mf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mf.length()==0)
                {
                    mf.setError("Please enter a valid Multiplying Factor");
                }
            }
        });

        initialreading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(initialreading.length()==0)
                {
                    initialreading.setError("Please enter a valid Reading");
                }
            }
        });

        displaydigits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(displaydigits.length()==0)
                {
                    displaydigits.setError("Please enter a valid digit");
                }
            }
        });

        makename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(makename.length()==0)
                {
                    makename.setError("Please enter a valid Name");
                }
            }
        });

        protocol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(protocol.length()==0)
                {
                    protocol.setError("Please enter a valid Protocol");
                }
            }
        });

        installby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(installby.length()==0)
                {
                    installby.setError("Please enter a valid name");
                }
            }
        });
*/
        metertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //metertype.setSelection(0,true);
                metert=getResources().getStringArray(R.array.metertype_array)[position];
                if(position>0){
                    Toast.makeText(getActivity().getApplicationContext(), "You selected  "+metert, Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        accuracy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //accuracy.setSelection(0,true);
                accuracy1=getResources().getStringArray(R.array.accuracy_array)[position];
                if(position>0){
                    Toast.makeText(getActivity().getApplicationContext(), "You selected  "+accuracy1, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //status.setSelection(0,true);

                if(position>0){
                    status1=getResources().getStringArray(R.array.status_array)[position];
                    Toast.makeText(getActivity().getApplicationContext(), "You selected  "+status1, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                userid1 = userid.getText().toString();
                meternumber = meterno.getText().toString();
                metern = metername.getText().toString();
                installationdate = installdate.getText().toString();
                mf1 = mf.getText().toString();
                inreading = initialreading.getText().toString();
                ddigits = displaydigits.getText().toString();
                mname = makename.getText().toString();
                pro = protocol.getText().toString();
                installationby = installby.getText().toString();
                String res = "";


                        if(meterno.length()==0)
                        {
                            meterno.setError("Please enter a valid meter number");
                            meterno.requestFocus();
                        }
                        else if(metername.length()==0) {
                            metername.setError("Please enter a valid meter name");
                            metername.requestFocus();
                        }

                       else if(mf.length()==0)
                        {
                            mf.setError("Please enter a valid Multiplying Factor");
                            mf.requestFocus();
                        }



                       else if(initialreading.length()==0)
                        {
                            initialreading.setError("Please enter a valid Reading");
                            initialreading.requestFocus();
                        }


                       else if(displaydigits.length()==0)
                        {
                            displaydigits.setError("Please enter a valid digit");
                            displaydigits.requestFocus();
                        }


                       else if(makename.length()==0)
                        {
                            makename.setError("Please enter a valid Name");
                            makename.requestFocus();
                        }


                       else if(protocol.length()==0)
                        {
                            protocol.setError("Please enter a valid Protocol");
                            protocol.requestFocus();
                        }


                       else if(installby.length()==0)
                        {
                            installby.setError("Please enter a valid name");
                            installby.requestFocus();
                        }
                        else{
                            try {
                                    res = new BackgroundWorker().execute("meter", meternumber, metern, installationdate, mf1, inreading, ddigits, mname, pro,
                                            installationby,metert,accuracy1,status1,userid1).get();
                                    Log.v(TAG, "res......"+res);
                                    if(res.equals("success") ) {
                                        Toast.makeText(getActivity().getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(getActivity().getApplicationContext(), "NO Noooooooo", Toast.LENGTH_SHORT).show();
                                    }

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }






            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeterViewFragment fragment2 = new MeterViewFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container3, fragment2);
                fragmentTransaction.commit();
            }
        });

        return root;
    }
}






































