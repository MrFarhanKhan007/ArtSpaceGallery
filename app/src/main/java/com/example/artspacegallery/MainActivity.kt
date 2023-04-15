package com.example.artspacegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspacegallery.ui.theme.ArtSpaceGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceGalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xffADD8E6)
                ) {
                    ArtSpaceAppUI()
                }
            }
        }
    }
}

var font1 = FontFamily(
    Font(R.font.royale, FontWeight.Bold)
)

@Composable
fun ArtSpaceAppUI() {

    val firstArtwork = R.drawable.modric
    val secondArtwork = R.drawable.cr7
    val thirdArtwork = R.drawable.benzema
    val fourthArtwork = R.drawable.ramos

    var title by remember {
        mutableStateOf(R.string.modric)
    }

    var year by remember {
        mutableStateOf(R.string.modricYEAR)
    }

    var currentArtwork by remember {
        mutableStateOf(firstArtwork)
    }

    var imageSource by remember {
        mutableStateOf(currentArtwork)
    }



    Heading(modifier = Modifier)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {


        ArtworkDisplay(currentArtwork = currentArtwork, modifier = Modifier)

        Spacer(modifier = Modifier.height(16.dp))

        ArtworkTitle(title = title, year = year)

        Spacer(modifier = Modifier.height(25.dp))



        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally)
        ) {
            Button(
                modifier = Modifier.wrapContentSize(Alignment.Center),
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.ramos
                            year = R.string.ramosYEAR
                        }
                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.modric
                            year = R.string.modricYEAR
                        }
                        thirdArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.cr7
                            year = R.string.cr7YEAR
                        }
                        fourthArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.benzema
                            year = R.string.benzemaYEAR
                        }
                    }
                }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xffFFCCCB)
                ),

                elevation = ButtonDefaults.elevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp

                )

            )

            {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xff8B0000)
                )
            }

            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.cr7
                            year = R.string.cr7YEAR

                        }
                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.benzema
                            year = R.string.benzemaYEAR
                        }
                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.ramos
                            year = R.string.ramosYEAR
                        }
                        fourthArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.modric
                            year = R.string.modricYEAR

                        }
                    }
                }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xff8B0000)
                ),

                elevation = ButtonDefaults.elevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp

                )
            )
            {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xffFFCCCB)
                )
            }
        }
    }

}

@Composable
fun Heading(modifier: Modifier) {
    Column(modifier = Modifier
        .wrapContentSize(Alignment.TopCenter)
        .padding(top = 20.dp)) {

        Text(
            text = "Real Madrid",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(start = 15.dp),
            fontFamily = font1
        )
        Text(
            text = "Image Gallery",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontFamily = font1
        )
    }
}

@Composable
fun ArtworkDisplay(
    @DrawableRes currentArtwork: Int,
    modifier: Modifier = Modifier
) {
    Surface(modifier = Modifier.shadow(7.dp), border = BorderStroke(3.dp, color = Color.DarkGray)) {


        Image(
            painter = painterResource(id = currentArtwork),
            contentDescription = "null",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
        )
    }
}


@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int
) {
    Surface(
        modifier = Modifier.shadow(7.dp),
        border = BorderStroke(3.dp, color = Color(0xffFFD700))
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Color.White)
                .padding(5.dp)

        ) {

            Text(
                text = stringResource(id = title),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.padding(top = 5.dp, start = 5.dp, end = 5.dp),
                fontFamily = font1
            )
            Text(
                text = stringResource(id = year),
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 5.dp, end = 5.dp, bottom = 5.dp),
                fontFamily = font1

            )

        }
    }
}

@Preview
@Composable
fun ArtSpaceAppUIpreview() {
    ArtSpaceAppUI()
}