package com.example.masiro.dabamdaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by masiro on 2017-11-21.
 */

public class SeoulRecommendResWebActivity extends AppCompatActivity{

    String Name = "";
    String x = "";
    String y = "";

    private class MyJavaScriptInterface3 {
        @JavascriptInterface
        public String Name() {
            return Name;
        }
        @JavascriptInterface
        public String x() {
            return x;
        }
        @JavascriptInterface
        public String y() {
            return y;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodrecommendweb);
        Intent intent = getIntent();
        Name = intent.getExtras().getString("Name");
        x = intent.getExtras().getString("x");
        y = intent.getExtras().getString("y");

        final WebView mWebView;
        WebSettings mWebSettings;

        mWebView = (WebView)findViewById(R.id.FoodRecommendWebview);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.addJavascriptInterface(new MyJavaScriptInterface3(), "jss");
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);

        String source = "<html>\n" +
                "<header>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://map.seoul.go.kr/smgis/apps/mapsvr.do?cmd=gisMapCss\">\n" +
                "<script type=\"text/javascript\" src=\"http://map.seoul.go.kr/smgis/apps/mapsvr.do?\n" +
                "cmd=gisMapJs&key=970423f30ebe46cb913b6c9674a1739e\"></script>\n" +
                "<script type=\"text/javascript\" src=\"http://www.google.com/jsapi\"></script>\n" +
                "<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n" +
                "</header>\n" +
                "<body>\n" +
                " <div id='mapContainer' style='width:100%;height:100%;'></div>\n" +
                " <script type='text/javascript'> \n" +
                "\n" +
                "function MapReset(){\n" +
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
                "var Name;\n" +
                "var x; \n" +
                "var y; \n" +
                "\n" +
                "Name = window.jss.Name();\n" +
                "x = parseFloat(window.jss.x());\n" +
                "y = parseFloat(window.jss.y());\n" +
                "\n" +
                "var marker;\n" +
                "                                         \n" +
                "map.scrollWheelZoom.enable();                               \n" +
                "map.setView([x,y], 7);  \n" +
                "BaseMapChange(map,L.Dawul.BASEMAP_GEN_ENG);\n" +
                "\n" +
                "L.marker([x, y],{\n" +
                "icon: myIcon\n" +
                "}).addTo(map).bindPopup(\"<b>\" + \"Name: \" + Name + \"</b>\");\n" +
                "\n" +
                " </script> \n" +
                " </body>\n" +
                " </html>";
        mWebView.loadData(source,  "text/html", "UTF-8");

        Button button = (Button)findViewById(R.id.FoodRecommendWebResetButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("javascript:MapReset()");
            }
        });
    }
}
