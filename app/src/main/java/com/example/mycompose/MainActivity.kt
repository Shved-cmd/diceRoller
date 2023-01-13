package com.example.mycompose

import android.content.res.Resources
import android.content.res.Resources.Theme
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.ui.theme.MyComposeTheme
import kotlin.random.Random


var listNature = listOf(
    R.drawable.dice_1,
    R.drawable.dice_2,
    R.drawable.dice_3,
    R.drawable.dice_4,
    R.drawable.dice_5,
    R.drawable.dice_6,
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            MyComposeTheme() {
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceRollerApp() {
 DiceWithButtonAndImage(
     modifier = Modifier
         .fillMaxSize()
         .wrapContentSize(Alignment.Center)
 )
}


@Preview
@Composable
 fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {

    var result by remember{ mutableStateOf(1)}
    var result2 by remember{ mutableStateOf(1)}
    val imageRes = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_6
    }
    val imageRes2 = when(result2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_6
    }

    fun r() {
        result = (1..6).random()
        result2 =  (1..6).random()
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

      Row() {

          Image(
              painter = painterResource(imageRes),
              contentDescription = result.toString()
          )
          Image(
              painter = painterResource(imageRes2),

              contentDescription = result2.toString()
          )
      }
        Button(onClick ={ r() }) {
            Text(stringResource(R.string.roll))
        }

    }
}



