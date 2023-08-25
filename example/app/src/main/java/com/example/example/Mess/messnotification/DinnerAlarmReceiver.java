package com.example.example.Mess.messnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.preference.PreferenceManager;
import androidx.core.app.NotificationCompat;
import android.util.Log;

import com.example.example.Account.SplashActivity;
import com.example.example.R;

import java.util.Calendar;


public class DinnerAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Intent repeatingIntent = new Intent(context, SplashActivity.class);
        repeatingIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 101, repeatingIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        String menu = null;


            Calendar now = Calendar.getInstance();
            int day = now.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case Calendar.MONDAY:
                    menu = "Parotta,\n" + "Chicken Masala,\n" + "Chicken Gravy,\n" + "Paneer Masala.";
                    break;
                case Calendar.TUESDAY:
                    menu ="Idly,\n" + "Sambar,\n" + "Coconut Chutney." ;
                    break;
                case Calendar.WEDNESDAY:
                    menu = "Chapathi,\n" + "Veg Kurma,\n" + "Curd Rice.";
                case Calendar.THURSDAY:
                    menu ="Tomato Rice,\n" + "Coconut chutney,\n" + "Papad.";
                    break;
                case Calendar.FRIDAY:
                    menu = "Chapathi,\n" + "Veg Kurma,\n" + "Curd Rice.";
                break;
                case Calendar.SATURDAY:
                    menu = "Fried Rice,\n" + "Cauliflower Curry,\n" + "Papad.";
                    break;
                case Calendar.SUNDAY:
                    menu ="Dosa,\n" + "Sambar,\n" + "Coconut Chutney." ;
                break;
            }


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.icon_ucen);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_ucen));
        builder.setContentTitle("Today's Dinner");
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(menu));
        builder.setContentText(menu);
        builder.setAutoCancel(true);
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setChannelId(context.getString(R.string.alarm_notification_channel_id));
        Log.d("DinnerAlarmReceiver","Reaching");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("mess", true)) {
            Log.d("MessSharedPref","Reaching");
            assert notificationManager != null;
            notificationManager.notify(101, builder.build());
        }

    }
}
