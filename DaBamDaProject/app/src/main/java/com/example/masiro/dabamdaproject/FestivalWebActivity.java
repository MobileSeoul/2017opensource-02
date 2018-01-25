package com.example.masiro.dabamdaproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by masiro on 2017-11-22.
 */

public class FestivalWebActivity extends AppCompatActivity {
    String URL = "";
    String Type = "";
    String Title = "";
    String Address = "";
    String StartDate= "";
    String EndDate= "";
    String ImageUrl= "";

    int size = 0;
    int st = 0;
    boolean ab = false;
     ExpandableListAdapter listAdapter = null;
     ExpandableListView expListView = null;
     List<String> listDataHeader = null;
     HashMap<String, List<String>> listDataChild = null;


    private class MyJavaScriptInterface2 {
        String s = "";

        public class CustomThread2 extends Thread {
            String par = "";

            public void run() {
                String clientId = "";
                String clientSecret = "";
                if(Type.equals("Concert")) {
                    clientId = "GHWwzj2cmU4E7U2EsNHB";//애플리케이션 클라이언트 아이디값";
                    clientSecret = "4bBWyjFju8";//애플리케이션 클라이언트 시크릿값";
                }
                else if(Type.equals("Classic")){
                    clientId = "8XTKnB4aEgTamd1DmlLU";//애플리케이션 클라이언트 아이디값";
                    clientSecret = "PYgXP0WMED";//애플리케이션 클라이언트 시크릿값";
                }
                else if(Type.equals("Musical")){
                    clientId = "cBxpVTyutVSyZsP0Vcgz";//애플리케이션 클라이언트 아이디값";
                    clientSecret = "bNP5hiUXNM";//애플리케이션 클라이언트 시크릿값";
                }
                else if(Type.equals("Theater")){
                    clientId = "KGeDCxevs9No5JVaAL4R";//애플리케이션 클라이언트 아이디값";
                    clientSecret = "rx96G1v8KY";//애플리케이션 클라이언트 시크릿값";
                }
                else if(Type.equals("Dancing")){
                    clientId = "z_uorT1RZOkbwGVP51uc";//애플리케이션 클라이언트 아이디값";
                    clientSecret = "nQbsBy3kWG";//애플리케이션 클라이언트 시크릿값";
                }
                else if(Type.equals("Art")){
                    clientId = "9zj05W2OokuQ6esuGF6g";//애플리케이션 클라이언트 아이디값";
                    clientSecret = "1fGIMHoDWx";//애플리케이션 클라이언트 시크릿값";
                }
                else{
                    clientId = "TsAuGssNAnCe4Rw0IpVk";//애플리케이션 클라이언트 아이디값";
                    clientSecret = "YgLSIVHEiH";//애플리케이션 클라이언트 시크릿값";
                }
                try {
                    String text = URLEncoder.encode(par, "UTF-8");
                    String apiURL = "https://openapi.naver.com/v1/language/translate";
                    URL url = new URL(apiURL);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    con.setRequestProperty("X-Naver-Client-Id", clientId);
                    con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                    // post request
                    String postParams = "source=ko&target=en&text=" + text;
                    con.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    wr.writeBytes(postParams);
                    wr.flush();
                    wr.close();
                    int responseCode = con.getResponseCode();
                    BufferedReader br;
                    if (responseCode == 200) { // 정상 호출
                        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    } else {  // 에러 발생
                        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                    }
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }
                    br.close();
                    s = response.toString();
                    JSONObject jsonData = new JSONObject(s);
                    JSONObject jsonObject = jsonData.getJSONObject("message");
                    s = jsonObject.getJSONObject("result").getString("translatedText");
                } catch (Exception e) {
                    s = "Fail";
                }
            }

            public String getResult() {
                return s;
            }

            public void setResult(String a) {
                par = a;
            }
        }

        @JavascriptInterface
        public String callAndroid(final String str) {
            CustomThread2 th = new CustomThread2();
            th.setResult(str);
            th.start();
            try {
                th.join();
            } catch (Exception e) {
            }
            String s = th.getResult();
            return s;
        }

        @JavascriptInterface
        public String getUrl() {
            return URL;
        }

        @JavascriptInterface
        public void getSize(final int a) {
            size = a;
        }

        @JavascriptInterface
        public void SaveTitle(final String a) {
            Title += a + "^";
        }

        @JavascriptInterface
        public void SaveAddress(final String a) {
            Address += a + "^";
        }

        @JavascriptInterface
        public void SaveStartDate(final String a) {
            StartDate += a + "^";
        }

        @JavascriptInterface
        public void SaveEndDate(final String a) {
            EndDate += a + "^";
        }

