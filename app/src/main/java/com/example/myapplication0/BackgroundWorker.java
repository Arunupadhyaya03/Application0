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

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... params) {

        final String TAG = BackgroundWorker.class.getName();
        Log.v(TAG, "result gottttt");
        String type = params[0];
        Log.v(TAG, "ddddddddddddddd..."+type);
        String login_url = "http://192.168.43.100/phpfiles/meter.php";
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

        String login_url1 = "http://192.168.43.100/phpfiles/feeder.php";
        if(type.equals("feeder")) {
            try {
                Log.v(TAG, "result enetred6...");
                String feederno = params[1];
                String feedername = params[2];
                String conductortype = params[3];
                String totallength = params[4];
                String dtrno = params[5];
                String totalconsumer = params[6];
                Log.v(TAG, "result enetred7...");
                URL url = new URL(login_url1);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred8...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred9..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred10...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("feederno","UTF-8")+"="+URLEncoder.encode(feederno,"UTF-8")+"&"
                        +URLEncoder.encode("feedername","UTF-8")+"="+URLEncoder.encode(feedername,"UTF-8")+"&"
                        +URLEncoder.encode("conductortype","UTF-8")+"="+URLEncoder.encode(conductortype,"UTF-8")+"&"
                        +URLEncoder.encode("totallength","UTF-8")+"="+URLEncoder.encode(totallength,"UTF-8")+"&"
                        +URLEncoder.encode("dtrno","UTF-8")+"="+URLEncoder.encode(dtrno,"UTF-8")+"&"
                        +URLEncoder.encode("totalconsumer","UTF-8")+"="+URLEncoder.encode(totalconsumer,"UTF-8");
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

        String login_url2 = "http://192.168.43.100/phpfiles/feeder_meter_map.php";
        if(type.equals("feeder_meter_map")) {
            try {
                Log.v(TAG, "result enetred11...");
                String feederno = params[1];
                String meterno = params[2];
                String meterfeature = params[3];
                String connectiontype = params[4];
                String connectionname = params[5];
                Log.v(TAG, "result enetred12...");
                URL url = new URL(login_url2);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred13...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred14..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred15...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("feederno","UTF-8")+"="+URLEncoder.encode(feederno,"UTF-8")+"&"
                        +URLEncoder.encode("meterno","UTF-8")+"="+URLEncoder.encode(meterno,"UTF-8")+"&"
                        +URLEncoder.encode("meterfeature","UTF-8")+"="+URLEncoder.encode(meterfeature,"UTF-8")+"&"
                        +URLEncoder.encode("connectiontype","UTF-8")+"="+URLEncoder.encode(connectiontype,"UTF-8")+"&"
                        +URLEncoder.encode("connectionname","UTF-8")+"="+URLEncoder.encode(connectionname,"UTF-8");
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

        String login_url3 = "http://192.168.43.100/phpfiles/feeder_substation_map.php";
        if(type.equals("feeder_substation_map")) {
            try {
                Log.v(TAG, "result enetred16...");
                String feederno = params[1];
                String userid = params[2];
                String connectionno = params[3];
                Log.v(TAG, "result enetred17...");
                URL url = new URL(login_url3);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred18...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred19..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred20...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("feederno","UTF-8")+"="+URLEncoder.encode(feederno,"UTF-8")+"&"
                        +URLEncoder.encode("userid","UTF-8")+"="+URLEncoder.encode(userid,"UTF-8")+"&"
                        +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
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

        String login_url4 = "http://192.168.43.100/phpfiles/meterview.php";
        if(type.equals("meterview")) {
            try {
                Log.v(TAG, "result enetred21...");
                Log.v(TAG, "result enetred22...");
                URL url = new URL(login_url4);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred23...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred24..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred25...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
              //  String post_data = URLEncoder.encode("feederno","UTF-8")+"="+URLEncoder.encode(feederno,"UTF-8")+"&"
//                        +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
              //  bufferedWriter.write(post_data);
                Log.v(TAG, "result enetred55555...");
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                Log.v(TAG, "result enetred really...");
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


        String login_url5 = "http://192.168.43.100/phpfiles/feederview.php";
        if(type.equals("feederview")) {
            try {
                Log.v(TAG, "result enetred26...");
                Log.v(TAG, "result enetred27...");
                URL url = new URL(login_url5);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred28...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred29..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred30...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                //  String post_data = URLEncoder.encode("feederno","UTF-8")+"="+URLEncoder.encode(feederno,"UTF-8")+"&"
//                        +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
                //  bufferedWriter.write(post_data);
                Log.v(TAG, "result enetred55555...");
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

        String login_url6 = "http://192.168.43.167/phpfiles/fmmview.php";
        if(type.equals("fmmview")) {
            try {
                Log.v(TAG, "result enetred31...");
                Log.v(TAG, "result enetred32...");
                URL url = new URL(login_url6);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred33...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred34..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred35...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                //  String post_data = URLEncoder.encode("feederno","UTF-8")+"="+URLEncoder.encode(feederno,"UTF-8")+"&"
//                        +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
                //  bufferedWriter.write(post_data);
                Log.v(TAG, "result enetred55555...");
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

        String login_url7 = "http://192.168.43.100/phpfiles/fsmview.php";
        if(type.equals("fsmview")) {
            try {
                Log.v(TAG, "result enetred36...");
                Log.v(TAG, "result enetred37...");
                URL url = new URL(login_url7);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred38...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred39..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred40...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                //  String post_data = URLEncoder.encode("feederno","UTF-8")+"="+URLEncoder.encode(feederno,"UTF-8")+"&"
//                        +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
                //  bufferedWriter.write(post_data);
                Log.v(TAG, "result enetred55555...");
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

        String login_url8 = "http://192.168.43.100/phpfiles/metval.php";
        if(type.equals("metval")) {
            try {
                Log.v(TAG, "result enetred16...");
                String meterno = params[1];
               // String userid = params[2];
               // String connectionno = params[3];
                Log.v(TAG, "result enetred17...");
                URL url = new URL(login_url8);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred18...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred19..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred20...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("meterno","UTF-8")+"="+URLEncoder.encode(meterno,"UTF-8");//+"&"
                  //      +URLEncoder.encode("userid","UTF-8")+"="+URLEncoder.encode(userid,"UTF-8")+"&"
                    //    +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
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

        String login_url9 = "http://192.168.43.100/phpfiles/connfe.php";
        if(type.equals("connfe")) {
            try {
                Log.v(TAG, "result enetred16...");
               // String meterno = params[1];
                // String userid = params[2];
                // String connectionno = params[3];
                Log.v(TAG, "result enetred17...");
                URL url = new URL(login_url9);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred18...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred19..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred20...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
               // String post_data = URLEncoder.encode("meterno","UTF-8")+"="+URLEncoder.encode(meterno,"UTF-8");//+"&"
                //      +URLEncoder.encode("userid","UTF-8")+"="+URLEncoder.encode(userid,"UTF-8")+"&"
                //    +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
             //   bufferedWriter.write(post_data);
             //   Log.v(TAG, "result enetred55555..."+post_data);
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

        String login_url10 = "http://192.168.43.100/phpfiles/feederconn.php";
        if(type.equals("feederconn")) {
            try {
                Log.v(TAG, "result enetred16...");
                 String connno = params[1];
                // String userid = params[2];
                // String connectionno = params[3];
                Log.v(TAG, "result enetred17...");
                URL url = new URL(login_url10);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred18...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred19..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred20...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                 String post_data = URLEncoder.encode("connno","UTF-8")+"="+URLEncoder.encode(connno,"UTF-8");//+"&"
                //      +URLEncoder.encode("userid","UTF-8")+"="+URLEncoder.encode(userid,"UTF-8")+"&"
                //    +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
                   bufferedWriter.write(post_data);
                //   Log.v(TAG, "result enetred55555..."+post_data);
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
        String login_url11 = "http://192.168.43.100/phpfiles/meterconn.php";
        if(type.equals("meterconn")) {
            try {
                Log.v(TAG, "result enetred16...");
                String feed_no = params[1];
                // String userid = params[2];
                // String connectionno = params[3];
                Log.v(TAG, "result enetred17...");
                URL url = new URL(login_url11);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred18...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred19..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred20...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("feed_no","UTF-8")+"="+URLEncoder.encode(feed_no,"UTF-8");//+"&"
                //      +URLEncoder.encode("userid","UTF-8")+"="+URLEncoder.encode(userid,"UTF-8")+"&"
                //    +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
                bufferedWriter.write(post_data);
                //   Log.v(TAG, "result enetred55555..."+post_data);
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
        String login_url12 = "http://192.168.43.100/phpfiles/mname.php";
        if(type.equals("mname")) {
            try {
                Log.v(TAG, "result enetred16...");
                String m_no = params[1];
                // String userid = params[2];
                // String connectionno = params[3];
                Log.v(TAG, "result enetred17...");
                URL url = new URL(login_url12);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred18...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred19..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred20...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("m_no","UTF-8")+"="+URLEncoder.encode(m_no,"UTF-8");//+"&"
                //      +URLEncoder.encode("userid","UTF-8")+"="+URLEncoder.encode(userid,"UTF-8")+"&"
                //    +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
                bufferedWriter.write(post_data);
                //   Log.v(TAG, "result enetred55555..."+post_data);
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
        String login_url13 = "http://192.168.43.100/phpfiles/meterconn2.php";
        if(type.equals("meterconn2")) {
            try {
                Log.v(TAG, "result enetred16...");
                String f_no = params[1];
                // String userid = params[2];
                // String connectionno = params[3];
                Log.v(TAG, "result enetred17...");
                URL url = new URL(login_url13);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                Log.v(TAG, "result enetred18...");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.v(TAG, "result enetred19..."+httpURLConnection);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Log.v(TAG, "result enetred20...");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("f_no","UTF-8")+"="+URLEncoder.encode(f_no,"UTF-8");//+"&"
                //      +URLEncoder.encode("userid","UTF-8")+"="+URLEncoder.encode(userid,"UTF-8")+"&"
                //    +URLEncoder.encode("connectionno","UTF-8")+"="+URLEncoder.encode(connectionno,"UTF-8");
                bufferedWriter.write(post_data);
                //   Log.v(TAG, "result enetred55555..."+post_data);
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
}
