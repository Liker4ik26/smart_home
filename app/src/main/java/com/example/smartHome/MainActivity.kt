package com.example.smartHome

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.smartHome.screen.addedDevice.AddedDeviceScreen
import com.example.smartHome.screen.addedRoom.AddedRoomScreen
import com.example.smartHome.screen.device.DeviceScreen
import com.example.smartHome.screen.light.LightScreen
import com.example.smartHome.ui.theme.SmartHomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            ),
        )
        super.onCreate(savedInstanceState)
        setContent {
            SmartHomeTheme {
                LightScreen()
            }
        }
    }
}