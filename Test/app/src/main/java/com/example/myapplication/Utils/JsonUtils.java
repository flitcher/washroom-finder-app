package com.example.myapplication.Utils;

import android.content.Context;

import com.example.myapplication.Model.Washroom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static List<Washroom> parseWashroomJsonFile (String json) {
        List<Washroom> washrooms = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);;
            JSONArray jsonArray = jsonObject.getJSONArray("washrooms");
            System.out.println(jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i++) {
                Washroom washroom = new Washroom();
                JSONObject fieldInfo = jsonArray.getJSONObject(i).getJSONObject("fields");

//                washroom.setMaintainer(checkNull(fieldInfo.getString("maintainer")));
//                washroom.setName(checkNull(fieldInfo.getString("name")));
//                washroom.setWheel_access(checkNull(fieldInfo.getString("wheel_access")));
//                washroom.setPrimaryind(checkNull(fieldInfo.getString("primaryind")));
//                washroom.setNote(checkNull(fieldInfo.getString("note")));
//                washroom.setSummer_hours(checkNull(fieldInfo.getString("summer_hours")));

                JSONObject geomInfo = fieldInfo.getJSONObject("geom");
                washroom.setGeon_type(checkNull(geomInfo.getString("type")));

                JSONArray coordinates = geomInfo.getJSONArray("coordinates");
                double[] coord = new double[coordinates.length()];
                for(int j = 0; j < coordinates.length(); j++) {
                    coord[j] = coordinates.optDouble(j);
                }
                washroom.setCoordinates(coord);

//                washroom.setLocation(checkNull(fieldInfo.getString("location")));
//                washroom.setAddress(checkNull(fieldInfo.getString("address")));
//                washroom.setWinter_hours(checkNull(fieldInfo.getString("winter_hours")));
//                washroom.setType(checkNull(fieldInfo.getString("type")));
//                washroom.setGeo_local_area(checkNull(fieldInfo.getString("geo_local_area")));

                washrooms.add(washroom);
                System.out.println(i);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return washrooms;
    }

    private static String checkNull (String param) {
        if(param == null) {
            return "";
        }
        return param;
    }


}
