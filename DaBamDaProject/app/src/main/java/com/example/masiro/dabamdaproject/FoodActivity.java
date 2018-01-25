package com.example.masiro.dabamdaproject;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by masiro on 2017-10-23.
 */

public class FoodActivity extends AppCompatActivity {

    public class GeocoderInterface{

        @JavascriptInterface
        public double GeoLat(final String str){

            List<Address> list;
            double g = 0.0;
            Geocoder geo = new Geocoder(FoodActivity.this);
            try {
                list = geo.getFromLocationName(str, 1);
                g = list.get(0).getLatitude();

            }catch (Exception e){

            }
            return g;
        }

        @JavascriptInterface
        public double GeoLog(final String str){

            List<Address> list;
            double g = 0.0;
            Geocoder geo = new Geocoder(FoodActivity.this);
            try {
                list = geo.getFromLocationName(str, 1);
                g = list.get(0).getLongitude();

            }catch (Exception e){

            }
            return g;
        }

    }
    private class MyJavaScriptInterface {
        String s = "";
        public class CustomThread extends Thread {
            String s = "";
            String par = "";
            public void run(){
                String clientId = "NEeRGYOPsina_APZCSHs";//애플리케이션 클라이언트 아이디값";
                String clientSecret = "ziFNoBxS8m";//애플리케이션 클라이언트 시크릿값";
                try {
                    String text = URLEncoder.encode(par, "UTF-8");
                    String apiURL = "https://openapi.naver.com/v1/language/translate";
                    URL url = new URL(apiURL);
                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
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
                    if(responseCode==200) { // 정상 호출
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
            public String getResult(){
                return s;
            }
            public void setResult(String a){
                par = a;
            }
        }
        @JavascriptInterface
        public String callAndroid(final String str) {

            CustomThread th = new CustomThread();
            th.setResult(str);
            th.start();
            try{
                th.join();
            }
            catch (Exception e){
            }
            String s = th.getResult();
            return s;
        }
    }
    WebView mWebView;
    WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        mWebView = (WebView)findViewById(R.id.FoodWebView);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.addJavascriptInterface(new MyJavaScriptInterface(), "myjs");
        mWebView.addJavascriptInterface(new GeocoderInterface(), "geo");
        //mWebSettings.setDefaultTextEncodingName("UTF-8");
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);

