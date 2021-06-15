package com.example.androiddevchallenge.ui.screens.searchscreen

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androiddevchallenge.TwitterApplication
import com.example.androiddevchallenge.ui.screens.tweetsscreen.TweetsScreenVM
import com.example.androiddevchallenge.ui.theme.TwitterTheme
import com.example.androiddevchallenge.utils.BottomNavVM
import com.example.androiddevchallenge.utils.Screens
import com.example.androiddevchallenge.utils.SearchCategory
import com.example.androiddevchallenge.utils.TwitterScaffold

@Composable
fun SearchScreen(
    searchScreenViewModel: SearchScreenVM = hiltViewModel(),
    bottomNavViewModel: BottomNavVM
) {
    bottomNavViewModel.setCurrentScreen(Screens.BottomNavScreens.Search)

    val forYouMutableState: SearchScreenVM.ForYouState by searchScreenViewModel.forYouState.observeAsState(
        SearchScreenVM.ForYouState.Loading)

    val searchCategories: List<SearchCategory> = getSearchCategoriesList()
    val (currentCategory, setCurrentCategory) = rememberSaveable { mutableStateOf(SearchCategory.ForYou) }

    Column(
        Modifier.fillMaxWidth()
    ) {
        SearchCategoryTabs(
            categories = searchCategories,
            selectedCategory = currentCategory,
            onCategorySelected = setCurrentCategory
        )
        val tweenSpec = remember { getAnimSpec() }

        Crossfade(currentCategory, animationSpec = tweenSpec) { category ->
            when (category) {
                SearchCategory.ForYou -> ForYouLayout(forYouMutableState)
                SearchCategory.Covid -> Text(text = "covid")//CovidLayout(topChartsData)
                SearchCategory.Trending -> Text(text = "trending")//TrendingLayout()
                SearchCategory.News -> Text(text = "news")//NewsLayout()
                SearchCategory.Sports -> Text(text = "sports")//SportsLayout()
                SearchCategory.Entertainment -> Text(text = "entertainment")//EntertainmentLayout()
            }
        }
    }

}

fun getSearchCategoriesList(): List<SearchCategory> {
    return listOf(
        SearchCategory.ForYou, SearchCategory.Covid, SearchCategory.Trending, SearchCategory.News, SearchCategory.Sports, SearchCategory.Entertainment
    )
}

private fun getAnimSpec(): TweenSpec<Float> {
    return TweenSpec(
        durationMillis = 600,
        easing = LinearOutSlowInEasing
    )
}