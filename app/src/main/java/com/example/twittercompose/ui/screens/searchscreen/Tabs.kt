package com.example.twittercompose.ui.screens.searchscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twittercompose.ui.theme.twitterBlue
import com.example.twittercompose.utils.SearchCategory

@Composable
fun SearchCategoryTabs(
    categories: List<SearchCategory>,
    selectedCategory: SearchCategory,
    onCategorySelected: (SearchCategory) -> Unit
) {
    val selectedIndex = categories.indexOfFirst { it == selectedCategory }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        SearchCategoryTabIndicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
        )
    }

    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        indicator = indicator,
        backgroundColor = MaterialTheme.colors.primary,
        edgePadding = 8.dp
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onCategorySelected(category) },
                modifier = Modifier.background(color = MaterialTheme.colors.primary),
                text = {
                    Text(
                        text = when (category) {
                            SearchCategory.ForYou -> category.titleText
                            SearchCategory.Covid -> category.titleText
                            SearchCategory.Trending -> category.titleText
                            SearchCategory.News -> category.titleText
                            SearchCategory.Sports -> category.titleText
                            SearchCategory.Entertainment -> category.titleText
                        },
                        color = if (index == selectedIndex) {
                            twitterBlue
                        } else {
                            MaterialTheme.colors.onPrimary
                        },
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    )
                }
            )
        }
    }
}

@Composable
fun SearchCategoryTabIndicator(
    modifier: Modifier = Modifier,
    color: Color = twitterBlue
) {
    Spacer(
        modifier
            .width(5.dp)
            .height(3.dp)
            .background(color, RoundedCornerShape(percent = 50))
    )
}