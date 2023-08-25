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


public class BreakfastAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent repeatingIntent = new Intent(context, SplashActivity.class);
        repeatingIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repeatingIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        String menu = null;


            Calendar now = Calendar.getInstance();
            int day = now.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case Calendar.MONDAY:
                    menu = "Idli,\n"+"Coconut Chutney,\n"+ "Sambhar ,\n"+ "Kesari,\n"+ "Coffee.";
                    break;
                case Calendar.TUESDAY:
                    menu ="Pongal,\n" + "Sambar,\n" + "Coconut Chutney,\n" + "Uluntha Vada." ;
                    break;
                case Calendar.WEDNESDAY:
                    menu = "Semiya Upma,\n" + "Coconut Chutney,\n" + "Bajji,\n" + "Coffee.";
                    break;
                case Calendar.THURSDAY:
                    menu = "Idly,\n" + "Sambar,\n" + "Coconut Chutney,\n" + "Paruppu Vada,\n" + "Coffee.";
                    break;
                case Calendar.FRIDAY:
                    menu = "Dosa,\n" + "Coconut Chutney,\n" + "Uluntha Vada,\n" + "Coffee.";
                    break;
                case Calendar.SATURDAY:
                    menu = "Poori,\n" + "Potato Masala,\n" + "Coffee.";
                    break;
                case Calendar.SUNDAY:
                    menu = "Bread,\n" + "Jam,\n" + "Chana Masala,\n" + "Omelette,\n" + "Coffee.";
                    break;
            }


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.icon_ucen);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_ucen));
        builder.setContentTitle("Today's Breakfast");
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(menu));
        builder.setContentText(menu);
        builder.setAutoCancel(true);
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setChannelId(context.getString(R.string.alarm_notification_channel_id));

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("mess", true)) {
            assert notificationManager != null;
            notificationManager.notify(100, builder.build());
        }


    }
}
