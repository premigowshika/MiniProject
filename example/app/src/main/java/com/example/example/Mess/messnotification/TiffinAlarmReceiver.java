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

import com.example.example.Account.SplashActivity;
import com.example.example.R;

import java.util.Calendar;





public class TiffinAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent repeatingIntent = new Intent(context, SplashActivity.class);
        repeatingIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 103, repeatingIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        String menu = null;
            Calendar now = Calendar.getInstance();
            int day = now.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case Calendar.MONDAY:
                    menu = "Biscuit,\n" + "Tea,\n" + "Milk.";
                    break;
                case Calendar.TUESDAY:
                    menu ="Paruppu Vada,\n" + "Tea,\n" + "Milk.";
                    break;
                case Calendar.WEDNESDAY:
                    menu ="Steamed Green gram \n" + "Tea,\n" + "Milk." ;
                    break;
                case Calendar.THURSDAY:
                    menu = "Bajji,\n" + "Tea," + "Milk.";
                    break;
                case Calendar.FRIDAY:
                    menu = "Veg Puffs,\n" + "Tea,\n" + "Milk.";
                break;
                case Calendar.SATURDAY:
                    menu = "Uluntha Vada,\n" + "Tea,\n" + "Milk.";
                    break;
                case Calendar.SUNDAY:
                    menu = "Bread,\n" + "Tea,\n" +"Milk.";
                    break;
            }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.icon_ucen);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_ucen));
        builder.setContentTitle("Today's Tiffin");
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(menu));
        builder.setContentText(menu);
        builder.setAutoCancel(true);
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setChannelId(context.getString(R.string.alarm_notification_channel_id));

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("mess", true)) {
            assert notificationManager != null;
            notificationManager.notify(103, builder.build());
        }


    }
}
