package com.example.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.ui.theme.InstagramTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
        modifier= Modifier.fillMaxSize(),
        containerColor = Color.Black,
        contentColor = Color.White,
        topBar = {
            InstagramTopBar()
        },
        bottomBar = {
            InstagramBottomBar()

        }
    ) {padding->
        LazyColumn (
            modifier = Modifier.padding(padding)
        )
        {
           items(5)
           {InstagramPostItem()}
      }

    }


}

@Composable
fun InstagramPostItem() {
    Column (modifier= Modifier
        .fillMaxWidth()
    ){

        Row (modifier =
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
                    .border(width = 0.5.dp, color = Color.White, shape = CircleShape)
                ,
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.fitness),
                contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))


            Text(text = "2 likes")

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                Icons.Default.MoreVert,
                contentDescription = null,
                tint = Color.White)

        }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.fitness),
            contentDescription = null)


        Row (modifier =
        Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(10.dp)

        ){
            Icon(
                Icons.Outlined.Favorite,
                contentDescription = null,
                tint = Color.White)
            Spacer(modifier = Modifier.width(20.dp))

            Icon(
                painterResource(id = R.drawable.comment),
                contentDescription = null,
                tint = Color.White)
            Spacer(modifier = Modifier.width(20.dp))


            Icon(
                Icons.Default.Send,
                contentDescription = null,
                tint = Color.White)
            Spacer(modifier = Modifier.weight(1f))


            Icon(
                painterResource(id = R.drawable.bookmark),
                contentDescription = null,
                tint = Color.White)



        }
        Column(
            modifier= Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = "2 likes", style =  TextStyle(fontSize =12.sp))
            Text(text = "Description de la photo",style =  TextStyle(fontSize =14.sp, fontWeight = FontWeight.Bold))
            Text(text = "vien all 6 comment",style =  TextStyle(fontSize =16.sp),color=Color.Gray )
            Text(text = "12 oct 2024",style =  TextStyle(fontSize =16.sp), color=Color.Gray )
        }

    }

}

@Composable
fun InstagramBottomBar() {
    BottomAppBar (
        containerColor = Color.Black,
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 5.dp)
    ){
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Icon(
                Icons.Default.Home,
                modifier = Modifier.size(30.dp),
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                Icons.Default.Search,
                modifier = Modifier.size(30.dp),
                contentDescription = null,
                tint = Color.White)
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                Icons.Default.AddCircle,
                modifier = Modifier.size(30.dp),
                contentDescription = null,
                tint = Color.White)
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                Icons.Default.Favorite,
                modifier = Modifier.size(30.dp),
                contentDescription = null,
                tint = Color.White)
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                Icons.Default.Person,
                modifier = Modifier.size(30.dp),
                contentDescription = null,
                tint = Color.White)

        }



    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = {
            Image(
                modifier= Modifier.height(50.dp),
                painter = painterResource(id =R.drawable.instagram ) ,
                contentDescription ="logo instagram"
            )},

        actions = {
            Icon(
            painterResource(id = R.drawable.baseline_chat_bubble_outline_24),
            contentDescription = null,
            tint = Color.White)
                  },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        ),
    )

}

@Preview(showBackground = true)
@Composable
fun Homepreviews() {
    InstagramTheme {
        HomeScreen()
    }
}