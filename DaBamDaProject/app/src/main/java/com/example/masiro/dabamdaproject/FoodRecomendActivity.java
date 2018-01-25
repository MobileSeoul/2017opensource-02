package com.example.masiro.dabamdaproject;

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
 * Created by masiro on 2017-11-19.
 */

public class FoodRecomendActivity extends AppCompatActivity{

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader = null;
    private HashMap<String, List<String>> listDataChild = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodrecommend);

        // 확장 리스트뷰를 가져온다.
        expListView = (ExpandableListView) findViewById(R.id.FoodRecommnedExpandableListView);

        // 리스트뷰에 데이터를 넣는 곳.
        ChildListData();

        listAdapter = new FoodRecommendExpandableListViewAdapter(this, listDataHeader, listDataChild);

        // 리스트어댑터 세팅
        expListView.setAdapter(listAdapter);

    }
    private void ChildListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        if(true){ // 겨울 데이터
            listDataHeader.add("short rib soup");
            listDataHeader.add("loach stew");
            listDataHeader.add("grilled clams");
            listDataHeader.add("chicken feet");
            listDataHeader.add("ox bone soup");
            listDataHeader.add("Eel");
            listDataHeader.add("duck");

            List<String> Food = new ArrayList<String>();
            Food.add("1");

            //데이터 적용
            listDataChild.put(listDataHeader.get(0), Food);
            listDataChild.put(listDataHeader.get(1), Food);
            listDataChild.put(listDataHeader.get(2), Food);
            listDataChild.put(listDataHeader.get(3), Food);
            listDataChild.put(listDataHeader.get(4), Food);
            listDataChild.put(listDataHeader.get(5), Food);
            listDataChild.put(listDataHeader.get(6), Food);
        }
        // 그룹 내 차일드 뷰 생성
    }

}
