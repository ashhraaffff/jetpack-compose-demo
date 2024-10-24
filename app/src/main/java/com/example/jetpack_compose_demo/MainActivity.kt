package com.example.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //modifiers can be applied to any composable in jetpack compose
            //to texts columns, rows , images anything
            //we can change the appearance, add accessibility information,
            // make composable interactable - clickable zoomable draggable scrollable
            //you can get really creative with how you want your UI to look like and Modifier functions provide that flexibility
//            ModifierDemo()

//
//            Column(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .padding(vertical = 24.dp),
//                verticalArrangement = Arrangement.SpaceEvenly
//            ){
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ){
//                    Box(modifier = Modifier
//                        .width(200.dp)
//                        .padding(8.dp)){
//                        ImageCards(painter = painterResource(id = R.drawable.image2), contentDescription = "<something>", title = "Ganesha Painting 1")
//                    }
//
//                    Box(modifier = Modifier
//                        .width(200.dp)
//                        .padding(8.dp)){
//                        ImageCards(painter = painterResource(id = R.drawable.image1), contentDescription = "<something>", title = "Ganesha Painting 2")
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ){
//                    Box(modifier = Modifier
//                        .width(200.dp)
//                        .padding(8.dp)) {
//                        ImageCards(painter = painterResource(id = R.drawable.image4), contentDescription = "<something", title = "SunFlower Painting")
//                    }
//
//                    Box(modifier = Modifier
//                        .width(200.dp)
//                        .padding(8.dp)){
//                        ImageCards(painter = painterResource(id = R.drawable.image3), contentDescription = "<something>", title = "Seasons Painting")
//                    }
//                }
//
//                Text("Paintings by Aditya Tailor",
//                    style = TextStyle(fontSize = 20.sp, color = Color.Black , fontWeight = FontWeight.Bold),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 10.dp),
//                    textAlign = TextAlign.Center)
//
//            }




//            UiStateDemo(Modifier.fillMaxSize())

//            RecyclerViewDemo()
        }
    }
}
//@Preview
@Composable
fun ModifierDemo() {
    val colors = listOf(
        Color(0xFF2E3B55),  // Deep blue
        Color(0xFF4B6CB7),  // Medium blue
        Color(0xFF6B8CCF),  // Light blue
        Color(0xFF8EB8E5),  // Sky blue
        Color(0xFFB5E2FF)   // Pale blue
    )

    Column(
        modifier = Modifier
            .background(color = Color(0xFFF5F7FA))
            .fillMaxSize()
            .border(12.dp, colors[0])
            .padding(12.dp)
            .border(12.dp, colors[1])
            .padding(12.dp)
            .border(12.dp, colors[2])
            .padding(12.dp)
            .border(12.dp, colors[3])
            .padding(16.dp)
            .border(16.dp, colors[4])
    ) {
        Text(
            "Jetpack",
            modifier = Modifier
                .offset(20.dp, 40.dp)
                .background(colors[0])
                .padding(16.dp)
                .border(
                    width = 2.dp,
                    color = colors[2],
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp),
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.3f),
                    offset = Offset(4f, 4f),
                    blurRadius = 4f
                )
            )
        )

        Text(
            "Compose",
            modifier = Modifier
                .offset(50.dp, 40.dp)
                .rotate(
                    animateFloatAsState(
                        targetValue = 360f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(3000),
                            repeatMode = RepeatMode.Restart
                        )
                    ).value
                )
                .background(
                    Brush.linearGradient(
                        colors = listOf(colors[1], colors[3])
                    )
                )
                .padding(16.dp)
                // Adding a clip shape
                .clip(CutCornerShape(16.dp)),
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            "Modifiers",
            modifier = Modifier
                .offset(30.dp, 60.dp)
                .scale(
                    animateFloatAsState(
                        targetValue = 1.2f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(1000),
                            repeatMode = RepeatMode.Reverse
                        )
                    ).value
                )
                .background(
                    Brush.radialGradient(
                        colors = listOf(colors[4], colors[2])
                    )
                )
                .padding(16.dp)
                .alpha(
                    animateFloatAsState(
                        targetValue = 0.7f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(1500),
                            repeatMode = RepeatMode.Reverse
                        )
                    ).value
                ),
            color = Color(0xFF2E3B55),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )
    }
}




@Composable
fun ImageCards(
    painter : Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier=Modifier
    ){

    Card(modifier=Modifier.fillMaxWidth(),
         shape = RoundedCornerShape(15.dp)
    ){
        //boxes are used to stack content on top of another
        Box(modifier = Modifier.height(400.dp)){
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                //using brushes to show gradient
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f

                    )
                )
            )
            Box(modifier= Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart)  {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }

}



@Preview
@Composable
fun UiStateDemo(modifier: Modifier = Modifier){
    //state basically describes how our ui looks at a given moment
    //jetpack compose allows you to add state handling right where you describe the UI
    //everytime the value of this state variable changes,  the jetpack compose actually redraws the the UI
    val color = remember {
        mutableStateOf(Color.Yellow)
    }

    Box(modifier = modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        })
}




@Preview
@Composable
fun RecyclerViewDemo(){
    LazyColumn {
        //this is like a for loop over ui elements
        items(500){
            //your items
            Text(
                text = "Item $it",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
        }
    }
}

