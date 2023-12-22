package com.vicks.jollyapp

import android.graphics.Paint.Align
import android.graphics.drawable.Icon
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vicks.jollyapp.ui.theme.Brown
import com.vicks.jollyapp.ui.theme.JollyAppTheme
import com.vicks.jollyapp.ui.theme.SeaGreen
import com.vicks.jollyapp.ui.theme.White26
import com.vicks.jollyapp.ui.theme.darkGreen
import com.vicks.jollyapp.ui.theme.grey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JollyAppTheme {
                // A surface container using the 'background' color from the theme
                val host= rememberNavController()
                MyHost(host)
            }
        }
    }
}

val medFont = FontFamily(Font(R.font.frank_medium))
val regFont = FontFamily(Font(R.font.frankruhllibre_regular))
//val ligFont = FontFamily(Font(R.font.frankruhllibre_light))


@Composable
fun SplashScreen(navControl: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween){
        Column(
            Modifier
                .size(420.dp, 800.dp)
                .padding(20.dp, 24.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
            Row(Modifier.fillMaxHeight(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){Text("JOLLY APP", fontSize = 48.sp, fontFamily = medFont,color = Brown, textAlign = TextAlign.Center)}
        }
        Row(Modifier.fillMaxHeight(),verticalAlignment =Alignment.Bottom, horizontalArrangement = Arrangement.Center){
            Text("ImagineWorks", fontSize = 12.sp, fontFamily = regFont,color = Brown, textAlign = TextAlign.Center)
        }
    }

}

@Composable
fun First_Onboard(navControl: NavHostController){
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp, 16.dp), verticalArrangement = Arrangement.spacedBy(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.discover),
            contentDescription = "Picture of woman browsing Online",
            modifier = Modifier.size(388.dp,400.dp)
        )
        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Discover new Recreational Places", fontSize = 20.sp, fontFamily = medFont)
            Text("Find new places to relax and have fun with your loved ones", fontSize = 16.sp, fontFamily = regFont, textAlign= TextAlign.Center)
        }
        Column(verticalArrangement = Arrangement.spacedBy(40.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                Box(
                    Modifier
                        .size(8.dp, 8.dp)
                        .background(darkGreen, CircleShape))
                Box(
                    Modifier
                        .size(8.dp, 8.dp)
                        .background(grey, CircleShape))
                Box(
                    Modifier
                        .size(8.dp, 8.dp)
                        .background(grey, CircleShape))



            }
            Button(onClick = {navControl.navigate("Second_Onboard") },modifier= Modifier
                .size(388.dp, 48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SeaGreen, contentColor = White26)) {
                Text("Next",fontSize = 16.sp,fontFamily = medFont,textAlign = TextAlign.Center)
            }
        }


    }
}

