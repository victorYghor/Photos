package com.example.photosexamples

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun PlaceScreen(
    @DrawableRes image: Int,
    @StringRes imageDescription: Int,
    @StringRes title: Int,
    @StringRes description: Int,
    navBack: () -> Unit,
    navForward: () -> Unit
) {
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Image(
            painter = painterResource(image),
            contentDescription = stringResource(imageDescription),
                )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(description),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(onClick = { navBack() }) {
                Text(text = stringResource(R.string.previous))
            }

            Button(onClick = { navForward() }) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}