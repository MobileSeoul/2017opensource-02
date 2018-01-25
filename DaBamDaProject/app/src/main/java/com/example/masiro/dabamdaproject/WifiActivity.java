package com.example.masiro.dabamdaproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by masiro on 2017-11-29.
 */

public class WifiActivity extends AppCompatActivity{
    WebView mWebView;
    WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mWebView = (WebView)findViewById(R.id.FoodWebView);
        mWebView.setWebViewClient(new WebViewClient());
        //mWebSettings.setDefaultTextEncodingName("UTF-8");
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
                "<div id='mapContainer' style='width:100%;height:100%;'></div>\n" +
                "<script type='text/javascript'>\n" +
                "\n" +
                "function MapReset(){\n" +
                "map.setView([37.566611,126.978509], 7);  \n" +
                "}\n" +
                "\n" +
                "function XFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName(\"WGS84_X\");\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName(\"WGS84_X\")[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "function YFunction(xml){\n" +
                "var z = new Array();\n" +
                "var xmlDoc = xml.responseXML;\n" +
                "var x = xmlDoc.getElementsByTagName(\"WGS84_Y\");\n" +
                "for(var i = 0; i < x.length; i++){\n" +
                "var x1 = xmlDoc.getElementsByTagName(\"WGS84_Y\")[i];\n" +
                "var y = x1.childNodes[0];\n" +
                "z[i] = y.nodeValue;\n" +
                "}\n" +
                "return z;\n" +
                "}\n" +
                "\n" +
                "var myIcon = new L.icon({\n" +
                "iconUrl: 'http://www.myiconfinder.com/uploads/iconsets/6096188ce806c80cf30dca727fe7c237.png',\n" +
                "iconSize: [19, 32],\n" +
                "iconAnchor: [19, 32]\n" +
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
                "\n" +
                "var Lat = new Array(); \n" +
                "var Log = new Array(); \n" +
                "\n" +
                "client.onreadystatechange  = function(){\n" +
                "if(this.readyState == 4 && this.status == 200){\n" +
                "\n" +
                "Lat = XFunction(this);\n" +
                "\n" +
                "Log = YFunction(this);\n" +
                "                                         \n" +
                "map.scrollWheelZoom.enable();                               \n" +
                "map.setView([37.566611,126.978509], 7);  \n" +
                "BaseMapChange(map,L.Dawul.BASEMAP_GEN_ENG);\n" +
                "\n" +
                "for(var i = 0; i < Lat.length; i++){\n" +
                "L.marker([Log[i], Lat[i]],{\n" +
                "icon: myIcon\n" +
                "}).addTo(map);\n" +
                "}\n" +
                "\n" +
                "}\n" +
                "};\n" +
                "\n" +
                "client.open(\"GET\", \n" +
                "\"http://openapi.seoul.go.kr:8088/4774445546793337343974666b5064/xml/SebcPublicWifiEng/1/300/\", true);\n" +
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
