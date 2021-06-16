package com.example.twittercompose.ui.screens.searchscreen

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.twittercompose.utils.BottomNavVM
import com.example.twittercompose.utils.Screens
import com.example.twittercompose.utils.SearchCategory

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
                SearchCategory.ForYou -> Surface { ForYouLayout(forYouMutableState) }
                SearchCategory.Covid -> UnderConstructionPlaceholer()
                SearchCategory.Trending -> UnderConstructionPlaceholer()
                SearchCategory.News -> UnderConstructionPlaceholer()
                SearchCategory.Sports -> UnderConstructionPlaceholer()
                SearchCategory.Entertainment -> UnderConstructionPlaceholer()
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

@Composable
fun UnderConstructionPlaceholer() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "This screen is under construction..."
        )
    }
}