package com.organization.elephant.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.organization.elephant.ui.theme.ElephantTheme
import com.organization.elephant.R

@Composable
fun PrincipalTitle(
    title: String,
    icon: @Composable() () -> Unit
) {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 35.dp, end = 35.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = title,
                fontSize = 30.sp,
            )
            icon()
        }

        Divider(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .padding(top = 10.dp),
            thickness = 2.dp
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrincipalTitlePreview() {
    ElephantTheme() {
        PrincipalTitle(
            title = "Title",
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_task),
                    contentDescription = "check list icon"
                )
            }
        )
    }
}