package com.tiki.flutter_a

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel



class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger,
                "messages").setMethodCallHandler { call, result ->
            if (call.method == "StartService") {
                StartService()
            }
            if (call.method == "StopService") {
                StopService()
                result.success("OK2")
            }
        }
    }
    private fun StartService() {

        startService(Intent(applicationContext, MyIntentService::class.java))
        System.out.println("system started")
    }
    private fun StopService() {
        stopService(Intent(applicationContext, MyIntentService::class.java))
    }

}
