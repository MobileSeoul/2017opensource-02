package com.example.masiro.dabamdaproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

/**
 * Created by masiro on 2017-11-26.
 */

public class MovieExpandableListVIewAdapter extends BaseExpandableListAdapter {

    public class MyJavaScriptInterface {
        String s = "";
        public class CustomThread extends Thread {
            String s = "";
            String par = "";
            String clientId = "";
            String clientSecret = "";

            public void run(){
                    clientId = "nOtgOKzmCudgRzGtqG1S";//애플리케이션 클라이언트 아이디값";
                    clientSecret = "69xUpq2ipG";//애플리케이션 클라이언트 시크릿값";

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
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    private ViewHolder viewHolder = null;

    String mMovieImage[];
    String mMovieName[];
    String mMoviePage[];
    String mMovieAddress[][];
    String mMovieTime[][][];
    String mMovieText[];

    public MovieExpandableListVIewAdapter(Context context, List<String> listDataHeader,
                                          HashMap<String, List<String>> listChildData,
                                          String[] MoviePage, String[] MovieName, String[] MovieImage,
                                          String[][]MovieAddress, String[][][]MovieTime, String[] MovieText) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        mMoviePage = MoviePage;
        mMovieImage = MovieImage;
        mMovieName = MovieName;
        mMovieAddress = MovieAddress;
        mMovieTime = MovieTime;
        mMovieText = MovieText;

        MyJavaScriptInterface myJavaScriptInterface = new MyJavaScriptInterface();
        for(int i = 0; i < mMovieText.length; i++){
            mMovieText[i] = myJavaScriptInterface.callAndroid(mMovieText[i]);
        }
    }
    //차일드 뷰 반환
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosition);
    }
    //차일드 뷰 ID 반환
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {

            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.foodrecommendlistrow3, null);
        }
        TextView txtListChild = (TextView)  convertView.findViewById(R.id.foodrecommendlistrow3text1);

        txtListChild.setText(childText);

        return convertView;
    }    //차일드 뷰의 사이즈 반환
    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    //그룹 포지션 반환
    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    //그룹 사이즈를 반환
    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }
    //그룹 ID를 반환
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    Bitmap bitmap;

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.foodrecommendlistrow4, null);
            viewHolder.iv_image = (ImageView) convertView.findViewById(R.id.FoodRecommendlistrow4Imageview1);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        parent.setBackgroundColor(Color.parseColor("#000000"));

        ImageView imageviews = (ImageView) convertView.findViewById(R.id.FoodRecommendlistrow4Imageview1);
        //String name = getGroup(groupPosition).toString();


        try{
            String s[] = mMovieImage[groupPosition].split("\\?");
            //imageviews.setImageBitmap(bitmap);
            Picasso.with(_context)
                    .load(s[0])
                    .into(imageviews);
            imageviews.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }catch (Exception e){

        }
        //그룹을 펼칠 때 또는 닫을 때 아이콘 변경
        TextView lblListHeader = (TextView) convertView.findViewById(R.id.FoodRecommenlistrow4Textview2);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(mMovieName[groupPosition]);

        TextView textView = (TextView) convertView.findViewById(R.id.FoodRecommendlistrow4Textview1);

        textView.setText(mMovieText[groupPosition]);

        return convertView;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    //뷰홀더 클래스 생
    class ViewHolder {
        public ImageView iv_image;
        public LinearLayout laytest;
    }
}
