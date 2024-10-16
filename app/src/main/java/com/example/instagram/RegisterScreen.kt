package com.example.instagram

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.instagram.ui.theme.InstagramTheme
import com.example.instagram.ui.theme.Skyblue
import org.jetbrains.annotations.Async


@Composable
fun RegisterScreen(){
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    var username by remember { mutableStateOf(value = "") }
    var bio by remember { mutableStateOf(value = "") }

    val imageUri by remember {
        mutableStateOf<Uri?>(null )
    }


    val launcher= rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {
            uri->
        }
    )



    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(20.dp,) ,

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.weight(1f))

        if(imageUri == null){


            Image(
            modifier = Modifier.width(200.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.instagram),
            contentDescription =null )

         }else{
            AsyncImage(
                model =imageUri ,
                modifier = Modifier.width(200.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "logo instagram")

         }


        Spacer(modifier = Modifier.height(20.dp))


        Box(modifier = Modifier
            .size(120.dp)
             ) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.user__2_),
                contentDescription = null
            )


            Icon( modifier = Modifier
                .size(30.dp)
                .clickable {
                    launcher.launch("image/*")
                },

                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = null,
                    tint = Color.White
            )
                

        }
        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            visualTransformation = PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                unfocusedBorderColor = Color.Black,
                unfocusedPlaceholderColor = Color.White.copy(alpha = 0.4f),
                unfocusedTextColor = Color.White

            ),
            placeholder = {
                Text( " Enter your Username")
            },
            onValueChange ={
                username= it
            } )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                unfocusedBorderColor = Color.Black,
                unfocusedPlaceholderColor = Color.White.copy(alpha = 0.4f),
                unfocusedTextColor = Color.White
            ),
            placeholder = {
                Text( " Enter your email")
            },
            onValueChange ={
                email = it
            } )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                unfocusedBorderColor = Color.Black,
                unfocusedPlaceholderColor = Color.White.copy(alpha = 0.4f),
                unfocusedTextColor = Color.White

            ),
            placeholder = {
                Text( " Enter your password")
            },
            onValueChange ={
                password= it
            } )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = bio,
            visualTransformation = PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                unfocusedBorderColor = Color.Black,
                unfocusedPlaceholderColor = Color.White.copy(alpha = 0.4f),
                unfocusedTextColor = Color.White

            ),
            placeholder = {
                Text( " Enter your bio")
            },
            onValueChange ={
                bio= it
            } )
        Spacer(modifier = Modifier.height(20.dp))



        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(contentColor = Skyblue),
            shape = RoundedCornerShape(4.dp),
            onClick = { })
        {
            Text(text = "Sign up")

        }
        Spacer(modifier = Modifier.weight(1f))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
        ) {
            Text(text = " Already have an account?", color = Color.White)
            Text(text = " Login", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)

        }



    }

}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    InstagramTheme {
        RegisterScreen()
    }
}