        @JavascriptInterface
        public void SaveImageUrl(final String a) {
            ImageUrl += a + "^";
        }
        @JavascriptInterface
        public void ab(){
            ab = true;
        }
    }

    WebView mWebView = null;
    WebSettings mWebSettings = null;

    Timer timer;
    final Handler handler = new Handler();
    boolean a = true;
    void ChildListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        List<String> Food = new ArrayList<String>();
        Food.add("Hello");
        for (int i = 0; i < size; i++) {
            listDataHeader.add(Title.split("\\^")[i]);
        }
        for(int i =0; i < size; i++){
            listDataChild.put(listDataHeader.get(i),Food);
        }
    }
    void St(){
        expListView = (ExpandableListView) findViewById(R.id.FestivalActivityExpandableListView);

        // 리스트뷰에 데이터를 넣는 곳.
        ChildListData();

        listAdapter = new FestivalExpandableListViewAdapter(FestivalWebActivity.this, listDataHeader, listDataChild, Title, StartDate, EndDate, Address, ImageUrl, Type);

        // 리스트어댑터 세팅
        expListView.setAdapter(listAdapter);
    }

    void Update(){
        Runnable updater = new Runnable() {
            @Override
            public void run() {
                if(ab == true){
                    ab = false;
                    St();
                }
            }
        };
        handler.post(updater);
    }

    boolean test = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);

        Intent intent = getIntent();
        URL = intent.getExtras().getString("URL");
        Type = intent.getExtras().getString("Type");
        mWebView = (WebView) findViewById(R.id.FestivalWebView);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.addJavascriptInterface(new MyJavaScriptInterface2(), "myjs2");
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);

        String source = "<html>\n" +
                "<header>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />                     \n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "<script type=\"text/javascript\" src=\"http://www.google.com/jsapi\"></script>\n" +
                "</header>\n" +
                "<body>\n" +
                "<script type='text/javascript'> /* JavaScript Start */\n" +
                "\n" +
                "\n" +
                "function TitleFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName(\"TITLE\");\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName(\"TITLE\")[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "function AddressFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName(\"PLACE\");\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName(\"PLACE\")[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "function StartDateFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName(\"STRTDATE\");\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName(\"STRTDATE\")[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "function EndDateFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName(\"END_DATE\");\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName(\"END_DATE\")[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "function ImageUrlFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName(\"MAIN_IMG\");\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName(\"MAIN_IMG\")[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "if(y == null){\n" +
                "z[i] =\"https://lh4.ggpht.com/-PtwFBckvv78/V3aBB39xD9I/AAAAAAAAHFA/EXKKalIB8IkvyJjUzGrDVQCzLMs5Alx9QCLcB/s1600/anh-blogspot-khong-hien-thi.png\";\n" +
                "}else{\n" +
                "var a = y.nodeValue.toString();\n" +
                "z[i] = a.toLowerCase();\n" +
                "}\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "var client = new XMLHttpRequest(); \n" +
                "\n" +
                "var Title = new Array(); \n" +
                "var Address = new Array(); \n" +
                "var StartDate = new Array();\n" +
                "var EndDate = new Array(); \n" +
                "var ImageUrl = new Array();\n" +
                "\n" +
                "var url = window.myjs2.getUrl(); \n" +
                "\n" +
                "client.onreadystatechange  = function(){\n" +
                "if(this.readyState == 4 && this.status == 200){\n" +
                "\n" +
                "Title = TitleFunction(this);\n" +
                "window.myjs2.getSize(Title.length);\n" +
                "for(var i =0; i < Title.length; i++){\n" +
                "Title[i] = window.myjs2.callAndroid(Title[i]);\n" +
                "window.myjs2.SaveTitle(Title[i]);\n" +
                "}\n" +
                "\n" +
                "Address = AddressFunction(this);\n" +
                "for(var i =0; i < Address.length; i++){\n" +
                "Address[i] = window.myjs2.callAndroid(Address[i]);\n" +
                "window.myjs2.SaveAddress(Address[i]);\n" +
                "}\n" +
                "\n" +
                "StartDate = StartDateFunction(this);\n" +
                "for(var i =0; i < StartDate.length; i++){\n" +
                "window.myjs2.SaveStartDate(StartDate[i]);\n" +
                "}\n" +
                "\n" +
                "EndDate = EndDateFunction(this);\n" +
                "for(var i =0; i < EndDate.length; i++){\n" +
                "window.myjs2.SaveEndDate(EndDate[i]);\n" +
                "}\n" +
                "\n" +
                "ImageUrl = ImageUrlFunction(this);\n" +
                "for(var i =0; i < ImageUrl.length; i++){\n" +
                "window.myjs2.SaveImageUrl(ImageUrl[i]);\n" +
                "}\n" +
                "window.myjs2.ab();\n" +
                "} \n" +
                "};\n" +
                "\n" +
                "client.open(\"GET\",url, true);\n" +
                "client.send();\n" +
                "\n" +
                " </script> \n" +
                " </body>\n" +
                " </html>";

        mWebView.loadData(source, "text/html", "UTF-8");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Update();
            }
        };
        timer = new Timer();
        timer.schedule(timerTask,0,1000);
    }
    // 그룹 내 차일드 뷰 생성
}