        String source ="<html>\n" +
                "<header>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://map.seoul.go.kr/smgis/apps/mapsvr.do?cmd=gisMapCss\">\n" +
                "<script type=\"text/javascript\" src=\"http://map.seoul.go.kr/smgis/apps/mapsvr.do?cmd=gisMapJs&key=970423f30ebe46cb913b6c9674a1739e\"></script>\n" +
                "<script type=\"text/javascript\" src=\"http://www.google.com/jsapi\"></script>\n" +
                "<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n" +
                "</header>\n" +
                "<body>\n" +
                " <div id='mapContainer' style='width:100%;height:100%;'></div>\n" +
                " <script type='text/javascript'> /* JavaScript Start */\n" +
                "\n" +
                "function MapReset(){\n" +
                "map.setView([37.566611,126.978509], 7);  \n" +
                "}\n" +
                "\n" +
                "function FoodTypeFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName('SNT_UPTAE_NM');\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName('SNT_UPTAE_NM')[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "function ResAddressFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName('SITE_ADDR');\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName('SITE_ADDR')[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "function ResNameFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName('UPSO_NM');\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName('UPSO_NM')[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "function MainFoodFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName('MAIN_EDF');\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName('MAIN_EDF')[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "var myIcon = new L.icon({\n" +
                "iconUrl: 'http://www.myiconfinder.com/uploads/iconsets/6096188ce806c80cf30dca727fe7c237.png',\n" +
                "iconSize: [38, 65],\n" +
                "iconAnchor: [38, 65],\n" +
                "popupAnchor: [-20, -65]\n" +
                "});\n" +
                "\n" +
                "var map = L.map(\"mapContainer\", {                            \n" +
                "        continuousWorld: true\n" +
                "       ,worldCopyJump: false \n" +
                "       ,zoomControl: false \n" +
                "       ,zoomAnimation: true \n" +
                "       ,fadeAnimation: true \n" +
                "       ,inertia: false \n" +
                "       ,closePopupOnClick : false \n" +
                "       ,attributionControl: true\n" +
                "       ,dragging: false\t                            \n" +
                " }); \n" +
                "\n" +
                "var client = new XMLHttpRequest(); \n" +
                "var FoodType = new Array();\n" +
                "var ResAddress = new Array(); \n" +
                "var ResName = new Array(); \n" +
                "var MainFood = new Array(); \n" +
                "var Lat = new Array(); \n" +
                "var Log = new Array(); \n" +
                "var g = new Array();\n" +
                "\n" +
                "\n" +
                "client.onreadystatechange  = function(){\n" +
                "if(this.readyState == 4 && this.status == 200){\n" +
                "\n" +
                "FoodType = FoodTypeFunction(this);\n" +
                "for(var i =0; i < FoodType.length; i++){\n" +
                "FoodType[i] = window.myjs.callAndroid(FoodType[i]);\n" +
                "}\n" +
                "\n" +
                "\n" +
                "ResAddress = ResAddressFunction(this);\n" +
                "for(var i =0; i < ResAddress.length; i++){\n" +
                "g[0] = window.geo.GeoLat(ResAddress[i]);\n" +
                "g[1] = window.geo.GeoLog(ResAddress[i]);\n" +
                "Lat[i] = g[0];\n" +
                "Log[i] = g[1];\n" +
                "ResAddress[i] = window.myjs.callAndroid(ResAddress[i]);\n" +
                "}\n" +
                "\n" +
                "\n" +
                "ResName = ResNameFunction(this);\n" +
                "for(var i =0; i < ResName.length; i++){\n" +
                "ResName[i] = window.myjs.callAndroid(ResName[i]);\n" +
                "}\n" +
                "\n" +
                "\n" +
                "MainFood = MainFoodFunction(this);\n" +
                "for(var i =0; i < MainFood.length; i++){\n" +
                "MainFood[i] = window.myjs.callAndroid(MainFood[i]);\n" +
                "}\n" +
                "\n" +
                "var marker = new Array();\n" +
                "                                         \n" +
                "map.scrollWheelZoom.enable();                               \n" +
                "map.setView([37.566611,126.978509], 7);  \n" +
                "BaseMapChange(map,L.Dawul.BASEMAP_GEN_ENG);\n" +
                "\n" +
                "for(var i = 0; i < ResName.length; i++){\n" +
                "L.marker([Lat[i], Log[i]],{\n" +
                "icon: myIcon\n" +
                "}).addTo(map).bindPopup(\"<b>\" + \"Restaurant name: \" + ResName[i] + \"</b>\" +\n" +
                "\"<br>\" + \"Food: \" + FoodType[i] + \"</br>\" +\n" +
                "\"<br>\" + \"Main Food: \" + MainFood[i] + \"</br>\" +\n" +
                "\"<br>\" + \"Restaurant Address: \" + ResAddress[i] + \"</br>\");\n" +
                "} \n" +
                "\n" +
                "}\n" +
                "};\n" +
                "\n" +
                "\n" +
                "client.open(\"GET\", \"http://openAPI.jongno.go.kr:8088/4774445546793337343974666b5064/xml/JongnoModelRestaurantDesignate/1/20/\", true);\n" +
                "client.send();\n" +
                "\n" +
                " </script> \n" +
                " </body>\n" +
                " </html>";


        mWebView.loadData(source,  "text/html", "UTF-8");
        Button button = (Button)findViewById(R.id.FoodButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("javascript:MapReset()");
            }
        });
    }
}
