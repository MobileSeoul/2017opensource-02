package com.example.masiro.dabamdaproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by masiro on 2017-11-21.
 */

public class SeoulRecommendResActivity extends AppCompatActivity {
    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader = null;
    private HashMap<String, List<String>> listDataChild = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seoulrecommendres);

        // 확장 리스트뷰를 가져온다.
        expListView = (ExpandableListView) findViewById(R.id.SeoulRecommendResExpandableListView);

        // 리스트뷰에 데이터를 넣는 곳.
        ChildListData();

        listAdapter = new SeoulRecommendResExpandableListViewAdapter(this, listDataHeader, listDataChild);

        // 리스트어댑터 세팅
        expListView.setAdapter(listAdapter);

        // 리스트뷰 그룹(부모)뷰를 클릭 했을 경우
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                if(listDataHeader.get(groupPosition) == "Bamiraseo haneun mal") { // 클릭 조건만들고 씬 연결, 축제 만들고, 음식 추천 만들고, 영화 넣고 - 이번주말안에 밤새서라도
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=vk93wZVp_r0"));
                    startActivity(intent);
                }
                if(listDataHeader.get(groupPosition) == "Bami doenikka"){ // 클릭 조건만들고 씬 연결, 축제 만들고, 음식 추천 만들고, 영화 넣고 - 이번주말안에 밤새서라도
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "https://www.youtube.com/watch?v=KVU0h2bnDRE"  ));
                    startActivity(intent);
                }
                if(listDataHeader.get(groupPosition) == "Geuriwohada"){ // 클릭 조건만들고 씬 연결, 축제 만들고, 음식 추천 만들고, 영화 넣고 - 이번주말안에 밤새서라도
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "https://www.youtube.com/watch?v=4bykFvnRzno"  ));
                    startActivity(intent);
                }
                if(listDataHeader.get(groupPosition) == "Bihaengun"){ // 클릭 조건만들고 씬 연결, 축제 만들고, 음식 추천 만들고, 영화 넣고 - 이번주말안에 밤새서라도
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "https://www.youtube.com/watch?v=FvOBwRWaGZg"  ));
                    startActivity(intent);
                }
                if(listDataHeader.get(groupPosition) == "Eotteoke jinae"){ // 클릭 조건만들고 씬 연결, 축제 만들고, 음식 추천 만들고, 영화 넣고 - 이번주말안에 밤새서라도
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "https://www.youtube.com/watch?v=FNnYIIdTBhQ"  ));
                    startActivity(intent);
                }
                return false;
            }
        });
    }
    private void ChildListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        String ListSelect = "";
        Intent intent = getIntent();
        ListSelect = intent.getExtras().getString("ListSelect");

        if(ListSelect.equals("Rest recommendation")){
            listDataHeader.add("Myeongdong Kyoja");
            listDataHeader.add("Gusto Taco");
            listDataHeader.add("Maple Tree House Itaewon Branch");
            listDataHeader.add("Jeong Sikdang");
            listDataHeader.add("Pro soy Crab");

            List<String> Food = new ArrayList<String>();
            Food.add("1");

            //데이터 적용
            listDataChild.put(listDataHeader.get(0), Food);
            listDataChild.put(listDataHeader.get(1), Food);
            listDataChild.put(listDataHeader.get(2), Food);
            listDataChild.put(listDataHeader.get(3), Food);
            listDataChild.put(listDataHeader.get(4), Food);
        }
        else if(ListSelect.equals("Festival recommended")){
            listDataHeader.add("National Geographic Photo Exhibition : Photo Ark");
            listDataHeader.add("Hallyu Cooking Class");
            listDataHeader.add("Hallyu Star Styling Class");
            listDataHeader.add("MBC World Broadcasting Theme Park Tour");
            listDataHeader.add("DDP LED rose garden");

            List<String> Food = new ArrayList<String>();
            Food.add("1");

            //데이터 적용
            listDataChild.put(listDataHeader.get(0), Food);
            listDataChild.put(listDataHeader.get(1), Food);
            listDataChild.put(listDataHeader.get(2), Food);
            listDataChild.put(listDataHeader.get(3), Food);
            listDataChild.put(listDataHeader.get(4), Food);
        }
        else if(ListSelect.equals("The night view of Seoul")){
            listDataHeader.add("Gwanghwamun Square at Night");
            listDataHeader.add("Naksan Park at Night");
            listDataHeader.add("Namsan Seoul Tower at Night");
            listDataHeader.add("Haneul Park at Night");
            listDataHeader.add("63 Square at Night");

            List<String> Food = new ArrayList<String>();
            Food.add("1");

            //데이터 적용
            listDataChild.put(listDataHeader.get(0), Food);
            listDataChild.put(listDataHeader.get(1), Food);
            listDataChild.put(listDataHeader.get(2), Food);
            listDataChild.put(listDataHeader.get(3), Food);
            listDataChild.put(listDataHeader.get(4), Food);
        }
        else if(ListSelect.equals("Night Music List")){
            listDataHeader.add("Bamiraseo haneun mal");
            listDataHeader.add("Bami doenikka");
            listDataHeader.add("Geuriwohada");
            listDataHeader.add("Bihaengun");
            listDataHeader.add("Eotteoke jinae");

            List<String> Food = new ArrayList<String>();
            Food.add("");

            //데이터 적용
            listDataChild.put(listDataHeader.get(0), Food);
            listDataChild.put(listDataHeader.get(1), Food);
            listDataChild.put(listDataHeader.get(2), Food);
            listDataChild.put(listDataHeader.get(3), Food);
            listDataChild.put(listDataHeader.get(4), Food);
        }
        else if(ListSelect.equals("Snack stall")){
            listDataHeader.add("Snack stall");
            listDataHeader.add("Gangbyeon 4hojeom");
            listDataHeader.add("Seonine pocha");
            listDataHeader.add("Appane pocha");
            listDataHeader.add("Hyeonseonine");

            List<String> Food = new ArrayList<String>();
            Food.add("1");

            //데이터 적용
            listDataChild.put(listDataHeader.get(0), Food);
            listDataChild.put(listDataHeader.get(1), Food);
            listDataChild.put(listDataHeader.get(2), Food);
            listDataChild.put(listDataHeader.get(3), Food);
            listDataChild.put(listDataHeader.get(4), Food);
        }
        else if(ListSelect.equals("Busking")){
            listDataHeader.add("Busking");
            listDataHeader.add("Hongdae");
            listDataHeader.add("Daehangno");
            listDataHeader.add("Sinchon");
            listDataHeader.add("Hanganggongwon");

            List<String> Food = new ArrayList<String>();
            Food.add("1");

            //데이터 적용
            listDataChild.put(listDataHeader.get(0), Food);
            listDataChild.put(listDataHeader.get(1), Food);
            listDataChild.put(listDataHeader.get(2), Food);
            listDataChild.put(listDataHeader.get(3), Food);
            listDataChild.put(listDataHeader.get(4), Food);
        }
        // 그룹 내 차일드 뷰 생성
    }
}
