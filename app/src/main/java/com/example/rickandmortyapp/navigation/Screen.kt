package com.example.rickandmortyapp.navigation

sealed class Screen(val route: String) {

    object PersonsList : Screen(ROUTE_PERSONS_LIST)
    object PersonInfo : Screen(ROUTE_PERSON_INFO)
    object FilterScreen : Screen(ROUTE_FILTER_SCREEN)

    private companion object {
        const val ROUTE_PERSONS_LIST = "persons_list"
        const val ROUTE_PERSON_INFO = "person_info"
        const val ROUTE_FILTER_SCREEN = "filter_screen"
    }
}




