//package com.example.aplikasipengajian;
//
//import android.app.AlarmManager;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.media.RingtoneManager;
//import android.net.Uri;
//import android.util.Log;
//
//import androidx.core.app.NotificationCompat;
//import androidx.core.content.ContextCompat;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//import java.util.Random;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//import static androidx.constraintlayout.widget.Constraints.TAG;
//
//public class Notifikasi extends BroadcastReceiver {
//    public List<MenuPengajian> listMovie = new ArrayList<>();
//    public static final String EXTRA_MESSAGE_RECIEVE = "messageRelease";
//    public static final String EXTRA_TYPE_RECIEVE = "typeRelease";
//    public final static int NOTIFICATION_ID_ = 502;
//
//    public Notifikasi() {
//
//    }
//
//    @Override
//    public void onReceive(final Context context, Intent intent) {
//        PengajianApi pengajianApi = ServiceGenerator.getPengajianApi();
//        Call<JadwalPengajianResponse> responseCall = pengajianApi.jadwalPengajian();
//
//        responseCall.enqueue(new Callback<JadwalPengajianResponse>() {
//            @Override
//            public void onResponse(Call<JadwalPengajianResponse> call, Response<JadwalPengajianResponse> response) {
//                listMovie = response.body().getMenuPengajians();
//                List<MenuPengajian> items = response.body().getMenuPengajians();
//                int index = new Random().nextInt(items.size());
//                MenuPengajian item = items.get(index);
//                int notifId = 503;
//
////                String title = items.get(index).getTitle();
////                String message = items.get(index).getOverview();
////                sendNotification(context, title, message, notifId);
////
////                List<result> movies = data.getResults();
////                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
////                Date date = new Date();
////                final String now = dateFormat.format(date);
////                for (Result movie: movies){
////                    if(movie.getReleaseDate().equals(now)){
////                        showAlarmNotification(context, movie.getId(), movie.getTitle());
////                    }
////                }
////                List<MovieResult> movies = listMovie;
//                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
//                Date date = new Date();
////                String stringDate = dateFormat.format(date);
////                Log.d(TAG, "onResponse: tanggal "+stringDate);
//                final String now = dateFormat.format(date);
//                Log.d(TAG, "onResponse: tanggal  "+now);
//
//                for (MenuPengajian movie: items){
//                    if(movie.getTgl_pelaksanaan().equals(now)){
//                        Log.d(TAG, "onResponse: movie.getTgl "+movie.getTgl_pelaksanaan());
//                        sendNotification(context, movie.getNama_pengajian(), movie.getDeskripsi(), notifId);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JadwalPengajianResponse> call, Throwable t) {
//                Log.d("getUpCommingMovie", "onFailure: " + t.toString());
//            }
//        });
//
//
//    }
//
//    private void sendNotification(Context context, String title, String desc, int id) {
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(
//                Context.NOTIFICATION_SERVICE);
//        Intent intent = new Intent(context, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        Uri uriTone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
//                .setSmallIcon(R.drawable.ic_movie)
//                .setContentTitle(title)
//                .setContentText(desc)
//                .setContentIntent(pendingIntent)
//                .setColor(ContextCompat.getColor(context, android.R.color.transparent))
//                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
//                .setAutoCancel(true)
//                .setSound(uriTone);
//        if (notificationManager != null) {
//            notificationManager.notify(id, builder.build());
//        }
//    }
//
//    public void setAlarm(Context context, String type, String time, String message) {
//        cancelAlarm(context);
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(context, Notifikasi.class);
//        intent.putExtra(EXTRA_MESSAGE_RECIEVE, message);
//        intent.putExtra(EXTRA_TYPE_RECIEVE, type);
//        String timeArray[] = time.split(":");
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
//        calendar.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
//        calendar.set(Calendar.SECOND, 0);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, NOTIFICATION_ID_, intent, 0);
//        if (alarmManager != null) {
//            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
//        }
//
//
//    }
//
//
//    public void cancelAlarm(Context context) {
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(context, Notifikasi.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, NOTIFICATION_ID_, intent, 0);
//        if (alarmManager != null) {
//            alarmManager.cancel(pendingIntent);
//        }
//    }
//
//
//}