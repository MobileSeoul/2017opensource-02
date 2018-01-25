package com.example.masiro.dabamdaproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
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
 * Created by masiro on 2017-11-21.
 */

public class SeoulRecommendResExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    private ViewHolder3 viewHolder = null;

    public SeoulRecommendResExpandableListViewAdapter(Context context, List<String> listDataHeader,
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

        final String childText = (String) getChild(groupPosition, childPosition);
        String name = getGroup(groupPosition).toString();
        String name2 = getChild(groupPosition,childPosition).toString();
        TextView textView1 = null;
            if(name == "Snack stall" || name == "Busking"){
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.foodrecommendlistrow3, null);
                textView1 = (TextView)convertView.findViewById(R.id.foodrecommendlistrow3text1);
            }
            else if(name.equals("Bamiraseo haneun mal") || name.equals("Bami doenikka") ||
                    name.equals("Geuriwohada") ||name.equals("Bihaengun") ||
                    name.equals("Eotteoke jinae")){
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.foodrecommendlistrow6, null);
            }
            else{
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.foodrecommendlistrow2, null);
                textView1 = (TextView)convertView.findViewById(R.id.foodrecommendlistrow2text1);
            }


        if(name == "Myeongdong Kyoja"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Phone: +82-2-776-5348\n" +
                        "• Hours of Operation: 10:30 ~ 21:30\n" +
                        "• Days of Operation: Monday - Sunday\n" +
                                "• Signature: DishKal-guksu 8,000 won\n" +
                                "• Signature: Bibim Guksu 8,000 won \n" +
                                "• Signature: Dumplings 8,000 won\n\n" +
                                "• About: For a taste of authentic kal-guksu (noodle soup), visit Myeongdong Kyoja. The noodles here are made fresh with flour dough. The noodles here are both soft and chewy and the strong, savory flavors of the chicken broth will leave you wanting second helpings. After a visit here, you may not be able to get enough of kal-guksu!"
                );
            }
        }
        else if(name == "Gusto Taco"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: 121-837  41, Wausan-ro, Mapo-gu, Seoul\n" +
                        "• Phone: +82-2-338-8226\n" +
                                "• Hours of Operation: Tues~Sat: 11:30~22:00 Sun : 11:30~21:00\n" +
                                "• Days of Operation: Tuesday - Sunday\n\n" +
                                "• About: At Gusto Taco, you can enjoy warm tacos made by a graduate of a New York cooking school. The dishes are not complicated, but you should be prepared to wait as they make everything to order. It is quite a small place, so customers tend to order their food to go."
                );
            }
        }
        else if(name == "Maple Tree House Itaewon Branch"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: 140-201  26, Itaewon-ro 27ga-gil, Yongsan-gu, Seoul\n" +
                        "• Phone: +82-2-790-7977\n" +
                        "• Hours of Operation: 11:30~22:00\n" +
                        "• Holidays: Lunar New Year and Chuseok \n" +
                        "• Days of Operation: Monday - Sunday\n\n"+
                        "• About: At Maple Tree House, you can enjoy grilled pork or beef in a Western-style atmosphere. The interior is luxuriously decorated with trees. "
                );
            }
        }
        else if(name == "Jeong Sikdang"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: 06014  11, Seolleung-ro 158-gil, Gangnam-gu, Seoul, Korea\n" +
                        "• Phone: +82-2-517-4654\n" +
                        "• Hours of Operation: Lunch 12 p.m. - 3 p.m. Dinner 5:30 p.m. - 10 p.m.\n" +
                        "• Holidays: January 1st, Seollal and Chuseok\n" +
                        "• Days of Operation: Monday Tuesday Wednesday Thursday Friday Saturday Sunday\n\n" +
                        "• About: Opened by an ambitious chef who studied and worked in Spain, the United States, and elsewhere, Jeong Sikdang is the pioneer of a new style of cuisine: New Korean. Although still not fully formed, the style re-approaches Korean dishes from a French perspective. The plating is avant-garde, and the blending of Korean and Western cuisine is evident in their choice of ingredients and menu. Lunch and dinner are both served in one full-course set menu which changes every two or three months."
                );

            }
        }
        else if(name == "Pro soy Crab"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: 06526  9 Gangnam-daero 97-gil, Seocho-gu, Seoul\n" +
                        "• Phone: +82-2-543-4126\n" +
                        "• Hours of Operation: Open 24 hours\n" +
                        "• Open 24 Hours: Yes\n\n" +
                        "• About: Pro Soy Crab first opened in 1980 and it is considered by many to be Korea's foremost ganjang-gejang (soy sauce marinated crab) restaurant. Pro Soy Crab's main branch is located at Sinsa-dong but there is another location in Samseong-dong, Seoul. Pro Soy Crab uses only the freshest high-quality ingredients to create their crab and seafood dishes. Diners can enjoy a range of seafood such as ganjang-gejang (soy sauce marinated crab), yangnyeom-gejang (spicy marinated crab), kkotge jjim (braised blue crab), and sannakji (sliced raw octopus). In a fun design touch, the walls of the restaurant interior are decorated with photos and autographs of famous Korean baseball players and Hallyu stars."
                );
            }
        }
        else if(name == "National Geographic Photo Exhibition : Photo Ark"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Event Dates: Nov. 10, 2017 ~ Mar. 04, 2018\n" +
                        "• Address: War Memorial of Korea, 29 Itaewon-ro, Yongsan-gu, Seoul\n" +
                                "• Phone: +82-2-6263-2621\n" +
                                "• Hours of Operation: 10:00 - 18:00 (last entry 17:00)\n" +
                                "• Holidays: Closed Mondays*, Dec. 26th and Jan. 2nd (*exceptions are Dec. 25th and Jan. 1st, the museum will open on Christmas and New Year's Day)\n" +
                                "• Fee: - Adult: 15,000 won \n" +
                                "- Student (elementary, middle, high school): 11,000 won \n" +
                                "- Child (36 months and older): 9,000 won \n\n"+
                                "• About: See incredible photos from National Geographic at the War Memorial of Korea from Nov. 10th, 2017 through March 4th, 2018. This special photo exhibition, Photo Ark, is a veritable Noah's Ark of animals. Species all over the world are in danger of extinction and this exhibition is the result of National Geographic's quest to photograph every species in the world before they disappear. The photographs feature a wide range of animals, from the familiar to the exotic. Get a new perspective on the dangers facing the animals of the world at the Photo Ark exhibition in Seoul."
                );
            }
        }
        else if(name == "Hallyu Cooking Class"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Event Dates: Apr. 01, 2017 ~ Dec. 31, 2017\n" +
                                "• Address: Beksul Cooking Studio, 1F CJ CheilJedang headquarters (330 Dongho-ro, Jung-gu, Seoul)\n" +
                                "• Hours of Operation: Offered every second and fourth Thursday from 11:00 to 13:00 (schedule details are subject to minor changes)\n" +
                                "• Activity: Cooking demonstrations by professional chefs (20 min) + Hands-on cooking program for participants (60 min) + Sampling and tasting (40 min)\n" +
                                "• Fee: KRW 20,000/person (You can pay the fee at the Cooking Studio in cash - KRW)\n\n"+
                                "• About: See incredible photos from National Geographic at the War Memorial of Korea from Nov. 10th, 2017 through March 4th, 2018. This special photo exhibition, Photo Ark, is a veritable Noah's Ark of animals. Species all over the world are in danger of extinction and this exhibition is the result of National Geographic's quest to photograph every species in the world before they disappear. The photographs feature a wide range of animals, from the familiar to the exotic. Get a new perspective on the dangers facing the animals of the world at the Photo Ark exhibition in Seoul."
                );
            }
        }
        else if(name == "Hallyu Star Styling Class"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Event Dates: May to December, 2017\n" +
                                "• Address: Jenny House Chungdam Hill (16-1, Cheongdam-dong, Gangnam-gu, Seoul)\n" +
                                "• Hours of Operation: 5 to 7 p.m., every third Monday of the month\n" +
                                "• Activity: K-Beauty makeup class and hair and makeup styling (120 minutes)\n" +
                                "• Fee: Free\n\n"+
                                "• About: Here’s a special opportunity to visit the beauty salon used by Hallyu stars and learn some of their beauty secrets! Jenny House, which is responsible for the hair and makeup of Korea’s most prominent actresses and K-pop artists, is a famous beauty salon in Seoul that strives to maximize the natural beauty of its clients. The Hallyu Star Styling Class offers all participants tips on the latest cosmetics trends in addition to a chance to receive hair and makeup styling service to enhance their own look."
                );
            }
        }
        else if(name == "MBC World Broadcasting Theme Park Tour"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Event Dates and Time:  Every second and fourth Tuesday of each month, 10:00am~12:00pm(For the month of April, this program will get under way on April 20 Thu.)\n" +
                                "• Address: MBC World Broadcasting Theme Park (267 Seongam-ro, Mapo-gu, Seoul)\n" +
                                "• Hours of Operation:  5 to 7 p.m., every third Monday of the month(schedule may be subject to change)\n" +
                                "• Fee: Free\n\n"+
                                "• About: We recommend visiting ‘MBC World’ located inside MBC, a major broadcasting station in Korea, if you’re a ‘Hallyu’ tourist interested in TV programs including K-dramas and entertainment programs. You can have a special experience using various holographic techniques to become main characters in TV programs like ‘Moon Embracing the Sun’ and ‘We Got Married.'"
                );
            }
        }
        else if(name == "DDP LED rose garden"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Event Dates: 2015.04.18 ~ 2020.12.31\n" +
                                "• Address: Euljiro 281, Jung-gu, Seoul (Dongdaemun History and Culture Park)\n" +
                                "• Phone: +82-02-2153-0000\n" +
                                "• About: 25,550 spectacular rose gardens stand next to the Dongdaemun Design Plaza (DDP) The LED rose garden, which has been loved by citizens for the last year at DDP grass hills, welcomed citizens from the grass park next to the water gate exhibition from April 18th. You can stroll along the rose garden with loved ones such as family, friends, lovers and enjoy the beautiful night view. The total number of LED rose gardens was 25,550. This is the number that is multiplied by 70 to 365, and it is based on the wish that the Republic of Korea celebrates the 70th anniversary of liberation and enjoys it as a festival with the citizens of the world 365 days a year. It is the content of 'everyone's content' by taking a rose (the poll research announcement gallop) which has been ranked as the most favorite flower of the people for 20 years for the unchanging 20 years."
                );
            }
        }
        else if(name == "Gwanghwamun Square at Night"){
            if(childPosition == 0) {
                textView1.setText(
                                "• Address: 172, Sejong-daero, Jongno-gu, Seoul\n" +
                                "• Phone: +82-2-2133-8507\n\n" +
                                "• About: Gwanghwamun Square is located on Sejong-ro in Jongno-gu and is vast in size. Gwanghwamun Square stretches out from Gwanghwamun Gate, towards Cheonggyecheon Stream, and is divided into 6 sections: “Recovering the History of Gwanghwamun Gate Plaza,” “Reenacting Yukjo Street Plaza,” “Korea Main Plaza,” “Civil Participation Urban Culture Plaza,” “Downtown Plaza” and “Cheonggyecheon Stream Connector. In 2009, the square was redeveloped into a space of historical revival, culture, and relaxation. The focal point of the square is the statue of King Sejong the Great. During the day, the square is always busy with people but at night it is a tranquil and beautiful tourist attraction. Gwanghwamun Square, with Inwangsan Mountain just behind it, is not just a beautiful tourist locale. The square has over 600 years of history and it is a place where the spirit of the Korean nation can be felt."
                );
            }
        }
        else if(name == "Naksan Park at Night"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: Naksan-gu, Dongsung-dong, Jongno-gu, Seoul\n\n" +
                                "• About: Naksan Park, located in Jongo-gu, is a great place to see the Seoul City Wall and take in views of downtown Seoul. The park is famous for the beauty of its nighttime views and the city wall. Seoul during the Joseon Dynasty was smaller than it is today. At the time, there were four mountains that were contained within the city limits, Naksan Mountain being one of them. Of the four mountains, Naksan was the smallest at just over 100m tall. The city wall that is along Naksan Mountain is divided by Hyehwamun Gate, Dongdaemun Gate, and Daehak-ro.If you like to hike, take the Seoul City Wall trail from Hyehwamun to Dongdaemun or vice versa. If you prefer an easier route, begin your walk at Daehak-ro. Additionally, the park has been used as a filming location for many Hallyu dramas due to its beautiful scenary. Walk the old city wall and take in the beatiful twinkling lights of Seoul at Naksan Park."
                );
            }
        }
        else if(name == "Namsan Seoul Tower at Night"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: Seoul Yongsan-gu Yongsan 2-ga-dong Namsangongwon-gil 105\n\n" +
                                "• About: Seoul's representative landmark, Namsan Tower was reborn in 2005 as Namsan Seoul Tower. Namsan Seoul Tower has become a famous nighttime tourist attraction. There is a daily light show from 19:00 in the evening until midnight and the lights change color every hour. On the tower's 1st floor there is a Korean restaurant HanCook, on the 2nd floor is the Sky Cafe. The 3rd floor is the tower's observatory where you can enjoy panoramic views of Seoul. Namsan Seoul Tower is easily accessible and a place you can visit comfortably. One could even say it's a multi-purpose cultural space because of the variety of activities and facilities on-site. However, Namsan Seoul Tower may best be known as a romantic nighttime location. The observatory is the perfect place to have a date with that special someone."
                );
            }
        }
        else if(name == "Haneul Park at Night"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: Haneul Park, 95 Haneulgongwon-ro, Mapo-gu, Seoul\n\n" +
                                "• About: Of the five parks within the World Cup Park system in Mapo-gu, Haneul Park is the most beloved and popular. Haneul is the Korean word for \"sky\" and the park was dubbed Haneul Park because it has the highest elevation of the five parks. The area was once a landfill, but the park was subsequently transformed into an ecological park. Haneul Park is famous for its fields of tall pampas grass, sunset views, and night views of Seoul. The park is also popular as a date spot and as a location for photo shoots."
                );
            }
        }
        else if(name == "63 Square at Night"){
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: 50 63-ro, Yeongdeungpo-gu, Seoul\n" +
                                "• Hours of Operation: 63 Observatory: 10:00 - 22:00 (last entry: 21:30)\n\n" +
                                "• About: Enjoy beautiful panoramas of Seoul from the 63 Building's observatory. The observatory is an observation deck and gallery (known as 63 Art or 63 Sky Art). At 63 Sky Art, visitors can take in incredible views and amazing artworks. Make sure to stop by the Wishing Wall, where visitors can write their own wishes down and post them on the wall."
                );
            }
        }
        else if(name == "Gangbyeon 4hojeom"){ //포차
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: 50, Gangbyeonyeok-ro, Gwangjin-gu, Seoul\n" +
                                "• Hours of Operation: 16:00 - 02:00"
                );
            }
        }
        else if(name == "Seonine pocha"){ //포차
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: 129, Jong-ro, Jongno-gu, Seoul\n" +
                                "• Hours of Operation: 18:00 ~ 04:50"
                );
            }
        }
        else if(name == "Appane pocha"){ //포차
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: 203-1, Yeongdeungpo-ro, Yeongdeungpo-gu, Seoul\n" +
                                "• Hours of Operation: Weekdays 18:30 ~ 01: 10 / Fri, Sat 18:30 ~ 01:30 (Do not operate on Sundays)"
                );
            }
        }
        else if(name == "Hyeonseonine"){ //포차
            if(childPosition == 0) {
                textView1.setText(
                        "• Address: 20, Hangang-daero 39-gil, Yongsan-gu, Seoul\n" +
                                "• Hours of Operation: 10:00 ~ 00:00"
                );
            }
        }
        else if(name == "Snack stall"){ //포차
            if(childPosition == 0) {
                textView1.setText( // 포장마차 소개
                                "• About: The stall is a street stall selling Korean wagons and various street food. In the stand, we sell hoki, kimbap, tteokbokki, sundae, fish cake, tempura or sake and snacks. The stalls are a good place to simply eat sake or food at night. They can also stand quickly and eat, pack, and provide chairs to sit down while eating."
                );
            }
        }
        else if(name == "Busking"){ //포차
            if(childPosition == 0) {
                textView1.setText( // 포장마차 소개
                        "• About: Busking is derived from busk, meaning to perform in the streets, which means to perform freely on the streets. Buskers call busking buskers, buskers carry musical instruments, small microphones, portable amps, etc., and communicate with the audience through the streets and enjoy music. In Korea, bus kings are mainly active in Hongdae, Daehakro and Sinchon."
                );
            }
        }
        else if(name == "Hongdae"){
            if(childPosition == 0) {
                textView1.setText(
                        "• About: It is the most representative area for bus kings in Korea."
                );
            }
        }
        else if(name == "Daehangno"){
            if(childPosition == 0) {
                textView1.setText(
                        "• About: It was the first place where bus kings were started in Korea."
                );
            }
        }
        else if(name == "Sinchon"){
            if(childPosition == 0) {
                textView1.setText(
                        "• About: Yonsei, located in Shinchon, can be seen on the streets performing on the street because cars do not drive on weekends"
                );
            }
        }
        else if(name == "Hanganggongwon"){
            if(childPosition == 0) {
                textView1.setText(
                        "• About: Bus kings are also held at Yeouido Han River Citizen Park near Yeouinaru Station. Sometimes it happens in Ttukseom Amusement Park. Bus kings also take place in the Dorimchun waterfront area at the exit of Boramae Park or Slim Station."
                );
            }
        }

        if(name != "Snack stall" && name != "Busking" && name != "Bamiraseo haneun mal"
                && name != "Bami doenikka"&& name != "Geuriwohada"&& name != "Bihaengun"
                && name != "Eotteoke jinae") {
            final Button button1 = (Button) convertView.findViewById(R.id.foodrecommendlistrow2button1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getGroup(groupPosition).toString().equals("Myeongdong Kyoja")) { // 이름으로 조건
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Myeongdong Kyoja");
                        intent.putExtra("x", "37.562781");
                        intent.putExtra("y", "126.985785");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Gusto Taco")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Gusto Taco");
                        intent.putExtra("x", "37.548225");
                        intent.putExtra("y", "126.922833");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Maple Tree House Itaewon Branch")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Maple Tree House Itaewon Branch");
                        intent.putExtra("x", "37.535309");
                        intent.putExtra("y", "126.993756");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Jeong Sikdang")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Jeong Sikdang");
                        intent.putExtra("x", "37.525941");
                        intent.putExtra("y", "127.041138");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Pro soy Crab")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Pro soy Crab");
                        intent.putExtra("x", "37.514839");
                        intent.putExtra("y", "127.019080");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("National Geographic Photo Exhibition : Photo Ark")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "National Geographic Photo Exhibition : Photo Ark");
                        intent.putExtra("x", "37.541831");
                        intent.putExtra("y", "126.977122");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Hallyu Cooking Class")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Hallyu Cooking Class");
                        intent.putExtra("x", "37.564231");
                        intent.putExtra("y", "127.003321");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Hallyu Star Styling Class")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Hallyu Star Styling Class");
                        intent.putExtra("x", "37.521623");
                        intent.putExtra("y", "127.044218");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("MBC World Broadcasting Theme Park Tour")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "MBC World Broadcasting Theme Park Tour");
                        intent.putExtra("x", "37.581332");
                        intent.putExtra("y", "126.891250");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("DDP LED rose garden")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "DDP LED rose garden");
                        intent.putExtra("x", "37.565391");
                        intent.putExtra("y", "127.007808");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Gwanghwamun Square at Night")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Gwanghwamun Square");
                        intent.putExtra("x", "37.576077");
                        intent.putExtra("y", " 126.976867");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Naksan Park at Night")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Naksan Park at Night");
                        intent.putExtra("x", "37.553605");
                        intent.putExtra("y", "126.989686");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Namsan Seoul Tower at Night")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Namsan Seoul Tower at Night");
                        intent.putExtra("x", "37.551487");
                        intent.putExtra("y", "126.988298");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Haneul Park at Night")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Haneul Park at Night");
                        intent.putExtra("x", "37.568283");
                        intent.putExtra("y", "126.884887");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("63 Square at Night")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "63 Square at Night");
                        intent.putExtra("x", "37.519552");
                        intent.putExtra("y", "126.940167");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Gangbyeon 4hojeom")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Gangbyeon 4hojeom");
                        intent.putExtra("x", "37.536451");
                        intent.putExtra("y", "127.094958");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Seonine pocha")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Seonine pocha");
                        intent.putExtra("x", "37.571731");
                        intent.putExtra("y", "126.991797");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Appane pocha")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Appane pocha");
                        intent.putExtra("x", "37.520424");
                        intent.putExtra("y", "126.904203");
                        _context.startActivity(intent);
                    } else if (getGroup(groupPosition).toString().equals("Hyeonseonine")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Hyeonseonine");
                        intent.putExtra("x", "37.530867");
                        intent.putExtra("y", "126.968355");
                        _context.startActivity(intent);
                    }
                    else if (getGroup(groupPosition).toString().equals("Hongdae")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Hongdae");
                        intent.putExtra("x", "37.557770");
                        intent.putExtra("y", "126.924433");
                        _context.startActivity(intent);
                    }
                    else if (getGroup(groupPosition).toString().equals("Daehangno")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Daehangno");
                        intent.putExtra("x", "37.576046");
                        intent.putExtra("y", "127.001062");
                        _context.startActivity(intent);
                    }
                    else if (getGroup(groupPosition).toString().equals("Sinchon")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Sinchon");
                        intent.putExtra("x", "37.559826");
                        intent.putExtra("y", "126.942277");
                        _context.startActivity(intent);
                    }
                    else if (getGroup(groupPosition).toString().equals("Hanganggongwon")) {
                        Intent intent = new Intent(_context,
                                SeoulRecommendResWebActivity.class);
                        intent.putExtra("Name", "Hanganggongwon");
                        intent.putExtra("x", "37.530950");
                        intent.putExtra("y", "126.928298");
                        _context.startActivity(intent);
                    }
                }
            });
        }
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
            viewHolder = new ViewHolder3();
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.foodrecommendlistrow1, null);
            viewHolder.iv_image = (ImageView) convertView.findViewById(R.id.foodrecommendlistrow1image1);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder3) convertView.getTag();
        }
        ImageView imageView = (ImageView)convertView.findViewById(R.id.foodrecommendlistrow1image1);
        String name = getGroup(groupPosition).toString();

        if(name == "Myeongdong Kyoja"){
            imageView.setImageResource(R.drawable.myeongdongkyoja);
        }
        else if(name == "Gusto Taco"){
            imageView.setImageResource(R.drawable.gustotaco);
        }
        else if(name == "Maple Tree House Itaewon Branch"){
            imageView.setImageResource(R.drawable.mapletreehouseitaewonbranch);
        }
        else if(name == "Jeong Sikdang"){
            imageView.setImageResource(R.drawable.jeongsikdang);
        }
        else if(name == "Pro soy Crab"){
            imageView.setImageResource(R.drawable.prosoycrab);
        }
        else if(name == "National Geographic Photo Exhibition : Photo Ark"){
            imageView.setImageResource(R.drawable.festivalphoto);
        }
        else if(name == "Hallyu Cooking Class"){
            imageView.setImageResource(R.drawable.festivalcooking);
        }
        else if(name == "Hallyu Star Styling Class"){
            imageView.setImageResource(R.drawable.festivalmakeup);
        }
        else if(name == "MBC World Broadcasting Theme Park Tour"){
            imageView.setImageResource(R.drawable.festivalmbc);
        }
        else if(name == "DDP LED rose garden"){
            imageView.setImageResource(R.drawable.festivalled);
        }
        else if(name == "Gwanghwamun Square at Night"){
            imageView.setImageResource(R.drawable.nightgawng);
        }
        else if(name == "Naksan Park at Night"){
            imageView.setImageResource(R.drawable.nightnaksan);
        }
        else if(name == "Namsan Seoul Tower at Night"){
            imageView.setImageResource(R.drawable.nightnamsan);
        }
        else if(name == "Haneul Park at Night"){
            imageView.setImageResource(R.drawable.nighthaneul);
        }
        else if(name == "63 Square at Night"){
            imageView.setImageResource(R.drawable.nightbuilding);
        }
        else if(name == "Bamiraseo haneun mal"){
            imageView.setImageResource(R.drawable.bammal);
        }
        else if(name == "Bami doenikka"){
            imageView.setImageResource(R.drawable.bampunch);
        }
        else if(name == "Geuriwohada"){
            imageView.setImageResource(R.drawable.gue);
        }
        else if(name == "Bihaengun"){
            imageView.setImageResource(R.drawable.bihangun);
        }
        else if(name == "Eotteoke jinae"){
            imageView.setImageResource(R.drawable.udd);
        }
        else if(name == "Snack stall"){
            imageView.setImageResource(R.drawable.snackstall);
        }
        else if(name == "Gangbyeon 4hojeom"){
            imageView.setImageResource(R.drawable.gang);
        }
        else if(name == "Seonine pocha"){
            imageView.setImageResource(R.drawable.sun);
        }
        else if(name == "Appane pocha"){
            imageView.setImageResource(R.drawable.father);
        }
        else if(name == "Hyeonseonine"){
            imageView.setImageResource(R.drawable.hyeon);
        }
        else if(name == "Busking"){
            imageView.setImageResource(R.drawable.busking);
        }
        else if(name == "Hongdae"){
            imageView.setImageResource(R.drawable.hong);
        }
        else if(name == "Daehangno"){
            imageView.setImageResource(R.drawable.dae);
        }
        else if(name == "Sinchon"){
            imageView.setImageResource(R.drawable.sin);
        }
        else if(name == "Hanganggongwon"){
            imageView.setImageResource(R.drawable.han);
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
    class ViewHolder3 {
        public ImageView iv_image;
        public LinearLayout laytest;
    }
}
