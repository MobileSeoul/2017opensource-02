package com.example.masiro.dabamdaproject;

/**
 * Created by masiro on 2017-11-27.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectActivity extends Fragment {
    public SelectActivity(){

    }
    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader = null;
    private HashMap<String, List<String>> listDataChild = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_selectpage, container, false);
        // 확장 리스트뷰를 가져온다.
        expListView = (ExpandableListView) layout.findViewById(R.id.SelectPageExpandableListView);

        // 리스트뷰에 데이터를 넣는 곳.
        ChildListData();

        listAdapter = new SelectActivityExpandableListViewAdapter(layout.getContext(), listDataHeader, listDataChild);

        // 리스트어댑터 세팅
        expListView.setAdapter(listAdapter);

        // 차일드 뷰를 눌렀을 경우 이벤트 발생
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Food recommendation"){ // 클릭 조건만들고 씬 연결, 축제 만들고, 음식 추천 만들고, 영화 넣고 - 이번주말안에 밤새서라도
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            FoodRecomendActivity.class); // 다음 넘어갈 클래스 지정
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Rest recommendation"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            SeoulRecommendResActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("ListSelect", "Rest recommendation");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "A good restaurant"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            FoodActivity.class); // 다음 넘어갈 클래스 지정
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Festival recommended"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            SeoulRecommendResActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("ListSelect", "Festival recommended");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Concert"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            FestivalWebActivity.class); // 다음 넘어갈 클래스 지정
                    String a = "http://openAPI.seoul.go.kr:8088/564d43485a793337373352506c5261/xml/SearchPerformanceBySubjectService/1/15/1/";
                    intent.putExtra("URL", a);
                    intent.putExtra("Type", "Concert");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Classic"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            FestivalWebActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("URL",
                            "http://openAPI.seoul.go.kr:8088/564d43485a793337373352506c5261/xml/SearchPerformanceBySubjectService/1/15/2/");
                    intent.putExtra("Type", "Classic");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Musical"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            FestivalWebActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("URL",
                            "http://openAPI.seoul.go.kr:8088/564d43485a793337373352506c5261/xml/SearchPerformanceBySubjectService/1/15/3/");
                    intent.putExtra("Type", "Musical");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Theater"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            FestivalWebActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("URL",
                            "http://openAPI.seoul.go.kr:8088/564d43485a793337373352506c5261/xml/SearchPerformanceBySubjectService/1/15/5/");
                    intent.putExtra("Type", "Theater");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Dancing"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            FestivalWebActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("URL",
                            "http://openAPI.seoul.go.kr:8088/564d43485a793337373352506c5261/xml/SearchPerformanceBySubjectService/1/15/6/");
                    intent.putExtra("Type", "Dancing");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Art"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            FestivalWebActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("URL",
                            "http://openAPI.seoul.go.kr:8088/564d43485a793337373352506c5261/xml/SearchPerformanceBySubjectService/1/15/7/");
                    intent.putExtra("Type", "Art");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "A recital"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            FestivalWebActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("URL",
                            "http://openAPI.seoul.go.kr:8088/564d43485a793337373352506c5261/xml/SearchPerformanceBySubjectService/1/15/17/");
                    intent.putExtra("Type", "A recital");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Late night movie"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            MovieActivity.class); // 다음 넘어갈 클래스 지정
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "The night view of Seoul"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            SeoulRecommendResActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("ListSelect", "The night view of Seoul");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Night Music List"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            SeoulRecommendResActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("ListSelect", "Night Music List");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Snack stall"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            SeoulRecommendResActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("ListSelect", "Snack stall");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Busking"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            SeoulRecommendResActivity.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("ListSelect", "Busking");
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "Wifi"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            WifiActivity.class); // 다음 넘어갈 클래스 지정
                    startActivity(intent);
                }
                else if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) == "public restroom"){
                    Intent intent = new Intent(
                            layout.getContext(), // 현재 화면의 제어권자
                            WifiActivity.class); // 다음 넘어갈 클래스 지정
                    startActivity(intent);
                }
                return false;
            }
        });
        return layout;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 부모 뷰 타이틀 및 차일드 뷰 데이터 넣는 곳
     */
    private void ChildListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // 그룹 생성
        listDataHeader.add("Food");
        listDataHeader.add("Festival");
        listDataHeader.add("NightView");
        listDataHeader.add("Movie");
        listDataHeader.add("Music");
        listDataHeader.add("Street");
        listDataHeader.add("Facilities");

        // 그룹 내 차일드 뷰 생성
        List<String> Food = new ArrayList<String>();
        Food.add("Food recommendation");
        Food.add("Rest recommendation");
        Food.add("A good restaurant");

        List<String> Festival = new ArrayList<String>();
        Festival.add("Festival recommended");
        Festival.add("Concert");
        Festival.add("Classic");
        Festival.add("Musical");
        Festival.add("Theater");
        Festival.add("Dancing");
        Festival.add("Art");
        Festival.add("A recital");

        List<String> NightView = new ArrayList<String>();
        NightView.add("The night view of Seoul");

        List<String> Movie = new ArrayList<String>();
        Movie.add("Late night movie");

        List<String> Music = new ArrayList<String>();
        Music.add("Night Music List");

        List<String> Street = new ArrayList<String>();
        Street.add("Snack stall");
        Street.add("Busking");

        List<String> Recital = new ArrayList<String>();
        Recital.add("Wifi");
        Recital.add("public restroom");

        //데이터 적용.
        listDataChild.put(listDataHeader.get(0), Food);
        listDataChild.put(listDataHeader.get(1), Festival);
        listDataChild.put(listDataHeader.get(2), NightView);
        listDataChild.put(listDataHeader.get(3), Movie);
        listDataChild.put(listDataHeader.get(4), Music);
        listDataChild.put(listDataHeader.get(5), Street);
        listDataChild.put(listDataHeader.get(6), Recital);
    }

}
