//package com.example.aplikasipengajian;
//
//import android.Manifest;
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.location.Location;
//import android.location.LocationManager;
//import android.util.Log;
//
//import static androidx.constraintlayout.widget.Constraints.TAG;
//
//public class GPS {
//    private static final String[] INITIAL_PERMS={
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.READ_CONTACTS
//    };
//
//    private static String TAG = "GPS";
//    private static boolean pGps, pNetwork;
//    private static LocationManager locManager;
//    private static String provider;
//    private static double longitude;
//    private static double latitude;
//
//
//    private static void updateAvailability(){
//        try {
//            pNetwork = locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//            provider = LocationManager.NETWORK_PROVIDER;
//        } catch (Exception ex) {
//            Log.w(TAG,"Ex getting NETWORK provider");
//        }
//        try {
//            pGps = locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//            provider = LocationManager.GPS_PROVIDER;
//        } catch (Exception ex) {
//            Log.w(TAG,"Ex getting GPS provider");
//        }
//    }
//
//    public static Location getLastLocation(Context ctx){
//        Location loc = null;
//        if(ctx != null){
//            if(locManager == null){
//                locManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
//            }
//            updateAvailability();
//            if(provider!=null){
//                loc = locManager.getLastKnownLocation(provider);
//            }
//        }
//        return loc;
//    }
//
//
//}