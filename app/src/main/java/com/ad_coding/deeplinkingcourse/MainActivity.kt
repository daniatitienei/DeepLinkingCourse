package com.ad_coding.deeplinkingcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.ad_coding.deeplinkingcourse.ui.theme.DeepLinkingCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeepLinkingCourseTheme {
                val navController = rememberNavController()

                val uri = "https://www.ad-coding.com"

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable(
                        route = "home",
                        deepLinks = listOf(
                            navDeepLink {
                                uriPattern = "$uri/{id}"
                            }
                        )
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id")

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = id ?: "No id passed")
                        }
                    }
                }
            }
        }
    }
}