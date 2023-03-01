package com.arcquila.semarangtravel.ui.about

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.arcquila.semarangtravel.R
import com.arcquila.semarangtravel.data.constant.Const
import com.arcquila.semarangtravel.ui.theme.SemarangTourismTheme
import com.arcquila.semarangtravel.ui.theme.backgroundColor
import com.arcquila.semarangtravel.ui.theme.orange
import com.arcquila.semarangtravel.ui.theme.orangeRed


@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
        ) {
            IconButton(
                onClick = navigateBack,
                modifier = Modifier
            ) {
                Icon(
                    contentDescription = stringResource(R.string.back),
                    tint = orangeRed,
                    imageVector = Icons.Default.ArrowBack
                )
            }
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = stringResource(R.string.about_me),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = orangeRed
            )
        }
        Card(
            modifier = modifier
                .padding(
                    top = 60.dp,
                    bottom = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                )
                .wrapContentHeight()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconDoubleText(
                    drawable = R.drawable.ic_person,
                    modifier = Modifier
                        .background(Color.White),
                    title = stringResource(
                        id = R.string.nama
                    )

                )
                Divider(
                    modifier = Modifier
                        .padding(
                            end = 18.dp,
                            start = 18.dp,
                            top = 4.dp,
                            bottom = 4.dp
                        )
                )

                IconDoubleText(
                    drawable = R.drawable.ic_email,
                    title = stringResource(id = R.string.email),
                    modifier = Modifier
                        .background(Color.White)
                )

                Divider(
                    modifier = Modifier
                        .padding(
                            end = 18.dp,
                            start = 18.dp,
                            top = 4.dp,
                            bottom = 4.dp
                        )
                )
                IconDoubleText(
                    drawable = R.drawable.ic_star,
                    title = stringResource(id = R.string.star),
                    modifier = Modifier
                        .background(Color.White)
                )

                Divider(
                    modifier = Modifier
                        .padding(
                            end = 18.dp,
                            start = 18.dp,
                            top = 4.dp,
                            bottom = 4.dp
                        )
                )
                IconDoubleText(
                    drawable = R.drawable.ic_location,
                    title = stringResource(id = R.string.location),
                    modifier = Modifier
                        .background(Color.White)
                )

                Divider(
                    modifier = Modifier
                        .padding(
                            end = 18.dp,
                            start = 18.dp,
                            top = 4.dp,
                            bottom = 4.dp
                        )
                )
                IconDoubleText(
                    drawable = R.drawable.ic_time,
                    title = stringResource(id = R.string.times),
                    modifier = Modifier
                        .background(Color.White)
                )

                Divider(
                    modifier = Modifier
                        .padding(
                            end = 18.dp,
                            start = 18.dp,
                            top = 4.dp,
                            bottom = 4.dp
                        )
                )
                AsyncImage(
                    model = stringResource(R.string.my_image),
                    contentDescription = Const.Cons.ABOUTPAGE,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}


@Composable
private fun IconDoubleText(
    @DrawableRes drawable: Int,
    title: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enable: Boolean = false
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                enabled = enable,
                onClick = {
                    onClick?.invoke()
                }
            )
            .padding(
                all = 20.dp
            )
    ) {
        Icon(
            painter = painterResource(id = drawable),
            contentDescription = title,
            tint = Color.Unspecified
        )

        Spacer(
            modifier = Modifier
                .padding(
                    start = 15.dp
                )
        )

        Column {
            Text(
                text = title,
                fontSize = 18.sp,
                color = orange,
                style = SemarangTourismTheme.typography.title
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    SemarangTourismTheme {
        AboutScreen(
            navigateBack = {},
        )
    }
}