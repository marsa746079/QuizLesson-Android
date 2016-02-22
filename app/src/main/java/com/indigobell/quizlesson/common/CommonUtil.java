package com.indigobell.quizlesson.common;

import android.content.Context;
import android.widget.Toast;

public class CommonUtil {
    public static void showToast(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
