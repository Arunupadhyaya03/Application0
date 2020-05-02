package com.example.myapplication0;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.myapplication0.ui.meterdetails.MeterViewFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;



public class Feeder_substation_view extends Fragment {
    TableLayout table;
    final String TAG = MeterViewFragment.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_feederview, container, false);

        table = root.findViewById(R.id.table);
        Log.v("nda","Working Line11");
        String res="";
        try {
            res=new BackgroundWorker().execute("fsmview").get();
            Log.v(TAG,"res      .."+res);
            JSONObject feedersubv = new JSONObject(res);
            JSONArray feedersubarray=feedersubv.getJSONArray("result");
            if(feedersubarray.length()!=0){
                TableRow row_head = new TableRow(getActivity().getApplicationContext());
                TableRow.LayoutParams lp_head = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                row_head.setLayoutParams(lp_head);
                TextView tb1_head = new TextView(getActivity().getApplicationContext());
                TextView tb2_head = new TextView(getActivity().getApplicationContext());
                TextView tb3_head = new TextView(getActivity().getApplicationContext());
                TextView tb4_head = new TextView(getActivity().getApplicationContext());
                //   TextView tb5_head = new TextView(getActivity().getApplicationContext());
                //   TextView tb6_head = new TextView(getActivity().getApplicationContext());
                //   TextView tb7_head = new TextView(getActivity().getApplicationContext());
                //   TextView tb8_head = new TextView(getActivity().getApplicationContext());
                //   TextView tb9_head = new TextView(getActivity().getApplicationContext());
                //   TextView tb10_head = new TextView(getActivity().getApplicationContext());
                //   TextView tb11_head = new TextView(getActivity().getApplicationContext());
                //   TextView tb12_head = new TextView(getActivity().getApplicationContext());
                //   TextView tb13_head = new TextView(getActivity().getApplicationContext());

                int leftMargin = 20;
                lp_head.setMargins(leftMargin,20,20,20);
                tb1_head.setGravity(Gravity.LEFT);
                tb2_head.setGravity(Gravity.CENTER);
                tb3_head.setGravity(Gravity.CENTER);
                tb4_head.setGravity(Gravity.CENTER);
                //   tb5_head.setGravity(Gravity.RIGHT);
                //   tb6_head.setGravity(Gravity.CENTER);
                //   tb7_head.setGravity(Gravity.CENTER);
                //   tb8_head.setGravity(Gravity.CENTER);
                //   tb9_head.setGravity(Gravity.CENTER);
                //   tb10_head.setGravity(Gravity.CENTER);
                //   tb11_head.setGravity(Gravity.CENTER);
                //   tb12_head.setGravity(Gravity.CENTER);
                //   tb13_head.setGravity(Gravity.CENTER);

                tb1_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                tb2_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                tb3_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                tb4_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                //   tb5_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                //   tb6_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                //   tb7_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                //   tb8_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                //   tb9_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                //   tb10_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                //   tb11_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                //   tb12_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                //   tb13_head.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);

                tb1_head.setTypeface(Typeface.DEFAULT_BOLD);
                tb2_head.setTypeface(Typeface.DEFAULT_BOLD);
                tb3_head.setTypeface(Typeface.DEFAULT_BOLD);
                tb4_head.setTypeface(Typeface.DEFAULT_BOLD);
                //   tb5_head.setTypeface(Typeface.DEFAULT_BOLD);
                //   tb6_head.setTypeface(Typeface.DEFAULT_BOLD);
                //   tb7_head.setTypeface(Typeface.DEFAULT_BOLD);
                //   tb8_head.setTypeface(Typeface.DEFAULT_BOLD);
                //   tb9_head.setTypeface(Typeface.DEFAULT_BOLD);
                //   tb10_head.setTypeface(Typeface.DEFAULT_BOLD);
                //   tb11_head.setTypeface(Typeface.DEFAULT_BOLD);
                //   tb12_head.setTypeface(Typeface.DEFAULT_BOLD);
                //   tb13_head.setTypeface(Typeface.DEFAULT_BOLD);

                tb1_head.setBackgroundColor(Color.parseColor("#CC0000"));
                tb2_head.setBackgroundColor(Color.parseColor("#CC0000"));
                tb3_head.setBackgroundColor(Color.parseColor("#CC0000"));
                tb4_head.setBackgroundColor(Color.parseColor("#CC0000"));
                //   tb5_head.setBackgroundColor(Color.parseColor("#CC0000"));
                //   tb6_head.setBackgroundColor(Color.parseColor("#CC0000"));
                //   tb7_head.setBackgroundColor(Color.parseColor("#CC0000"));
                //   tb8_head.setBackgroundColor(Color.parseColor("#CC0000"));
                //   tb9_head.setBackgroundColor(Color.parseColor("#CC0000"));
                //   tb10_head.setBackgroundColor(Color.parseColor("#CC0000"));
                //   tb11_head.setBackgroundColor(Color.parseColor("#CC0000"));
                //   tb12_head.setBackgroundColor(Color.parseColor("#CC0000"));
                //   tb13_head.setBackgroundColor(Color.parseColor("#CC0000"));

                tb1_head.setPadding(10,10,20,10);
                tb2_head.setPadding(10,10,20,10);
                tb3_head.setPadding(10,10,20,10);
                tb4_head.setPadding(10,10,20,10);
                //   tb5_head.setPadding(10,10,20,10);
                //   tb6_head.setPadding(10,10,20,10);
                //   tb7_head.setPadding(10,10,20,10);
                //   tb8_head.setPadding(10,10,20,10);
                //   tb9_head.setPadding(10,10,20,10);
                //   tb10_head.setPadding(10,10,20,10);
                //   tb11_head.setPadding(10,10,20,10);
                //   tb12_head.setPadding(10,10,20,10);
                //   tb13_head.setPadding(10,10,20,10);

                tb1_head.setTextColor(Color.parseColor("#000000"));
                tb2_head.setTextColor(Color.parseColor("#ffffff"));
                tb3_head.setTextColor(Color.parseColor("#ffffff"));
                tb4_head.setTextColor(Color.parseColor("#ffffff"));
                //   tb5_head.setTextColor(Color.parseColor("#ffffff"));
                //   tb6_head.setTextColor(Color.parseColor("#ffffff"));
                //   tb7_head.setTextColor(Color.parseColor("#ffffff"));
                //   tb8_head.setTextColor(Color.parseColor("#ffffff"));
                //   tb9_head.setTextColor(Color.parseColor("#ffffff"));
                //   tb10_head.setTextColor(Color.parseColor("#ffffff"));
                //   tb11_head.setTextColor(Color.parseColor("#ffffff"));
                //   tb12_head.setTextColor(Color.parseColor("#ffffff"));
                //   tb13_head.setTextColor(Color.parseColor("#ffffff"));

                tb1_head.setText("Feeder Number\n");
                tb2_head.setText("Feeder Name\n");
                tb3_head.setText("Type of conductor\n");
                tb4_head.setText("No. of dtrs\n");
                //   tb5_head.setText("Total Length\n");
                //   tb6_head.setText("Total Consumer\n");
                //    tb7_head.setText("No. of display digits\n");
                //    tb8_head.setText("Meter Type\n");
                //    tb9_head.setText("Accuracy\n");
                //    tb10_head.setText("Make Name\n");
                //    tb11_head.setText("Protocol\n");
                //    tb12_head.setText("Installation By\n");
                //    tb13_head.setText("Status\n");

                row_head.addView(tb1_head);
                //   row_head.addView(tb7_head);
                //   row_head.addView(tb8_head);
                //   row_head.addView(tb9_head);
                //   row_head.addView(tb10_head);
                row_head.addView(tb2_head);
                row_head.addView(tb3_head);
                //   row_head.addView(tb6_head);
                row_head.addView(tb4_head);
                //   row_head.addView(tb5_head);
                //   row_head.addView(tb11_head);
                //   row_head.addView(tb12_head);
                //   row_head.addView(tb13_head);

                row_head.setLayoutParams(lp_head);
                table.addView(row_head,lp_head);
                for (int i = 0; i < feedersubarray.length(); i++){
                    JSONObject feedersub = feedersubarray.getJSONObject(i);
                    // String Meter=(subdivdata.getString("Meter"));
                    String sl_no=(feedersub.getString("sl_no"));
                    String feeder_no = (feedersub.getString("feeder_no"));
                    String user_id=(feedersub.getString("user_id"));
                    String conn_no = (feedersub.getString("conn_no"));
                    //   String conn_type = (feedersub.getString("conn_type"));
                    //   String conn_name = (feedersub.getString("conn_name"));

                    Log.v("nda","Cload2");

                    TextView tb1 = new TextView(getActivity().getApplicationContext());
                    TextView tb2 = new TextView(getActivity().getApplicationContext());
                    TextView tb3 = new TextView(getActivity().getApplicationContext());
                    TextView tb4 = new TextView(getActivity().getApplicationContext());
                    TextView tb5 = new TextView(getActivity().getApplicationContext());
                    TextView tb6 = new TextView(getActivity().getApplicationContext());
                    TextView tb7 = new TextView(getActivity().getApplicationContext());
                    TextView tb8 = new TextView(getActivity().getApplicationContext());
                    TextView tb9 = new TextView(getActivity().getApplicationContext());
                    TextView tb10 = new TextView(getActivity().getApplicationContext());
                    TextView tb11 = new TextView(getActivity().getApplicationContext());
                    TextView tb12 = new TextView(getActivity().getApplicationContext());
                    TextView tb13 = new TextView(getActivity().getApplicationContext());
                    TextView tb14 = new TextView(getActivity().getApplicationContext());
                    TextView tb15 = new TextView(getActivity().getApplicationContext());
                    Log.v("nda","Working Line1");
                    TableRow row_data = new TableRow(getActivity().getApplicationContext());
                    TableRow.LayoutParams lp_data = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    row_data.setLayoutParams(lp_data);
                    Log.v("nda","Working Line2");
                    lp_data.setMargins(40,10,10,10);
                    tb1.setGravity(Gravity.LEFT);
                    tb2.setGravity(Gravity.CENTER);
                    tb3.setGravity(Gravity.CENTER);
                    tb4.setGravity(Gravity.CENTER);
                    tb5.setGravity(Gravity.CENTER);
                    tb6.setGravity(Gravity.CENTER);
                    tb7.setGravity(Gravity.CENTER);
                    tb8.setGravity(Gravity.CENTER);
                    tb9.setGravity(Gravity.CENTER);
                    tb10.setGravity(Gravity.CENTER);
                    tb11.setGravity(Gravity.CENTER);
                    tb12.setGravity(Gravity.CENTER);
                    tb13.setGravity(Gravity.CENTER);
                    tb14.setGravity(Gravity.CENTER);
                    tb15.setGravity(Gravity.CENTER);

                    tb1.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb2.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb3.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb4.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb5.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb6.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb7.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb8.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb9.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb10.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb11.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb12.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb13.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb14.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    tb15.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                    Log.v("nda","Working Line3");
                    tb1.setPadding(0,10,0,10);
                    tb2.setPadding(0,10,0,10);
                    tb3.setPadding(0,10,0,10);
                    tb4.setPadding(0,10,0,10);
                    tb5.setPadding(0,10,0,10);
                    tb6.setPadding(0,10,0,10);
                    tb7.setPadding(0,10,0,10);
                    tb8.setPadding(0,10,0,10);
                    tb9.setPadding(0,10,0,10);
                    tb10.setPadding(0,10,0,10);
                    tb11.setPadding(0,10,0,10);
                    tb12.setPadding(0,10,0,10);
                    tb13.setPadding(0,10,0,10);
                    tb14.setPadding(0,10,0,10);
                    tb15.setPadding(0,10,0,10);
                    Log.v("nda","Working Line4");
                    tb1.setText(String.format("%.0f",Double.parseDouble(sl_no)));
                    tb2.setText(String.format("%.2f",Double.parseDouble(feeder_no)));
                    tb3.setText(String.format("%.2f",Double.parseDouble(user_id)));
                    tb4.setText(String.format("%.2f",Double.parseDouble(conn_no)));
                    //   tb5.setText(conn_type);
                    //   tb6.setText(conn_name);

                    //  tb14.setText(String.format("%.0f",Double.parseDouble(tcoll)));
                    Log.v("nda","Working Line5");
                    tb1.setTextColor(Color.parseColor("#ffffff"));
                    tb2.setTextColor(Color.parseColor("#ffffff"));
                    tb3.setTextColor(Color.parseColor("#ffffff"));
                    tb4.setTextColor(Color.parseColor("#ffffff"));
                    tb5.setTextColor(Color.parseColor("#ffffff"));
                    tb6.setTextColor(Color.parseColor("#ffffff"));
                    //   tb7.setTextColor(Color.parseColor("#ffffff"));
                    //   tb8.setTextColor(Color.parseColor("#ffffff"));
                    //   tb9.setTextColor(Color.parseColor("#ffffff"));
                    //   tb10.setTextColor(Color.parseColor("#ffffff"));
                    //  tb11.setTextColor(Color.parseColor("#ffffff"));
                    //  tb12.setTextColor(Color.parseColor("#ffffff"));
                    //   tb13.setTextColor(Color.parseColor("#ffffff"));
                    // tb14.setTextColor(Color.parseColor("#ffffff"));
                    //  tb15.setTextColor(Color.parseColor("#ffffff"));
                    Log.v("nda","Working Line6");
                    row_data.addView(tb1);
                    row_data.addView(tb7);
                    row_data.addView(tb8);
                    row_data.addView(tb9);
                    row_data.addView(tb10);
                    row_data.addView(tb2);
                    row_data.addView(tb3);
                    row_data.addView(tb6);
                    row_data.addView(tb4);
                    row_data.addView(tb5);
                    row_data.addView(tb11);
                    row_data.addView(tb12);
                    row_data.addView(tb13);
                    row_data.addView(tb14);
                    row_data.addView(tb15);
                    Log.v("nda","Working Line7");
                    row_data.setLayoutParams(lp_data);
                    table.addView(row_data,lp_data);
                }
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v("nda","Working Line8");

        return root;
    }

}
