package com.example.services

import android.app.Service
import android.content.Intent

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Service_Example:Service() {

    var counter =0
    var isrunning =false
    var job: Job? =null

    override fun onBind(intent: Intent?)=null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        isrunning=true
     job=   CoroutineScope(Dispatchers.Default).launch {
            while (isrunning)
            {
                delay(1000)
                counter++

         val intent=Intent("send_counter")
         intent.putExtra("key",counter)
         sendBroadcast(intent)
            }

        }
      return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }


}