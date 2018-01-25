package com.example.masiro.dabamdaproject;

import android.support.v4.app.Fragment;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by masiro on 2017-11-27.
 */
public class MainPageActivity extends Fragment{
    long mNow;
    Date mDate;

    SimpleDateFormat mFormat = new SimpleDateFormat("aa|hh|mm");
    SimpleDateFormat mFormat2 = new SimpleDateFormat("yyyy|MM|dd");

    TextView textView;
    TextView watherview;
    TextView Laterview;
    ImageView imageView;

    static RelativeLayout Rlayout;
    public static RelativeLayout getInstance(){
        return Rlayout;
    }

    public MainPageActivity(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_mainpage, container, false);
        Rlayout = layout;
        WeatherAsynTask tasks = new WeatherAsynTask();
        tasks.execute();

        textView = (TextView)layout.findViewById(R.id.MainPageTimeView);
        watherview = (TextView)layout.findViewById(R.id.MainPageWeatherView);
        Laterview = (TextView)layout.findViewById(R.id.MainPageLaterView);
        imageView = (ImageView)layout.findViewById(R.id.MainPageImageView);

        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        String time = mFormat.format(mDate);
        String time2[] = time.split("\\|");
        if(time2[0].equals("오전")){
            time2[0] = "AM";
        }else if(time2[0].equals("오후")){
            time2[0] = "PM";
        }

        if(time2[0].equals("PM")){
            if(time2[1].equals("01")){
                imageView.setBackgroundResource(R.drawable.am);
            }else if(time2[1].equals("02")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("03")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("04")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("05")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("06")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("07")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("08")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("09")){
                imageView.setBackgroundResource(R.drawable.pm);
            }
            else if(time2[1].equals("10")){
                imageView.setBackgroundResource(R.drawable.pm);
            }
            else if(time2[1].equals("11")){
                imageView.setBackgroundResource(R.drawable.pm);
            }
            else if(time2[1].equals("12")){
                imageView.setBackgroundResource(R.drawable.pm);
            }
        } else if(time2[0].equals("AM")){
            if(time2[1].equals("01")){
                imageView.setBackgroundResource(R.drawable.pm);
            }else if(time2[1].equals("02")){
                imageView.setBackgroundResource(R.drawable.pm);
            }
            else if(time2[1].equals("03")){
                imageView.setBackgroundResource(R.drawable.pm);
            }
            else if(time2[1].equals("04")){
                imageView.setBackgroundResource(R.drawable.pm);
            }
            else if(time2[1].equals("05")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("06")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("07")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("08")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("09")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("10")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("11")){
                imageView.setBackgroundResource(R.drawable.am);
            }
            else if(time2[1].equals("12")){
                imageView.setBackgroundResource(R.drawable.am);
            }
        }
        //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String time3 = mFormat2.format(mDate);
        String time4[] = time3.split("\\|");
        if(time4[1].equals("01")){
            time4[1] = "January";
        }else if(time4[1].equals("02")){
            time4[1] = "February";
        }else if(time4[1].equals("03")){
            time4[1] = "March";
        }else if(time4[1].equals("04")){
            time4[1] = "April";
        }else if(time4[1].equals("05")){
            time4[1] = "May";
        }else if(time4[1].equals("06")){
            time4[1] = "June";
        }else if(time4[1].equals("07")){
            time4[1] = "July";
        }else if(time4[1].equals("08")){
            time4[1] = "August";
        }else if(time4[1].equals("09")){
            time4[1] = "September";
        }else if(time4[1].equals("10")){
            time4[1] = "October";
        }else if(time4[1].equals("11")){
            time4[1] = "November";
        }else if(time4[1].equals("12")){
            time4[1] = "December";
        }
        Laterview.setText(time4[0] + " / " + time4[1] + " / " + time4[2]);
        textView.setText(time2[0] + " | " + time2[1] + " | " + time2[2]);
        return layout;
    }
}class WeatherAsynTask extends AsyncTask<Void,Void,Void> {

    String URL2 = "http://www.kma.go.kr/index.jsp";

    String rl1 = "dl[class=region_weather_e]";
    String rl2 = "img[class=png25]";
    String result1 = "";
    String result2 = "";
    TextView t;
    @Override
    protected Void doInBackground(Void... params){
        try{
            Document document = Jsoup.connect(URL2).get();
            Elements elements = document.select(rl1);

            for (Element element: elements){
                result1 = element.select("dd").text();
                Log.d("Test", result1.toString());
                break;
            }

            Elements elements2 = document.select(rl2);
            for (Element element: elements2) {
                result2 = element.attr("alt");
                if(result2.equals("맑음")){
                    result2 = "Sunny";
                }else if(result2.equals("구름조금") || result2.equals("구름많음")){
                    result2 = "Clouds";
                }else if(result2.equals("흐림")){
                    result2 = "Cloudy";
                }else if(result2.equals("비") || result2.equals("가끔 비") || result2.equals("한때 비")
                        || result2.equals("가끔 비, 한때 비")){
                    result2 = "Rain";
                }else if(result2.equals("눈") || result2.equals("가끔 눈") || result2.equals("한때 눈")
                        || result2.equals("가끔 눈, 한때 눈")){
                    result2 = "Snow";
                }else if(result2.equals("비 또는 눈") || result2.equals("눈 또는 비") ||
                        result2.equals("가끔 비 또는 눈") || result2.equals("한때 비 또는 눈") ||
                        result2.equals("가끔 비 또는 눈, 한때 비 또는 눈") ||
                        result2.equals("가끔 눈 또는 비") || result2.equals("한때 눈 또는 비") ||
                        result2.equals("가끔 눈 또는 비, 한때 눈 또는 비")){
                    result2 = "Rain or snow";
                }else if(result2.equals("천둥번개")){
                    result2 = "Thunder and Lightning";
                }else if(result2.equals("안개") || result2.equals("박무") || result2.equals("연무")){
                    result2 = "Fog";
                }else if(result2.equals("황사")){
                    result2 = "Yellow dust";
                }else if(result2.equals("소나기")){
                    result2 = "Shower";
                }
                break;
            }
        }catch (IOException e){
            Log.e("Test", e.toString());
        }
        //return result1 + " " + result2 + "C";
        return null;
    }
    @Override
    protected void onPostExecute(Void s){
        super.onPostExecute(s);
        TextView v =(TextView)MainPageActivity.getInstance().findViewById(R.id.MainPageWeatherView);
        v.setText(result2 + " " + result1 + "C");
    }
}
