package com.example.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.navigation.AppNavGraph
import com.example.rickandmortyapp.navigation.NavigationState
import com.example.rickandmortyapp.navigation.Screen
import com.example.rickandmortyapp.navigation.rememberNavigationState
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.example.rickandmortyapp.utils.search

class MainActivity : ComponentActivity() {
    val usersList = listOf(
        Person(0, "Mary"),
        Person(1, "Patricia"),
        Person(2, "Jennifer"),
        Person(3, "Linda"),
        Person(4, "Elizabeth"),
        Person(5, "Barbara"),
        Person(6, "Susan"),
        Person(7, "Jessica"),
        Person(8, "Sarah"),
        Person(9, "Skyler"),
        Person(10, "Nancy"),
        Person(11, "Lisa"),
        Person(12, "Betty"),
        Person(13, "Sandra"),
        Person(14, "Donna"),
        Person(15, "Carol"),
        Person(16, "Sharon"),
        Person(17, "Michelle")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                val navigationState = rememberNavigationState()
                AppNavGraph(
                    navHostController = navigationState.navHostController,
                    personsListContent = { ShowSearch(navigationState) },
                    personInfoContent = { PersonInfo() },
                    filterScreenContent = { FilterScreen() }
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ShowSearch(navigationState: NavigationState) {

        val searchText = remember { mutableStateOf("") }
        val mainList = remember { mutableStateOf(usersList) }
        val isActive = remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                query = searchText.value,
                onQueryChange = { text ->
                    searchText.value = text
                    mainList.value = search(text, usersList)
                },
                onSearch = { text ->
                    isActive.value = false
                },
                placeholder = { Text(stringResource(R.string.search_characters)) },
                active = isActive.value,
                onActiveChange = {
                    isActive.value = it
                },
                trailingIcon = {
                    if (searchText.value.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                searchText.value = ""
                                mainList.value = usersList
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Clear search"
                            )
                        }
                    } else {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            ) {
                PersonList(
                    list = search(searchText.value, usersList),
                    navigationState = navigationState
                )
            }
            PersonList(
                list = mainList.value,
                navigationState = navigationState
            )
        }
    }

    @Composable
    fun PersonList(list: List<Person>, navigationState: NavigationState) {

        Box(
            modifier = Modifier.fillMaxSize()
        )
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(items = list, key = { it.id }
                ) { person ->
                    Box(
                        modifier = Modifier
                            .clickable {
                                navigationState.navigateTo(Screen.PersonInfo.route)
                            }
                            .fillMaxWidth()
                    ) { PersonCard(person) }
                }
            }
            FloatingActionButton(
                onClick = { navigationState.navigateTo(Screen.FilterScreen.route) },
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.filter_icon),
                    contentDescription = null
                )
            }
        }
    }

}

