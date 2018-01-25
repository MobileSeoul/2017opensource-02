package com.example.masiro.dabamdaproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by masiro on 2017-11-13.
 */

public class MovieActivity extends AppCompatActivity{
    public class MyJavaScriptInterface {
        String s = "";
        public class CustomThread extends Thread {
            String s = "";
            String par = "";
            String clientId = "";
            String clientSecret = "";
            public void run(){
                    clientId = "NrUjJyUsRsix2XneClvL";//애플리케이션 클라이언트 아이디값";
                    clientSecret = "OGkBrEijHk";//애플리케이션 클라이언트 시크릿값";
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

        public String callAndroid(String str) {

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

    HashMap<String, List<String>> listDataChild4 = new HashMap<String, List<String>>(); // 영화 시간

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader = null;
    private HashMap<String, List<String>> listDataChild = null;

    String MovieImage[] = new String[20];
    String MovieName[] = new String[20];
    String MoviePage[] = new String[20];
    String MovieAddress[][] = new String[20][20];
    String MovieTime[][][] = new String[20][20][20];
    String MovieText[] = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        try {
            listDataChild4 = new MovieLinktask(this).execute().get(); // 영화 이름 불러오기

            expListView = (ExpandableListView) findViewById(R.id.MovieActivityExpandableListView);

            ChildListData();

            listAdapter = new MovieExpandableListVIewAdapter(this, listDataHeader, listDataChild,
                    MoviePage,MovieName,MovieImage,MovieAddress,MovieTime, MovieText);

            expListView.setAdapter(listAdapter);

        }catch (Exception e){
            Log.e("Test", e.toString());
        }
    }
    public MovieActivity(){
    }
    private void ChildListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // 그룹 생성
        for(int i =0; i < MovieName.length; i++){
            if(MovieName[i] == null){
                break;
            }
            listDataHeader.add(MovieName[i]);
            List<String> Movie = new ArrayList<String>();
            for(int j = 0; j < MovieAddress[i].length; j++){
                if(MovieAddress[i][j] == null){
                    break;
                }
                //Movie.add(MovieAddress[i][j]);
                ArrayList<String> list = new ArrayList<String>();
                String s = "";
                for(int k = 0; k < MovieTime[i][j].length; k++){
                    if(MovieTime[i][j][k] == null){
                        break;
                    }
                    s = "";
                    String st[] = MovieTime[i][j][k].split(" ");
                    for(int a =0; a < st.length; a++){
                        if(st[a].contains(":")){
                            if(st[a].contains("종료")){

                            }
                            else{
                                s += st[a] + " ";
                            }
                        }
                        else{
                            if(st[a + 1].contains(":")){
                                if(a == 0){
                                    s += st[a] + " ";
                                }else{
                                    s += "\n\n" + st[a] + " ";
                                }
                            }else{
                                if(a == 0){
                                    s += st[a] + " ";
                                }else{
                                    s += "\n\n" + st[a] + " " + st[a + 1] + " ";
                                    a++;
                                }
                            }
                        }
                    }
                    list.add(s);
                }
                MyJavaScriptInterface myJavaScriptInterface = new MyJavaScriptInterface();
                String a = myJavaScriptInterface.callAndroid(MovieAddress[i][j] +"\n\n" + list.get(j));
                Movie.add("Address: " + a);
            }
            listDataChild.put(listDataHeader.get(i), Movie);
        }
    }
}
class MovieLinktask extends AsyncTask<Void,Void,HashMap<String, List<String>>> {

    String URL1 = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%98%81%ED%99%94";

    String rl1 = "div[class=thmb]";
    ArrayList<String> result = new ArrayList<String>();

    String rl2 = "a[class=tab07_off]";
    ArrayList<String> result2 = new ArrayList<String>();

    String URL2 = "http://movie.naver.com/movie/bi/mi";
    String rl3 = "p[class=cine_title]";

    String rl4 = "div[class=rsv_area]";


    public MovieActivity activity;

    public MovieLinktask(MovieActivity a){
        this.activity = a;
    }

    @Override
    protected HashMap<String, List<String>> doInBackground(Void... params){
        String rl7 = "p[class=con_tx]";
        String MovieText[] = new String[20];
        try{
            Document document = Jsoup.connect(URL1).get();
            Elements elements = document.select(rl1);
            for (Element element: elements){
                result.add(element.select("a").attr("href"));
            }
            for(int i =0; i < result.size(); i++){
                Document document1 = Jsoup.connect(result.get(i)).get();
                Elements elements1 = document1.select(rl2);

                Elements elements6 = document1.select(rl7); // 영화 설명 구하기

                for (Element element: elements1){
                    result2.add(element.attr("href").substring(1));
                }
                for (Element element: elements6){
                    MovieText[i] = element.text();
                }
            }

            // 이 위에는 무시
            int j;
            int k;
            String MovieImage[] = new String[20];
            String MovieName[] = new String[20];
            String MoviePage[] = new String[20];
            String MovieAddress[][] = new String[20][20];
            String MovieTime[][][] = new String[20][20][20];

            String rl5 = "strong[class=h_movie2]";
            String rl6 = "div[class=poster]";

            for(int i =0; i < result2.size(); i++){ // 페이지
                Document document2 = Jsoup.connect(URL2 + result2.get(i)).get(); // 페이지 번호 구하기
                Elements elements2 = document2.select(rl3); // 영화관 장소 구하기

                Document document4 = Jsoup.connect(result.get(i)).get(); // 제목 구하기
                Elements elements4 = document4.select(rl5); // 영화 제목 구하기
                Elements elements5 = document4.select(rl6); // 영화 제목 구하기
                MovieImage[i] = elements5.select("img").first().attr("src").toString();
                MovieName[i] = elements4.first().text();
                MoviePage[i] = "" + i;

                for (j = 0; j < elements2.size(); j++){
                    Elements elements3 = document2.select(rl4); // 영화 시작 시간 구하기기
                    MovieAddress[i][j] = elements2.get(j).select("strong").text(); // 영화관
                    for (k = 0; k < elements3.size(); k++){
                        MovieTime[i][j][k] = elements3.get(k).select("div[class=rsv_time]").text();
                        Log.d("Test", MovieTime[i][j][k]);
                    }
                }
            }
            activity.MoviePage = MoviePage;
            activity.MovieAddress = MovieAddress;
            activity.MovieName = MovieName;
            activity.MovieTime = MovieTime;
            activity.MovieImage = MovieImage;
            activity.MovieText = MovieText;

        }catch (IOException e){
            Log.e("Test", "3" + e.toString());
        }
        //return result1 + " " + result2 + "C";
        return null;
    }
    @Override
    protected void onPostExecute(HashMap<String, List<String>> s){
        super.onPostExecute(s);
    }
}

