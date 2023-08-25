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


public class LunchAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent repeatingIntent = new Intent(context, SplashActivity.class);
        repeatingIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 102, repeatingIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        String menu = null;

            Calendar now = Calendar.getInstance();
            int day = now.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case Calendar.MONDAY:
                    menu = "Steamed Rice,\n" + "Sambar,\n" + "Carrot Beans Poriyal,\n" + "Rasam,\n" + "Buttermilk,\n" +"Papad,\n" + "Pickle.";
                    break;
                case Calendar.TUESDAY:
                    menu = "Steamed Rice,\n" + "Puzhikuzhambu,\n" + "Cabbage Peas Poriyal,\n" + "Rasam,\n" +"ButterMilk,\n"+ "Pickle.";
                    break;
                case Calendar.WEDNESDAY:
                    menu = "Steamed Rice,\n" + "Morkuzhambu,\n" +"Egg Curry,\n" + "Potato Fry,\n" + "Papad,\n" + "Rasam,\n" + "Buttermilk.";
                    break;
                case Calendar.THURSDAY:
                    menu ="Kushka,\n" + "Chicken curry,\n" + "Chicken 65,\n" + "Steamed Rice,\n" + "Veg Curry,\n" + "Caulifolwer Fry,\n" + "Rasam,\n" +"Papad." ;
                    break;
                case Calendar.FRIDAY:
                    menu ="Steamed Rice,\n" + "Sambar,\n" + "Aviyal,\n" + "Payasam,\n" + "Rasam,\n" + "Papad,\n" + "Buttermilk." ;
                    break;
                case Calendar.SATURDAY:
                    menu ="Steamed Rice,\n" + "Paruppu Kuzhambu,\n" + "Potato soyachunks masala,\n" + "Rasam,\n" + "Buttermilk,\n" + "Papad." ;
                    break;
                case Calendar.SUNDAY:
                    menu ="Steamed Rice,\n" + "Sothi Kuzhambu,\n" + "Potato,\n" + "Rasam,\n" + "Buttermilk,\n" + "Papad,\n" + "Pickle." ;
                    break;
            }


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.icon_ucen);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_ucen));
        builder.setContentTitle("Today's Lunch");
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(menu));
        builder.setContentText(menu);
        builder.setAutoCancel(true);
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setChannelId(context.getString(R.string.alarm_notification_channel_id));

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("mess", true)) {
            assert notificationManager != null;
            notificationManager.notify(102, builder.build());
        }


    }
}
