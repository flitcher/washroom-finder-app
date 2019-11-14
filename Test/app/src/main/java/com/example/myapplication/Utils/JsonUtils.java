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
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("washrooms");
            for(int i = 0; i < jsonArray.length(); i++) {
                Washroom washroom = new Washroom();
                JSONObject fieldInfo = jsonArray.getJSONObject(i).getJSONObject("fields");

                washroom.setMaintainer(fieldInfo.getString("maintainer"));
                washroom.setName(fieldInfo.getString("name"));
                washroom.setWheel_access(fieldInfo.getString("wheel_access"));
                washroom.setPrimaryind(fieldInfo.getString("primaryind"));
                washroom.setNote(fieldInfo.getString("note"));
                washroom.setSummer_hours(fieldInfo.getString("summer_hours"));

                JSONObject geomInfo = fieldInfo.getJSONObject("geom");
                washroom.setGeon_type(geomInfo.getString("type"));
                String temp = geomInfo.get("coordinates").toString();
                washroom.setCoordinates(Float.parseFloat(temp)); // TODO : could fail

                washroom.setLocation(fieldInfo.getString("location"));
                washroom.setAddress(fieldInfo.getString("address"));
                washroom.setWinter_hours(fieldInfo.getString("winter_hours"));
                washroom.setType(fieldInfo.getString("type"));
                washroom.setGeo_local_area(fieldInfo.getString("geo_local_area"));

                washrooms.add(washroom);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return washrooms;
    }


}
