package com.example.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.ui.theme.InstagramTheme
import com.example.instagram.ui.theme.Skyblue

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(20.dp,) ,

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier.width(200.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.instagram),
            contentDescription =null )

        Spacer(modifier = Modifier.height(70.dp))


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
        Spacer(modifier = Modifier.height(40.dp))

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
                Text( " Enter your email")
            },
            onValueChange ={
                password = it
            } )
        Spacer(modifier = Modifier.height(40.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(contentColor = Skyblue),
            shape = RoundedCornerShape(4.dp),
            onClick = { })
        {
            Text(text = "Login", color=Color.White)

        }
        Spacer(modifier = Modifier.weight(1f))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
        ) {
            Text(text = " Dont\'t have any account ?", color = Color.White)
            Text(text = " Sign up", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)

        }



    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InstagramTheme {
        LoginScreen()
    }
}