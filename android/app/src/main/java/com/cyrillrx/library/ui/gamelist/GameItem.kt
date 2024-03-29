package com.cyrillrx.library.ui.gamelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun GameItem(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageUrl: String?,
    onItemClicked: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClicked() }
    ) {

        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp),
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
            )
            Text(
                text = subtitle,
                color = Color.Gray,
                fontSize = 14.sp,
            )
        }
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GameItemPreview() {
    Column {
        GameItem(
            imageUrl = "",
            title = "Title 1",
            subtitle = "Subtitle 1",
            onItemClicked = {},
        )

        GameItem(
            imageUrl = "",
            title = "Title 2",
            subtitle = "Subtitle 2",
            onItemClicked = {},
        )
    }
}
