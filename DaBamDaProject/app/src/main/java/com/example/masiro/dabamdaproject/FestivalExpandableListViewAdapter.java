package com.example.masiro.dabamdaproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.text.LocaleDisplayNames;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * Created by masiro on 2017-11-22.
 */

public class FestivalExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context _context = null;
    private List<String> _listDataHeader = null; // header titles

    String mTitle = "";
    String mStartDate = "";
    String mEndDate = "";
    String mAddress = "";
    String mImageUrl = "";
    String mType = "";
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild = null;
    private ViewHolder5 viewHolder = null;

    public FestivalExpandableListViewAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listChildData,
                                             String Title, String StartDate, String EndDate, String Address, String ImageUrl, String Type) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this.mTitle = Title;
        this.mStartDate = StartDate;
        this.mEndDate = EndDate;
        this.mAddress = Address;
        this.mImageUrl = ImageUrl;
        this.mType = Type;
    }
    //차일드 뷰 반환
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosition);
    }
    //차일드 뷰 ID 반환
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.foodrecommendlistrow3, null);
        }
        TextView txtListChild = (TextView)  convertView.findViewById(R.id.foodrecommendlistrow3text1);

        String s = "Address: " + mAddress.split("\\^")[groupPosition] + "\n"
                + "StartDate: " + mStartDate.split("\\^")[groupPosition] + "\n"
                + "EndDate: " + mEndDate.split("\\^")[groupPosition];

        txtListChild.setText(s);

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

    boolean a = true;
    Bitmap bitmap = null;

    ImageView imageviews = null;
    TextView lblListHeader = null;

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);

        viewHolder = new ViewHolder5();
        LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = infalInflater.inflate(R.layout.foodrecommendlistrow5, null);
        convertView.setTag(viewHolder);
        imageviews = (ImageView) convertView.findViewById(R.id.foodrecommendlistrow5image5);
        lblListHeader = (TextView) convertView.findViewById(R.id.foodrecommendlistrow5text5);

        String name = getGroup(groupPosition).toString();

        String Title = mTitle.split("\\^")[groupPosition].toString();

        if(name.equals(Title)) {
            //이미지 set
            //FestivalWebActivity.ImageUrl.get(groupPosition);
            try{
                Picasso.with(_context)
                        .load(mImageUrl.split("\\^")[groupPosition])
                        .into(imageviews);
                imageviews.setScaleType(ImageView.ScaleType.FIT_CENTER);
               /* imageviews.setImageBitmap(bitmap);*/
                lblListHeader.setText(headerTitle);
                lblListHeader.setTypeface(null, Typeface.BOLD);
            }catch (Exception e){
                Log.e("Test", e.toString());
            }
        }
        //그룹을 펼칠 때 또는 닫을 때 아이콘 변경
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
    class ViewHolder5 {
        public ImageView iv_image;
        public LinearLayout laytest;
    }
}
