package com.example.services

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi

import com.example.services.ui.theme.ServicesTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ServicesTheme {
              Increment_counter()
                }
            }

        }
    }



//@Composable
//fun LifecycleAwareCounter(lifecycleOwner: LifecycleOwner) {
//    var counter by remember { mutableStateOf(0) }
//    var isCounting by remember { mutableStateOf(true) }
//
//    // Observe the lifecycle to manage the counter state
//    DisposableEffect(lifecycleOwner) {
//        val lifecycle = lifecycleOwner.lifecycle
//        val observer = LifecycleEventObserver { _, event ->
//            when (event) {
//                Lifecycle.Event.ON_RESUME -> isCounting = true
//                Lifecycle.Event.ON_PAUSE, Lifecycle.Event.ON_STOP -> isCounting = false
//                else -> {}
//            }
//        }
//        lifecycle.addObserver(observer)
//
//        onDispose {
//            lifecycle.removeObserver(observer)
//        }
//    }
//
//    // Increment counter while isCounting is true
//    LaunchedEffect(isCounting) {
//        while (isCounting) {
//            delay(1000)
//            counter++
//        }
//    }
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Counter: $counter", style = MaterialTheme.typography.headlineMedium)
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = { counter = 0 }) {
//            Text(text = "Reset Counter")
//        }
//    }
//}