@Composable
fun Second_Onboard(navControl: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp, 16.dp), verticalArrangement = Arrangement.spacedBy(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.navii),
            contentDescription = "Picture of woman using map",
            modifier = Modifier.size(388.dp,400.dp)
        )
        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "No More Getting Lost", fontSize = 20.sp, fontFamily = medFont)
            Text("Never lose your way again with Jolly get Accurate directions to Your Destination", fontSize = 16.sp, fontFamily = regFont, textAlign= TextAlign.Center)
        }
        Column(verticalArrangement = Arrangement.spacedBy(40.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                Box(
                    Modifier
                        .size(8.dp, 8.dp)
                        .background(grey, CircleShape))
                Box(
                    Modifier
                        .size(8.dp, 8.dp)
                        .background(darkGreen, CircleShape))
                Box(
                    Modifier
                        .size(8.dp, 8.dp)
                        .background(grey, CircleShape))



            }
            Button(onClick = { navControl.navigate("Last_Onboard") },modifier= Modifier
                .size(388.dp, 48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SeaGreen, contentColor = White26)) {
                Text("Next",fontSize = 16.sp,fontFamily = medFont,textAlign = TextAlign.Center)
            }
        }
    }
}
@Composable
fun Last_Onboard(navControl: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp, 16.dp), verticalArrangement = Arrangement.spacedBy(40.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.trendyi),
            contentDescription = "Picture of woman browsing trending places on her phone",
            modifier = Modifier.size(388.dp,400.dp)
        )
        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Discover Trendy Places", fontSize = 20.sp, fontFamily = medFont)
            Text("Get Weekly Updates on the Top Trendy Fun Place to Visit", fontSize = 16.sp, fontFamily = regFont, textAlign= TextAlign.Center)
        }
        Column(verticalArrangement = Arrangement.spacedBy(40.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                Box(
                    Modifier
                        .size(8.dp, 8.dp)
                        .background(grey, CircleShape))
                Box(
                    Modifier
                        .size(8.dp, 8.dp)
                        .background(grey, CircleShape))
                Box(
                    Modifier
                        .size(8.dp, 8.dp)
                        .background(darkGreen, CircleShape))



            }
            Button(onClick = { /*TODO*/ },modifier= Modifier
                .size(388.dp, 48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SeaGreen, contentColor = White26)) {
                Text("Sign Up",fontSize = 16.sp,fontFamily = medFont,textAlign = TextAlign.Center)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically){
                Text("Already have an Account?")
                TextButton(onClick = { },colors = ButtonDefaults.textButtonColors(contentColor= SeaGreen)) {
                    Text("Log In", fontSize = 16.sp, fontFamily = regFont)

                }
            }
        }


    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SignUp() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
        //var city by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var tick by remember { mutableStateOf(false)}
    
    var currentProgress by remember { mutableStateOf(0f) }
    Column(verticalArrangement = Arrangement.spacedBy(40.dp),modifier=Modifier.padding(20.dp,24.dp)) {
        LinearProgressIndicator(color = SeaGreen, trackColor = grey, progress = currentProgress,modifier= Modifier.fillMaxWidth())
       Row(horizontalArrangement = Arrangement.Start){
           Text("Create an Account", fontSize = 24.sp, fontFamily = medFont)

       }
        Column(verticalArrangement =Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally ) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                placeholder = { Text("Enter your email") },
                modifier = Modifier
                    .size(388.dp, 60.dp),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {Icon(painterResource(id = R.drawable.baseline_cancel_24),"icon of email",Modifier.size(16.dp,16.dp),tint=grey)}
                )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = { Text("Enter a password") },
                modifier = Modifier
                    .size(388.dp, 60.dp),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {IconButton(onClick = { },
                    content = {Icon(painter = painterResource(id = R.drawable.baseline_remove_red_eye_24), contentDescription = "eye icon",tint= grey)})}
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Confirm Password") },
                placeholder = { Text("Re-enter password") },
                modifier = Modifier
                    .size(388.dp, 60.dp),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {IconButton(onClick = { },
                    content = {Icon(painter = painterResource(id = R.drawable.baseline_remove_red_eye_24), contentDescription = "eye icon",tint= grey)})}
            )
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp), verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()){
                    Checkbox(checked = tick, onCheckedChange = {!tick},modifier= Modifier.padding(0.dp))
                    Text("I accept the terms and condition",fontSize = 16.sp, fontFamily = regFont)
                }
            Column(verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally,modifier=Modifier.padding(top = 32.dp)) {
                Button(onClick = { /*TODO*/ },modifier= Modifier
                    .size(388.dp, 50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = SeaGreen, contentColor = White26)) {
                    Text("Create Account",fontSize = 16.sp,fontFamily = medFont,textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { /*TODO*/ },modifier= Modifier
                    .size(388.dp, 50.dp),
                    shape = RoundedCornerShape(12.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_google),
                            contentDescription = "Google Logo",
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                        Text(
                            "Sign Up with Google",
                            fontSize = 16.sp,
                            fontFamily = medFont,
                            textAlign = TextAlign.Center,
                            color = Brown
                        )
                    }
                }



            }

        }


    }
}



@Composable
fun MyHost(navControl: NavHostController) {
    NavHost(navController = navControl, startDestination = "First_Onboard") {
        composable("splashScreen") {
            SplashScreen(navControl)
        }
        composable("First_Onboard") {
            First_Onboard(navControl)
        }
        composable("Second_Onboard") {
            Second_Onboard(navControl)
        }
        composable("Last_Onboard") {
            Last_Onboard(navControl)
        }

    }
}
