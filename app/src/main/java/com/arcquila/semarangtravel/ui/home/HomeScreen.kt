package com.arcquila.semarangtravel.ui.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arcquila.semarangtravel.R
import com.arcquila.semarangtravel.data.constant.Const
import com.arcquila.semarangtravel.data.model.SemarangTourismModel
import com.arcquila.semarangtravel.ui.custom.Empty
import com.arcquila.semarangtravel.ui.custom.ItemLayout
import com.arcquila.semarangtravel.ui.custom.SearchView
import com.arcquila.semarangtravel.ui.theme.SemarangTourismTheme
import com.arcquila.semarangtravel.ui.theme.backgroundColor
import com.arcquila.semarangtravel.ui.utils.UiState


@Composable
fun HomeScreen(
    navigateToDetail: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val query by viewModel.query
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.search(query)
            }
            is UiState.Success -> {
                Home(
                    listTourism = uiState.data,
                    query = query,
                    onQueryChange = viewModel::search,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {

            }
        }
    }
}

@Composable
fun Home(
    query: String,
    onQueryChange: (String) -> Unit,
    listTourism: List<SemarangTourismModel>,
    navigateToDetail: (Int) -> Unit
) {
    Column {
        SearchView(
            query = query,
            onQueryChange = onQueryChange
        )
        if (listTourism.isNotEmpty()) {
            ListTourism(
                listTourism = listTourism,
                navigateToDetail = navigateToDetail
            )
        } else {
            Empty(
                contentText = stringResource(R.string.empty_data),
                modifier = Modifier
                    .testTag(Const.Cons.EMPTY)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListTourism(
    listTourism: List<SemarangTourismModel>,
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
    contentPaddingTop: Dp = 0.dp,
) {
    LazyColumn(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp, top = contentPaddingTop),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .background(backgroundColor)
            .testTag(Const.Cons.TAG)
    ) {
        items(listTourism, key = { it.id }) { item ->
            ItemLayout(
                photoUrl = item.photoUrl,
                title = item.name,
                modifier = Modifier
                    .background(backgroundColor)
                    .animateItemPlacement(tween(durationMillis = 200))
                    .clickable { navigateToDetail(item.id) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    SemarangTourismTheme{
        Home(
            query = "",
            listTourism = emptyList(),
            onQueryChange = {},
            navigateToDetail = {}
        )
    }
}
