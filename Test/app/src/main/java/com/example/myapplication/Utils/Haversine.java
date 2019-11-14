package com.example.myapplication.Utils;

import com.example.myapplication.Model.Washroom;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Haversine {
    public static final double R = 6372.8; // In kilometers

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }

    public static List<double[]> getPointsWithin(double radius, List<Washroom> list, double lat, double lon) {
        List<double[]> result = new ArrayList<>();

        for(Washroom washroom : list) {
            double[] coords = washroom.getCoordinates();
            double distance = calculateDistance(lat, lon, coords[1], coords[0]);

            if(distance < radius) {
                result.add(coords);
            }
        }

        return result;
    }
}
