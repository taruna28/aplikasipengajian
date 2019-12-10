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
//
//import androidx.core.app.NotificationCompat;
//import androidx.core.app.TaskStackBuilder;
//import androidx.core.content.ContextCompat;
//
//import java.util.Calendar;
//
//public class DailyReceiver extends BroadcastReceiver {
//    //image.tmdb.org/t/p/w500";
//    public static final String EXTRA_MESSAGE_PREF = "message";
//    public static final String EXTRA_TYPE_PREF = "type";
//    public final static int _ID_NOTIFICATION = 501;
//
//
//    public DailyReceiver() {
//
//    }
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        sendNotification(context, context.getResources().getString(R.string.daily_mess), intent.getStringExtra(EXTRA_MESSAGE_PREF),_ID_NOTIFICATION);
//    }
//
//    private void sendNotification(Context context, String title, String desc, int id) {
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(
//                Context.NOTIFICATION_SERVICE);
//        Intent intent = new Intent(context, MainActivity.class);
//        PendingIntent pendingIntent = TaskStackBuilder.create(context)
//                .addNextIntent(intent)
//                .getPendingIntent(_ID_NOTIFICATION,PendingIntent.FLAG_UPDATE_CURRENT);
//        Uri uriTone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,desc)
//                .setSmallIcon(R.drawable.ic_movie)
//                .setContentTitle(title)
//                .setContentText(desc)
//                .setContentIntent(pendingIntent)
//                .setColor(ContextCompat.getColor(context, android.R.color.transparent))
//                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
//                .setSound(uriTone);
//        if (notificationManager != null) {
//            notificationManager.notify(id, builder.build());
//        }
//
//    }
//
//    public void setAlarm(Context context, String type, String time, String message) {
//        cancelAlarm(context);
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(context,DailyReceiver.class);
//        intent.putExtra(EXTRA_MESSAGE_PREF,message);
//        intent.putExtra(EXTRA_TYPE_PREF,type);
//        String timeArray[] = time.split(":");
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
//        calendar.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
//        calendar.set(Calendar.SECOND,0);
//
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,_ID_NOTIFICATION,intent,0);
//        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
//
//    }
//
//    public void cancelAlarm(Context context){
//        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(context,DailyReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,_ID_NOTIFICATION,intent,0);
//        alarmManager.cancel(pendingIntent);
//
//    }
//
//
//
//}
