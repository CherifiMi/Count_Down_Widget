package com.example.countdownwidgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.util.TypedValue
import android.widget.RemoteViews
import java.time.LocalDateTime
import android.content.Intent




class CountDown : AppWidgetProvider() {

    private lateinit var DAY: String
    private lateinit var HOU: String
    private lateinit var MIN: String
    private lateinit var SEC: String

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        appWidgetIds.forEach { appWidgetId ->

            val views: RemoteViews = RemoteViews(
                context.packageName,
                R.layout.count_down
            ).apply {

                remainingTime()

                setTextViewText(R.id.days, DAY)
                setTextViewText(R.id.hours, HOU)
                setTextViewText(R.id.minutes, MIN)
                setTextViewText(R.id.seconds, SEC)
            }
            appWidgetManager.updateAppWidget(appWidgetId, views)
            Log.d("test1", "update")
        }
    }



    /*private fun countDown() {
        object : CountDownTimer(60000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

                var millisec : Long = millisUntilFinished / 1000
                remainingTime(0)

            }
            override fun onFinish() {
                countDown()
            }
        }.start()
    }*/

    private fun remainingTime() {
        val remainingDays = 364 - (LocalDateTime.now().dayOfYear)
        if (remainingDays > 9) {
            DAY = remainingDays.toString()
        } else {
            DAY = "0$remainingDays"
        }
        val remainingHours = 23 - (LocalDateTime.now().hour)
        if (remainingHours > 9) {
            HOU = remainingHours.toString()
        } else {
            HOU = "0$remainingHours"
        }
        val remainingMin = 59 - (LocalDateTime.now().minute)
        if (remainingMin > 9) {
            MIN = remainingMin.toString()
        } else {
            MIN = "0$remainingMin"
        }
        val remainingSec = 59 - (LocalDateTime.now().second)
        if (remainingSec > 9) {
            SEC = remainingSec.toString()
        } else {
            SEC = "0$remainingSec"
        }
    }
}





