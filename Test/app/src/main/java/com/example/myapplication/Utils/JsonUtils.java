package com.example.myapplication.Utils;

import com.example.myapplication.Model.Washroom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static List<Washroom> parseWashroomJsonFile (String json) {
        List<Washroom> list = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
