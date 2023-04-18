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

    val firstArtwork = R.drawable.navas
    val secondArtwork = R.drawable.ramos
    val thirdArtwork = R.drawable.varane
    val fourthArtwork = R.drawable.marcelo
    val fifthArtwork = R.drawable.carvajal
    val sixthArtwork = R.drawable.kroos
    val seventhArtwork = R.drawable.modric
    val eighthArtwork = R.drawable.caasemiro
    val ninthArtwork = R.drawable.bale
    val tenthArtwork = R.drawable.cr7
    val eleventhArtwork = R.drawable.benzema


    var title by remember {
        mutableStateOf(R.string.navas)
    }

    var year by remember {
        mutableStateOf(R.string.navasYEAR)
    }

    var currentArtwork by remember {
        mutableStateOf(firstArtwork)
    }


    Heading()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {


        ArtworkDisplay(currentArtwork = currentArtwork)

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
                            currentArtwork = eleventhArtwork
                            title = R.string.benzema
                            year = R.string.benzemaYEAR
                        }
                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.navas
                            year = R.string.navasYEAR
                        }
                        thirdArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.ramos
                            year = R.string.ramosYEAR
                        }
                        fourthArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.varane
                            year = R.string.varaneYEAR
                        }
                        fifthArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.marcelo
                            year = R.string.marceloYEAR
                        }
                        sixthArtwork -> {
                            currentArtwork = fifthArtwork
                            title = R.string.carvajal
                            year = R.string.carvajalYEAR
                        }
                        seventhArtwork -> {
                            currentArtwork = sixthArtwork
                            title = R.string.kroos
                            year = R.string.kroosYEAR
                        }
                        eighthArtwork -> {
                            currentArtwork = seventhArtwork
                            title = R.string.modric
                            year = R.string.modricYEAR
                        }
                        ninthArtwork -> {
                            currentArtwork = eighthArtwork
                            title = R.string.casemiro
                            year = R.string.casemiroYEAR
                        }
                        tenthArtwork -> {
                            currentArtwork = ninthArtwork
                            title = R.string.bale
                            year = R.string.baleYEAR
                        }
                        eleventhArtwork -> {
                            currentArtwork = tenthArtwork
                            title = R.string.cr7
                            year = R.string.cr7YEAR
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
                            title = R.string.ramos
                            year = R.string.ramosYEAR

                        }
                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.varane
                            year = R.string.varaneYEAR
                        }
                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.marcelo
                            year = R.string.marceloYEAR
                        }
                        fourthArtwork -> {
                            currentArtwork = fifthArtwork
                            title = R.string.carvajal
                            year = R.string.carvajalYEAR

                        }
                        fifthArtwork -> {
                            currentArtwork = sixthArtwork
                            title = R.string.kroos
                            year = R.string.kroosYEAR

                        }
                        sixthArtwork -> {
                            currentArtwork = seventhArtwork
                            title = R.string.modric
                            year = R.string.modricYEAR

                        }
                        seventhArtwork -> {
                            currentArtwork = eighthArtwork
                            title = R.string.casemiro
                            year = R.string.casemiroYEAR

                        }
                        eighthArtwork -> {
                            currentArtwork = ninthArtwork
                            title = R.string.bale
                            year = R.string.baleYEAR

                        }
                        ninthArtwork -> {
                            currentArtwork = tenthArtwork
                            title = R.string.cr7
                            year = R.string.cr7YEAR

                        }
                        tenthArtwork-> {
                            currentArtwork = eleventhArtwork
                            title = R.string.benzema
                            year = R.string.benzemaYEAR

                        }
                        eleventhArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.navas
                            year = R.string.navasYEAR

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
fun Heading() {
    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.TopCenter)
            .padding(top = 20.dp)
    ) {

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
    @DrawableRes currentArtwork: Int
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
fun ArtSpaceAppUIPreview() {
    ArtSpaceAppUI()
}