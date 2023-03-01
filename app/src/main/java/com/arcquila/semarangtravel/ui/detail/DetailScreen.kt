package com.arcquila.semarangtravel.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.arcquila.semarangtravel.R
import com.arcquila.semarangtravel.data.constant.Const
import com.arcquila.semarangtravel.ui.theme.SemarangTourismTheme
import com.arcquila.semarangtravel.ui.theme.backgroundColor
import com.arcquila.semarangtravel.ui.theme.orange
import com.arcquila.semarangtravel.ui.theme.orangeRed
import com.arcquila.semarangtravel.ui.utils.UiState

@Composable
fun DetailScreen(
    tourismId: Int,
    navigateBack: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getTourismPlaceById(tourismId)
            }
            is UiState.Success -> {
                val data = uiState.data
                Detail(
                    placeName = data.name,
                    description = data.description,
                    photoUrl = data.photoUrl,
                    location = data.location,
                    navigateBack = navigateBack,
                    title =stringResource(id =R.string.place_information),
                    titleLocation = stringResource(id =R.string.place_location)
                )
            }
            is UiState.Error -> {

            }
        }
    }
}

@Composable
fun Detail(
    title: String,
    titleLocation: String,
    placeName: String,
    description: String,
    photoUrl: String,
    location: String,
    navigateBack: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 16.dp)
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = placeName,
                placeholder = painterResource(id = R.drawable.empty),
                error = painterResource(id = R.drawable.empty),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                    .testTag(Const.Cons.SCROLL)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = placeName,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = orange,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
                    .padding(
                        start = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp,
                        end = 16.dp
                    )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = titleLocation ,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(
                            start = 16.dp,
                            top = 2.dp,
                            end = 16.dp,
                            bottom = 2.dp
                        ),
                    style = SemarangTourismTheme.typography.title,
                    fontSize = 16.sp
                )

                Spacer(
                    modifier = Modifier
                        .padding(
                            top = 16.dp
                        )
                )
                Text(
                    text = location,
                    overflow = TextOverflow.Visible,
                    color = orangeRed,
                    modifier = Modifier
                        .padding(
                            start = 4.dp,
                            top = 2.dp,
                            end = 4.dp,
                            bottom = 2.dp
                        )
                )
            }
            Divider(modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp))
            Text(
                text =title ,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(
                        start = 16.dp,
                        top = 2.dp,
                        end = 16.dp,
                        bottom = 2.dp
                    ),
                style = SemarangTourismTheme.typography.title,
                fontSize = 16.sp
            )

            Spacer(
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    )
            )
            Text(
                text = description,
                fontSize = 16.sp,
                lineHeight = 40.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        start = 16.dp,
                        top = 2.dp,
                        end = 16.dp,
                        bottom = 2.dp
                    )
                    .fillMaxWidth()
            )
        }
        IconButton(
            onClick = navigateBack,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .align(Alignment.TopStart)
                .clip(CircleShape)
                .size(40.dp)
                .testTag(Const.Cons.BACK)
                .background(orange)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    SemarangTourismTheme {
        Detail(
            title ="Informasi Tempat",
            titleLocation ="Lokasi",
            navigateBack = {},
            placeName = "SAM POO KONG",
            description = "Kelenteng Gedung Kuno Sam Poo Kong yaitu bekas tempat persinggahan dan pendaratan pertama seorang Laksamana Tiongkok beragama Islam yang bernama Zheng He/Cheng Ho, yang juga dikenal dengan nama Sam Poo.",
            photoUrl = "https://lh3.googleusercontent.com/p/AF1QipOaiGz0_SRag95BfXuY-LweU3YBZC7ljn5SX11u=s1360-w1360-h1020",
            location = "Jl. Simongan No.129, Bongsari, Kec. Semarang Barat, Kota Semarang, Jawa Tengah 5014",
        )
    }
}

