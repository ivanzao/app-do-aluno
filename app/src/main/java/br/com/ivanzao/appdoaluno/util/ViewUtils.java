package br.com.ivanzao.appdoaluno.util;

import android.app.AlertDialog;
import android.content.Context;

public class ViewUtils {

    public static void showOkAlert(String title, String message, Context context) {
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message);

        alertBuilder.setNeutralButton("Ok", null);
        alertBuilder.create().show();
    }

}