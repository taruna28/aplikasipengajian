package com.example.aplikasipengajian;

//import androidx.fragment.app.FragmentActivity;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.Menu;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.LatLngBounds;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.maps.model.PolylineOptions;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
//
//    private GoogleMap mMap;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
////pakai udemy paulo dichone
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-6.17536, 106.827153);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,10));
//
//
//    }
//
//
//}

//ini backup

        import androidx.fragment.app.FragmentActivity;

        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.Menu;

        import com.google.android.gms.maps.CameraUpdate;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.LatLngBounds;
        import com.google.android.gms.maps.model.Marker;
        import com.google.android.gms.maps.model.MarkerOptions;
        import com.google.android.gms.maps.model.PolylineOptions;

        import java.util.ArrayList;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<MenuPengajian> menuPengajians = new ArrayList<>();
    List<JadwalPengajianResponse> jadwalPengajianResponses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    private void actionRoute(final GoogleMap googleMap){
        mMap = googleMap;
        PengajianApi pengajianApi = ServiceGenerator.getPengajianApi();
        Call<JadwalPengajianResponse> responseCall = pengajianApi.jadwalPengajian();
        responseCall.enqueue(new Callback<JadwalPengajianResponse>() {
            @Override
            public void onResponse(Call<JadwalPengajianResponse> call, Response<JadwalPengajianResponse> response) {
                if (response.isSuccessful()){
//                    // tampung response ke variable

                    int total= response.body().getMenuPengajians().size();

                    for (int a=0;a<total;a++){
                        Double model1 = Double.valueOf(response.body().getMenuPengajians().get(a).getLatitude());
                        Double model2 = Double.valueOf(response.body().getMenuPengajians().get(a).getLongitude());
                        MarkerOptions markerOptions = new MarkerOptions();
                        LatLng latLng = new LatLng(model1,model2);
                        markerOptions.position(latLng);
                        Marker m = mMap.addMarker(markerOptions);
                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                        googleMap.animateCamera(CameraUpdateFactory.zoomTo(11));
//                        menuPengajians.add(model);
                    }
//                    JadwalPengajianResponse item = new JadwalPengajianResponse(menuPengajians);
//                    jadwalPengajianResponses.add(item);
////

////

                }

            }

            @Override
            public void onFailure(Call<JadwalPengajianResponse> call, Throwable t) {

            }
        });



    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        //

        PengajianApi pengajianApi = ServiceGenerator.getPengajianApi();
        Call<JadwalPengajianResponse> responseCall = pengajianApi.jadwalPengajian();
        responseCall.enqueue(new Callback<JadwalPengajianResponse>() {
            @Override
            public void onResponse(Call<JadwalPengajianResponse> call, Response<JadwalPengajianResponse> response) {
                if (response.isSuccessful()){
//                    // tampung response ke variable

                    int total= response.body().getMenuPengajians().size();

                    for (int a=0;a<total;a++){
                        Double model1 = Double.valueOf(response.body().getMenuPengajians().get(a).getLatitude());
                        Double model2 = Double.valueOf(response.body().getMenuPengajians().get(a).getLongitude());
                        MarkerOptions markerOptions = new MarkerOptions();
                        LatLng latLng = new LatLng(model1,model2);
                        markerOptions.position(latLng);
                        Marker m = mMap.addMarker(markerOptions);
                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                        googleMap.animateCamera(CameraUpdateFactory.zoomTo(11));
//                        menuPengajians.add(model);
                    }
//                    JadwalPengajianResponse item = new JadwalPengajianResponse(menuPengajians);
//                    jadwalPengajianResponses.add(item);
////

////

                }

            }

            @Override
            public void onFailure(Call<JadwalPengajianResponse> call, Throwable t) {

            }
        });
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}

