package com.example.composetutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.typography


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicView()
        }
    }

    @Composable
    fun BasicView() {
        Column {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = Color.White,
                title = {
                    Text(text = "Tutorial")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Favorite)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.AccountBox)
                    }
                },
                elevation = 4.dp
            )
            Card(
                elevation = 4.dp,
                border = BorderStroke(1.dp, Color.LightGray),
                modifier = Modifier.padding(16.dp).fillMaxWidth(),

            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Column(modifier = Modifier.padding(bottom = 16.dp)) {
                        Text("Hello Guys", style = typography.h4)
                        Text("This is my fist composable function", style = typography.body1)
                    }

                    Row {
                        Image(
                            imageResource(R.drawable.android_logo),
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            "This is row test",
                            modifier = Modifier.padding(8.dp),
                            style = typography.body1
                        )
                    }
                    Button(onClick = {
                        ListActivity.start(this@MainActivity)
                    }) {
                        Text("Open List")
                    }
                }

            }
        }
    }
}
