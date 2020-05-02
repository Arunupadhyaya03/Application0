package com.example.myapplication0;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class BackgroundWorker1 extends AsyncTask<ArrayList,Void,String> {
  /*  @Override
    protected String doInBackground(String... params) {

        final String TAG = BackgroundWorker.class.getName();
        Log.v(TAG, "result gottttt");
        String type = params[0];
        Log.v(TAG, "ddddddddddddddd..."+type);
        String login_url = "http://192.168.43.167/meter.php";
        if(type.equals("meter")) {
            try {
                Log.v(TAG, "result enetred...");
                String meterno = params[1];
                String metername = params[2];
                String installationdate = params[3];
                String mf1 = params[4];
                String initialreading = params[5];
                String displaydigits = params[6];
                String makename = params[7];
                String protocol = params[8];
                String installationby = params[9];
                String metertype = params[10];
                String accuracy = params[11];
                String status1 = params[12];
                String userid = params[13];
                Log.v(TAG, "result enetred2...");
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred3...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred4..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred5...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("meterno","UTF-8")+"="+URLEncoder.encode(meterno,"UTF-8")+"&"
                        +URLEncoder.encode("metername","UTF-8")+"="+URLEncoder.encode(metername,"UTF-8")+"&"
                        +URLEncoder.encode("installationdate","UTF-8")+"="+URLEncoder.encode(installationdate,"UTF-8")+"&"
                        +URLEncoder.encode("mf1","UTF-8")+"="+URLEncoder.encode(mf1,"UTF-8")+"&"
                        +URLEncoder.encode("initialreading","UTF-8")+"="+URLEncoder.encode(initialreading,"UTF-8")+"&"
                        +URLEncoder.encode("displaydigits","UTF-8")+"="+URLEncoder.encode(displaydigits,"UTF-8")+"&"
                        +URLEncoder.encode("makename","UTF-8")+"="+URLEncoder.encode(makename,"UTF-8")+"&"
                        +URLEncoder.encode("protocol","UTF-8")+"="+URLEncoder.encode(protocol,"UTF-8")+"&"
                        +URLEncoder.encode("installationby","UTF-8")+"="+URLEncoder.encode(installationby,"UTF-8")+"&"
                        +URLEncoder.encode("metertype","UTF-8")+"="+URLEncoder.encode(metertype,"UTF-8")+"&"
                        +URLEncoder.encode("accuracy","UTF-8")+"="+URLEncoder.encode(accuracy,"UTF-8")+"&"
                        +URLEncoder.encode("status","UTF-8")+"="+URLEncoder.encode(status1,"UTF-8")+"&"
                        +URLEncoder.encode("userid","UTF-8")+"="+URLEncoder.encode(userid,"UTF-8");
                bufferedWriter.write(post_data);
                Log.v(TAG, "result enetred55555..."+post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.v(TAG, "result"+result);
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
*/
    @Override
    protected String doInBackground(ArrayList... arrayLists) {
        return null;
    }
}
