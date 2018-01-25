package com.example.masiro.dabamdaproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by masiro on 2017-11-27.
 */

public class SelectActivityExpandableListViewAdapter extends BaseExpandableListAdapter{
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    private ViewHolder viewHolder = null;

    public SelectActivityExpandableListViewAdapter(Context context, List<String> listDataHeader,
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

    String color[] = {"#C00E53", "#D52B43", "#E46858", "#E4986E", "#B488A9", "#876EB4", "#573F8D"};
    //차일드 뷰 생성(각 차일드 뷰의 (ROW)
    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {

            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.selectactivityexpandablelistrow1, null);
        }
        convertView.setBackgroundColor(Color.parseColor(color[groupPosition]));
        TextView txtListChild = (TextView)  convertView.findViewById(R.id.SelectPageRistRow1TextView1);

        txtListChild.setText(childText);

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
    String color2[] = {"#E24382", "#F15E74", "#FA8C7E", "#F9B895", "#C7ABC1", "#9F8BC3", "#7967A4"};
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.selectactivityexpandablelistrow2, null);
            viewHolder.iv_image = (ImageView) convertView.findViewById(R.id.SelectPageRistRow2ImageView1);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        parent.setBackgroundColor(Color.parseColor("#000000"));
        convertView.setBackgroundColor(Color.parseColor(color2[groupPosition]));

        ImageView imageviews = (ImageView) convertView.findViewById(R.id.SelectPageRistRow2ImageView1);
        String name = getGroup(groupPosition).toString();
        if(name == "Food") {
            imageviews.setImageResource(R.drawable.food);
        }
        else if(name == "Festival"){
            imageviews.setImageResource(R.drawable.festival);
        }
        else if(name == "NightView"){
            imageviews.setImageResource(R.drawable.nightview);
        }
        else if(name == "Movie"){
            imageviews.setImageResource(R.drawable.movie);
        }
        else if(name == "Music"){
            imageviews.setImageResource(R.drawable.music);
        }
        else if(name == "Street"){
            imageviews.setImageResource(R.drawable.street);
        }
        else if(name == "Facilities"){
            imageviews.setImageResource(R.drawable.fac);
        }
        //그룹을 펼칠 때 또는 닫을 때 아이콘 변경
        TextView lblListHeader = (TextView) convertView.findViewById(R.id.SelectPageRistRow2TextView1);
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
    class ViewHolder {
        public ImageView iv_image;
        public LinearLayout laytest;
    }
}
