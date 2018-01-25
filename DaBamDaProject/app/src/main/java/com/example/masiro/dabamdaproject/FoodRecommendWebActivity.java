package com.example.masiro.dabamdaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.io.FileNotFoundException;

/**
 * Created by masiro on 2017-11-19.
 */

public class FoodRecommendWebActivity extends AppCompatActivity{
    String[] Name;
    String[] Address;
    String[] Number;
    String[] Money;
    String[] x;
    String[] y;

    WebView mWebView;
    WebSettings mWebSettings;

    private class MyJavaScriptInterface2 {
        @JavascriptInterface
        public String Name(final int a) {
            return Name[a];
        }
        @JavascriptInterface
        public int NameSize(){
            return Name.length;
        }
        @JavascriptInterface
        public String Money(final int a) {
            return Money[a];
        }
        @JavascriptInterface
        public int MoneySize(){
            return Money.length;
        }
        @JavascriptInterface
        public String Number(final int a) {
            return Number[a];
        }
        @JavascriptInterface
        public int NumberSize(){
            return Number.length;
        }
        @JavascriptInterface
        public String Address(final int a) {
            return Address[a];
        }
        @JavascriptInterface
        public int AddressSize(){
            return Address.length;
        }
        @JavascriptInterface
        public String x(final int a) {
            return x[a];
        }
        @JavascriptInterface
        public int xSize(){
            return x.length;
        }
        @JavascriptInterface
        public String y(final int a) {
            return y[a];
        }
        @JavascriptInterface
        public int ySize(){
            return y.length;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodrecommendweb);
        Intent intent = getIntent();
        Name = intent.getExtras().getStringArray("Name");
        Address = intent.getExtras().getStringArray("Address");
        Number = intent.getExtras().getStringArray("Number");
        Money = intent.getExtras().getStringArray("Money");
        x = intent.getExtras().getStringArray("x");
        y = intent.getExtras().getStringArray("y");

        mWebView = (WebView)findViewById(R.id.FoodRecommendWebview);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.addJavascriptInterface(new MyJavaScriptInterface2(), "js");
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);

        String source ="<html>\n" +
                "<header>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://map.seoul.go.kr/smgis/apps/mapsvr.do?cmd=gisMapCss\">\n" +
                "<script type=\"text/javascript\" src=\"http://map.seoul.go.kr/smgis/apps/mapsvr.do?cmd=gisMapJs&key=970423f30ebe46cb913b6c9674a1739e\"></script>\n" +
                "<script type=\"text/javascript\" src=\"http://www.google.com/jsapi\"></script>\n" +
                "</header>\n" +
                "<body>\n" +
                " <div id='mapContainer' style='width:100%;height:100%;'></div>\n" +
                " <script type='text/javascript'> /* JavaScript Start */\n" +
                "\n" +
                "function MapReset(){                           \n" +
                "map.setView([37.566611,126.978509], 7);  \n" +
                "}\n" +
                "\n" +
                "var myIcon = new L.icon({\n" +
                "iconUrl: 'http://www.myiconfinder.com/uploads/iconsets/6096188ce806c80cf30dca727fe7c237.png',\n" +
                "iconSize: [38, 65],\n" +
                "iconAnchor: [38, 65],\n" +
                "popupAnchor: [-20, -65]\n" +
                "});\n" +
                "\n" +
                "var map = L.map(\"mapContainer\", {\n" +
                "        continuousWorld: true\n" +
                "       ,worldCopyJump: false \n" +
                "       ,zoomControl: false \n" +
                "       ,zoomAnimation: true \n" +
                "       ,fadeAnimation: true \n" +
                "       ,inertia: false \n" +
                "       ,closePopupOnClick : false \n" +
                "       ,attributionControl: true\n" +
                "       ,dragging: false\n" +
                "       });\n" +
                "                                                                                                                                                                           \n" +
                "var Name = new Array(); \n" +
                "var Money = new Array();\n" +
                "var Address = new Array(); \n" +
                "var Number = new Array(); \n" +
                "var x = new Array(); \n" +
                "var y = new Array();\n" +
                "\n" +
                "var marker = new Array();\n" +
                "\n" +
                "var a,b,c,d,e,f;\n" +
                "\n" +
                "a = window.js.NameSize();\n" +
                "for(var i = 0; i < a; i++){\n" +
                "Name[i] = window.js.Name(i);\n" +
                "}\n" +
                "\n" +
                "b = window.js.NumberSize();\n" +
                "for(var i = 0; i < b; i++){\n" +
                "Number[i] = window.js.Number(i);\n" +
                "}\n" +
                "\n" +
                "c = window.js.MoneySize();\n" +
                "for(var i = 0; i < c; i++){\n" +
                "Money[i] = window.js.Money(i);\n" +
                "}\n" +
                "\n" +
                "d = window.js.AddressSize();\n" +
                "for(var i = 0; i < d; i++){\n" +
                "Address[i] = window.js.Address(i);\n" +
                "}\n" +
                "\n" +
                "e = window.js.xSize();\n" +
                "for(var i = 0; i < e; i++){\n" +
                "x[i] = parseFloat(window.js.x(i));\n" +
                "}\n" +
                "\n" +
                "f = window.js.ySize();\n" +
                "for(var i = 0; i < f; i++){\n" +
                "y[i] = parseFloat(window.js.y(i));\n" +
                "}\n" +
                "\n" +
                "map.scrollWheelZoom.enable();                               \n" +
                "map.setView([37.566611,126.978509], 7);  \n" +
                "BaseMapChange(map,L.Dawul.BASEMAP_GEN_ENG);\n" +
                "\n" +
                "for(var i = 0; i < a; i++){\n" +
                "L.marker([x[i], y[i]],{\n" +
                "icon: myIcon\n" +
                "}).addTo(map).bindPopup(\"<b>\" + \"Restaurant name: \" + Name[i] + \"</b>\" +\n" +
                "\"<br>\" + \"Money: \" + Money[i] + \"</br>\" +\n" +
                "\"<br>\" +  \"Address: \" + Address[i] + \"</br>\" +\n" +
                "\"<br>\" + \"Number: \" + Number[i] + \"</br>\");\n" +
                "}\n" +
                " </script> \n" +
                " </body>\n" +
                " </html>";

        mWebView.loadData(source,  "text/html", "UTF-8");

        Button button = (Button) findViewById(R.id.FoodRecommendWebResetButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("javascript:MapReset()");
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        mWebView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
    }
}
