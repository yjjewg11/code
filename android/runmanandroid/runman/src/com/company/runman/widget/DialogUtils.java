package com.company.runman.widget;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import com.company.runman.utils.TimeUtils;

import java.util.Calendar;

/**
 */
public class DialogUtils {

    public static void alertErrMsg( Context mContext,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("错误");
        builder.setMessage(msg);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //显示时间选择器
    public static void showTimeDialogBind( final EditText dateView) {
        final Context context = dateView.getContext();
        dateView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View actionView, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    String timeStr=dateView.getText().toString();
                    if(timeStr==null)timeStr=TimeUtils.getCurrentHourAndMinute();
                    final int hourOfDay=TimeUtils.getHourByTimeStr(timeStr);
                    final int minute= TimeUtils.getMinuteByTimeStr(timeStr);
                    /**
                     * 实例化一个TimePickerDialog的对象
                     * 第二个参数是一个TimePickerDialog.OnTimeSetListener匿名内部类，当用户选择好时间后点击done会调用里面的onTimeset方法
                     */
                    TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener()
                    {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                        {
                            String hs=hourOfDay+"";
                            if(hs.length()<10)hs="0"+hs;
                            String ms=minute+"";
                            if(hs.length()<10)ms="0"+ms;
                            dateView.setText(hourOfDay + ":" + minute);
                        }
                    }, hourOfDay, minute, true);
                    timePickerDialog.show();
                }
                return true;
            }
        });
    }
        //显示时间选择器
    public static void showDateDialogBind(final EditText dateView) {
        final Context context = dateView.getContext();
        dateView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View actionView, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {//点击事件
                    String timeStr=dateView.getText().toString();
                    if(timeStr==null)timeStr=TimeUtils.getCurrentDateStr();
                     int year=TimeUtils.getYearByDateStr(timeStr);
                     int monthOfYear= TimeUtils.getMonthByDateStr(timeStr);
                     int dayOfMonth=TimeUtils.getDayByDateStr(timeStr);
                    /**
                     * 实例化一个DatePickerDialog的对象
                     * 第二个参数是一个DatePickerDialog.OnDateSetListener匿名内部类，当用户选择好日期点击done会调用里面的onDateSet方法
                     */
                    DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener()
                    {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear,
                                              int dayOfMonth)
                        {
                            dateView.setText( year + "-" + monthOfYear + "-" + dayOfMonth);
                        }
                    }, year, monthOfYear, dayOfMonth);

                    datePickerDialog.show();

                }
                return true;
            }
        });
    }
}
