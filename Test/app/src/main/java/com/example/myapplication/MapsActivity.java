package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Model.Washroom;
import com.example.myapplication.Utils.JsonUtils;
import com.example.myapplication.Utils.Haversine;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String washroomFromJson;
    private List<Washroom> washrooms = new ArrayList<>();
    private final static String PATH_TO_FILE = "public-washrooms.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        washroomFromJson = getJsonStringFromFile(PATH_TO_FILE);
        washrooms = JsonUtils.parseWashroomJsonFile(washroomFromJson);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        double currLat = 49.284731;
        double currLon = -123.111646;

        LatLng sfu = new LatLng(currLat, currLon);
        mMap.addMarker(new MarkerOptions().position(sfu).title("Base Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sfu, 15));

        double distance = Haversine.calculateDistance(currLat, currLon, 49.2552329902121, -123.049933959326);

        Toast toast = Toast.makeText(getApplicationContext(),
                "" + distance + "km",
                Toast.LENGTH_LONG);

        toast.show();


        

    }

    public String getJsonStringFromFile (String filename) {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            json = new String(buffer, "UTF-8");
            is.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}
