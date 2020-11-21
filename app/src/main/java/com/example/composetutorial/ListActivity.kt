package com.example.composetutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.lazy.LazyRowFor
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


class ListActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ListActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyListView()
        }
    }

    @Composable
    private fun MyListView() {
        Column {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { finish() }) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                },
                title = {
                    Text(text = "List Tutorial")
                }
            )
            CountryListHorizontal()
            CountryListVertical()
        }
    }

    @Composable
    private fun CountryListVertical() {
        val countries = countryList()
        LazyColumnFor(items = countries) { country ->
            Card(
                elevation = 4.dp,
                border = BorderStroke(1.dp, Color.LightGray),
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 8.dp,
                ).fillMaxWidth(),
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(country.name, style = typography.h4)
                    Text(country.capital, style = typography.body1)
                }
            }
        }

    }

    @Composable
    private fun CountryListHorizontal(){
        val countries = countryList()
        LazyRowFor(items = countries) { country ->
            Card(
                elevation = 4.dp,
                border = BorderStroke(1.dp, Color.LightGray),
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 8.dp,
                ).fillMaxWidth(),
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(country.name, style = typography.h4)
                    Text(country.capital, style = typography.body1)
                }
            }
        }
    }

    private fun countryList(): List<Country> {
        val countries = listOf<Country>(
            Country("India", "New Delhi"),
            Country("Indonesia", "Jakarta"),
            Country("England", "London"),
            Country("USA", "Washington, D.C."),
            Country("Germany", "Berlin"),
            Country("Spain", "Madrid"),
            Country("Portugal", "Lisbon"),
            Country("Italy", "Rome")
        )
        return countries
    }
}

data class Country(val name: String, val capital: String)
