package com.example.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Increment_counter() {
    val context= LocalContext.current
    val service_instance= remember {  Intent(context,Service_Example::class.java)}
    var counter by  remember {
        mutableIntStateOf(0)
    }

   Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
     Text(text = counter.toString(), modifier = Modifier.wrapContentSize()  )
       Spacer(modifier = Modifier.height(20.dp))
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.Center
       ) {
           Button(onClick = { context.startService(service_instance) }) {
               Text(text = "Start service", modifier = Modifier.height(40.dp).width(130.dp), textAlign = TextAlign.Center)
           }
           Spacer(modifier = Modifier.width(20.dp))
           Button(onClick = { context.stopService(service_instance) }) {
               Text(text = "Stop service", modifier = Modifier.height(40.dp).width(130.dp),textAlign = TextAlign.Center)
           }
       }
   }

     val reciever=object :BroadcastReceiver(){
         override fun onReceive(context: Context?, intent: Intent?) {
             counter= intent?.getIntExtra("key",0)!!
         }

     }

    DisposableEffect(counter) {
        IntentFilter("send_counter").apply {
            context.registerReceiver(reciever,this, Context.RECEIVER_NOT_EXPORTED)
        }
        onDispose {
            context.unregisterReceiver(reciever)
        }
    }



}