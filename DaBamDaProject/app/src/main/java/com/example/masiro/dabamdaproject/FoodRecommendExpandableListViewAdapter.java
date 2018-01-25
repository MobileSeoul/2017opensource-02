package com.example.masiro.dabamdaproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by masiro on 2017-11-19.
 */

public class FoodRecommendExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    private ViewHolder2 viewHolder = null;

    public FoodRecommendExpandableListViewAdapter(Context context, List<String> listDataHeader,
                                                  HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }
    //차일드 뷰 반환
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }


    //차일드 뷰 ID 반환
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //차일드 뷰 생성(각 차일드 뷰의 (ROW)
    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.foodrecommendlistrow2, null);
        }
        String name = getGroup(groupPosition).toString();

        Log.d("Test", name);
        TextView textView1 = (TextView)convertView.findViewById(R.id.foodrecommendlistrow2text1);
        if(name == "short rib soup"){
            if(childPosition == 0) {
                textView1.setText("It is made with meat broth on ribs. It is made with soy sauce, salt, seasoning and boiled for long time.");
            }
        }
        else if(name == "loach stew"){
            if(childPosition == 0) {
                textView1.setText("This food is cooked by putting loach in a bowl or finely ground and putting various vegetables in a bowl.");
            }
        }
        else if(name == "grilled clams"){
            if(childPosition == 0) {
                textView1.setText("This food is cooked in a fire plate and eaten with various spices.");
            }
        }
        else if(name == "chicken feet"){
            if(childPosition == 0) {
                textView1.setText("It is a food that cuts the clawed toes of a chicken's foot and eats spicy condiments on the rest.");
            }
        }
        else if(name == "ox bone soup"){
            if(childPosition == 0) {
                textView1.setText("This food is a soup boiled with bones and meat.");
            }
        }
        else if(name == "Eel"){
            if(childPosition == 0) {
                textView1.setText("This food was baked with sauce on an eel.");
            }
        }
        else if(name == "duck"){
            if(childPosition == 0) {
                textView1.setText("Sprinkle thick salt, pepper powder sesame oil on duck and eat it with fresh vegetables etc");
            }
        }
        final Button button1 = (Button)convertView.findViewById(R.id.foodrecommendlistrow2button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(groupPosition == 0){ // 갈비탕
                    Intent intent = new Intent(_context,
                            FoodRecommendWebActivity.class);
                    String[] Name = {
                            "Saebyeogjib",
                            "JoSeonok",
                            "Gangnammyeonok",
                            "HanIlgwan",
                            "Beodeunamujip",
                            "Bugakjeong"
                            };
                    String[] Number = {
                            "02-546-5739",
                            "02-2266-0333",
                            "02-400-6599",
                            "02-732-3735",
                            "02-3473-4167",
                            "02-394-2340",
                            };
                    String[] Money = {
                            "18,000won",
                            "10,000won",
                            "10,000won",
                            "15,000won",
                            "20,000won",
                            "15,000won",
                            };
                    String[] Address = {
                            "Seoul Gangnam-gu Cheongdam-dong 129-10",
                            "Seoul Jung-gu Eulji-ro 3-ga 229-1",
                            "Seoul Gangnam-gu sinsa-dong 588-9",
                            "Seoul Gangnam-gu Sinsa-dong 570-6",
                            "Seoul-si Seocho-gu Seocho 2-dong 1340-5",
                            "Seoul Jongno-gu Pyeongchang-dong 114-12"
                            };
                    String[] x = {
                            "37.525720",
                            "37.566943",
                            "37.521538",
                            "37.524367",
                            "37.489283",
                            "37.611354"
                    };
                    String[] y = {
                            "127.052831",
                            "126.993613",
                            "127.030949",
                            "127.027274",
                            "127.031166",
                            "126.977726"
                    };
                    intent.putExtra("Name",Name);
                    intent.putExtra("Address",Address);
                    intent.putExtra("Money",Money);
                    intent.putExtra("Number",Number);
                    intent.putExtra("x",x);
                    intent.putExtra("y",y);
                    _context.startActivity(intent);
                }
                else if(groupPosition == 1){ // 추어탕
                    Intent intent = new Intent(_context,
                            FoodRecommendWebActivity.class);
                    String[] Name = {
                            "Inpyeongildeungchueotang ",
                            "Chamnamu bonga",
                            "Wonju chueotang",
                            "Namdosikdang",
                            "Ganggane dolsotbapchueotang"
                    };
                    String[] Address = {
                            "Seoul Gangnam-gu Yeoksam-dong 683-26",
                            "Seoul Mapo-gu gongdeok-dong 256-5",
                            "Seoul-si Seocho-gu Yangjae 2-dong 352-3",
                            "Seoul-si Jung-gu Jeong-dong 11-4",
                            "Seoul Geumcheon-gu Doksan3-dong 901-3"
                    };
                    String[] Money = {
                            "8,000won",
                            "10,000won",
                            "9,000won",
                            "10,000won",
                            "10,000won",
                    };
                    String[] Number = {
                            "02-552-8889",
                            "02-712-9997",
                            "02-572-0725",
                            "0000",
                            "02-867-8887"
                    };
                    String[] x = {
                            "37.508160",
                            "37.545259",
                            "37.482132",
                            "37.566020",
                            "37.480442",
                    };
                    String[] y = {
                            "127.044733",
                            "126.953408",
                            "127.040295",
                            "126.972566",
                            "126.908561"
                    };
                    intent.putExtra("Name",Name);
                    intent.putExtra("Address",Address);
                    intent.putExtra("Money",Money);
                    intent.putExtra("Number",Number);
                    intent.putExtra("x",x);
                    intent.putExtra("y",y);
                    _context.startActivity(intent);
                }
                else if(groupPosition == 2){ // 조개구이
                    Intent intent = new Intent(_context,
                            FoodRecommendWebActivity.class);
                    String[] Name = {
                            "Baennom",
                            "Rokkorokko",
                            "JoGaechanggo",
                            "Suginejogaejeongol",
                            "Jogaeiyagi"
                    };
                    String[] Address = {
                            "Seoul-si Gwangjin-gu Gunja-dong 373-9",
                            "Seoul Yeongdeungpo-gu Yeongdeungpo-dong 3-ga 4-12",
                            "Seoul Seongdong-gu Hawangsimni-dong 966-12",
                            "Seoulteukbyeolsi seodaemungu changcheondong 52-48",
                            "Seoul Mapo-gu Donggyo-dong 170-19"
                    };
                    String[] Money = {
                            "39,000won",
                            "40,000won",
                            "25,000won",
                            "35,000won",
                            "40,000won"
                    };
                    String[] Number = {
                            "010-5000-4346",
                            "02-2632-4777",
                            "010-2650-0449",
                            "02-322-8682",
                            "02-332-0920"
                    };
                    String[] x = {
                            "37.548444",
                            "37.519308",
                            "37.562718",
                            "37.558028",
                            "37.556941"
                    };
                    String[] y = {
                            "127.072911",
                            "126.907020",
                            "127.032703",
                            "126.936185",
                            "126.926491"
                    };
                    intent.putExtra("Name",Name);
                    intent.putExtra("Address",Address);
                    intent.putExtra("Money",Money);
                    intent.putExtra("Number",Number);
                    intent.putExtra("x",x);
                    intent.putExtra("y",y);
                    _context.startActivity(intent);
                }
                else if(groupPosition == 3){ // 닭발
                    Intent intent = new Intent(_context,
                            FoodRecommendWebActivity.class);
                    String[] Name = {
                            "Jaegune dakbal",
                            "Yeopgikkomdakbal",
                            "Kkangtongdakgalbi",
                            "Bullandakbal",
                            "Hansinpocha"
                    };
                    String[] Address = {
                            "Seoul Jung-gu Sindang-dong 132-33",
                            "Seoul Seongdong-gu Doseon-dong 50",
                            "Seoul Gwanak-gu Sillim-dong 1433-69",
                            "Seoul-si Gwangjin-gu Guui-dong 246-16",
                            "Seoul-si Gangnam-gu Nonhyeon-dong 182-29 "
                    };
                    String[] Money = {
                            "10,000won",
                            "10,000won",
                            "9,000won",
                            "18,000won",
                            "11,500won"
                    };
                    String[] Number = {
                            "02-2236-5143",
                            "02-2299-3838",
                            "02-873-7770",
                            "02-458-3000",
                            "02-515-3199"
                    };
                    String[] x = {
                            "37.564687",
                            "37.562790",
                            "37.484885",
                            "37.537510",
                            "37.506972"
                    };
                    String[] y = {
                            "127.019648",
                            "127.034272",
                            "126.927801",
                            "127.083962",
                            "127.024490"
                    };
                    intent.putExtra("Name",Name);
                    intent.putExtra("Address",Address);
                    intent.putExtra("Money",Money);
                    intent.putExtra("Number",Number);
                    intent.putExtra("x",x);
                    intent.putExtra("y",y);
                    _context.startActivity(intent);
                }
                else if(groupPosition == 4){ // 설렁탕
                    Intent intent = new Intent(_context,
                            FoodRecommendWebActivity.class);
                    String[] Name = {
                            "Hadonggwan",
                            "imunseollongtang",
                            "musuok",
                            "janganjeong",
                            "yeongdongseolleongtang"
                    };
                    String[] Address = {
                            "Seoul Jung-gu Myeongdong1-ga 10-4",
                            "Seoul Jongno-gu Gyeonji-dong 88",
                            "Seoul Dobonggo Dobong-dong 600-4",
                            "Seoul Dongdaemun-gu Jangan-dong 334-3",
                            "Seoul-si Seocho-gu Jamwon-dong 10-53"
                    };
                    String[] Money = {
                            "9,000won",
                            "9,000won",
                            "9,000won",
                            "8,000won",
                            "9,000won"
                    };
                    String[] Number = {
                            "02-776-5656",
                            "02-733-6526",
                            "02-954-6292",
                            "02-352-0303",
                            "02-543-4716"
                    };
                    String[] x = {
                            "37.564544",
                            "37.572857",
                            "37.677291",
                            "37.571878",
                            "37.516285"
                    };
                    String[] y = {
                            "126.985061",
                            "126.983918",
                            "127.044249",
                            "127.075241",
                            "127.017352"
                    };
                    intent.putExtra("Name",Name);
                    intent.putExtra("Address",Address);
                    intent.putExtra("Money",Money);
                    intent.putExtra("Number",Number);
                    intent.putExtra("x",x);
                    intent.putExtra("y",y);
                    _context.startActivity(intent);
                }
                else if(groupPosition == 5){ // 장어
                    Intent intent = new Intent(_context,
                            FoodRecommendWebActivity.class);
                    String[] Name = {
                            "Marusim",
                            "wangjajangeo",
                            "geomdanyangman",
                            "ilmijangeo",
                            "pungcheonjangeo"
                    };
                    String[] Address = {
                            "Seoul-si Seocho-gu Banpo-dong 54-10",
                            "Seoul Gangnam-gu Sinsa-dong 646-16",
                            "Seoul Songpa-gu Jamsil-dong 187-12",
                            "Seoul-si Yongsan-gu Dongja-dong 35-44",
                            "Seoul-si Mapo-gu Yeonnam-dong 568-25"
                    };
                    String[] Money = {
                            "36,000won",
                            "25,000won",
                            "33,000won",
                            "30,000won",
                            "56,000won"
                    };
                    String[] Number = {
                            "02-592-8998",
                            "070-4418-2551",
                            "02-3431-9555",
                            "02-777-4380",
                            "02-332-8361"
                    };
                    String[] x = {
                            "37.502126",
                            "37.525795",
                            "37.510179",
                            "37.552314",
                            "37.559633"
                    };
                    String[] y = {
                            "127.010472",
                            "127.036582",
                            "127.083646",
                            "126.974373",
                            "126.921603"
                    };
                    intent.putExtra("Name",Name);
                    intent.putExtra("Address",Address);
                    intent.putExtra("Money",Money);
                    intent.putExtra("Number",Number);
                    intent.putExtra("x",x);
                    intent.putExtra("y",y);
                    _context.startActivity(intent);
                }
                else if(groupPosition == 6){ // 오리
                    Intent intent = new Intent(_context,
                            FoodRecommendWebActivity.class);
                    String[] Name = {
                            "Munori",
                            "ssammani",
                            "podeok",
                            "gukdaeori",
                            "yuhwasu"
                    };
                    String[] Address = {
                            "Seoul Yongsan-gu Itaewon-dong 255-39",
                            "Seoul Mapo-gu Seogyo-dong 409-10",
                            "Seoul Jung-gu Myeongdong2-ga 2-5",
                            "Seoul Jongno-gu Jongno1-ga 24",
                            "Seoul Songpa-gu Munjeong-dong 59-11"
                    };
                    String[] Money = {
                            "40,000won",
                            "13,000won",
                            "33,000won",
                            "30,000won",
                            "39,000won"
                    };
                    String[] Number = {
                            "070-8153-5252",
                            "02-337-4248",
                            "02-755-5233",
                            "02-2075-5292",
                            "02-3789-8088"
                    };
                    String[] x = {
                            "37.541040",
                            "37.549447",
                            "37.563606",
                            "37.571035",
                            "37.484963"
                    };
                    String[] y = {
                            "126.990353",
                            "126.921655",
                            "126.985404",
                            "126.979864",
                            "127.123954"
                    };
                    intent.putExtra("Name",Name);
                    intent.putExtra("Address",Address);
                    intent.putExtra("Money",Money);
                    intent.putExtra("Number",Number);
                    intent.putExtra("x",x);
                    intent.putExtra("y",y);
                    _context.startActivity(intent);
                }
            }
        });
        return convertView;
    }

    //차일드 뷰의 사이즈 반환
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

    //그룹 뷰 생성(그룹 각 뷰의 ROW)
    boolean setColor = true;
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            viewHolder = new ViewHolder2();
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.foodrecommendlistrow1, null);
            viewHolder.iv_image = (ImageView) convertView.findViewById(R.id.foodrecommendlistrow1image1);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder2) convertView.getTag();
        }
        ImageView imageView = (ImageView)convertView.findViewById(R.id.foodrecommendlistrow1image1);
        TextView textView = (TextView)convertView.findViewById(R.id.foodrecommendlistrow1text1);
        String name = getGroup(groupPosition).toString();
        if(name == "short rib soup"){
            imageView.setImageResource(R.drawable.shortribsoup);
        }
        else if(name == "loach stew"){
            imageView.setImageResource(R.drawable.loachstew);
        }
        else if(name == "grilled clams"){
            imageView.setImageResource(R.drawable.grilledclams);
        }
        else if(name == "chicken feet"){
            imageView.setImageResource(R.drawable.chickenfeet);
        }
        else if(name == "ox bone soup"){
            imageView.setImageResource(R.drawable.oxbonesoup);
        }
        else if(name == "Eel"){
            imageView.setImageResource(R.drawable.eel);
        }
        else if(name == "duck"){
            imageView.setImageResource(R.drawable.duck);
        }
        else if(name == "ginkgo nut"){
            imageView.setImageResource(R.drawable.ginkgonut);
        }
        //그룹을 펼칠 때 또는 닫을 때 아이콘 변경
        TextView lblListHeader = (TextView) convertView.findViewById(R.id.foodrecommendlistrow1text1);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

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
    class ViewHolder2 {
        public ImageView iv_image;
        public LinearLayout laytest;
    }

}
