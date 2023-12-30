package com.vicks.jollyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.AndroidViewModel
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
                MyHost(host, JollyView(application))
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
            painter = painterResource(id = R.drawable.searchi),
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
            Button(onClick = {navControl.navigate("Sign Up") },modifier= Modifier
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
fun SignUp(navControl: NavHostController,appView: JollyView) {
        var valCheck by remember{ mutableStateOf(false) }
        var hide by remember{ mutableStateOf(false) }
        var chide by remember{ mutableStateOf(false) }


    Column(verticalArrangement = Arrangement.spacedBy(40.dp),modifier=Modifier.padding(20.dp,32.dp)) {
       Row(horizontalArrangement = Arrangement.Start){
           Text("Create an Account", fontSize = 24.sp, fontFamily = medFont)

       }
        Column(verticalArrangement =Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally ) {
            OutlinedTextField(
                value = appView.JData.email.value,
                onValueChange = { appView.JData.email.value = it },
                label = { Text("Email") },
                placeholder = { Text("Enter your email") },
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Brown),
                modifier = Modifier
                    .size(388.dp, 60.dp),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {Icon(painterResource(id = R.drawable.baseline_cancel_24),"icon of cancel ",Modifier.size(20.dp,20.dp),tint=grey)}
                )
            OutlinedTextField(
                value = appView.JData.password.value,
                onValueChange = {appView.JData.password.value = it },
                label = { Text("Password") },
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Brown),
                placeholder = { Text("Enter a password") },
                modifier = Modifier
                    .size(388.dp, 60.dp),
                visualTransformation = if(hide) VisualTransformation.None else PasswordVisualTransformation(),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {IconButton(onClick = {hide = !hide },
                    content = {Icon(painter = painterResource(id = if (hide) R.drawable.baseline_remove_red_eye_24 else R.drawable.eyec), contentDescription = "eye icon",modifier=Modifier.size(20.dp,20.dp),tint= grey)})}
            )
            OutlinedTextField(
                value = appView.JData.cpassword.value,
                onValueChange = {appView.JData.cpassword.value = it },
                label = { Text("Confirm Password") },
                placeholder = { Text("Re-enter password") },
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Brown),
                visualTransformation = if(chide) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .size(388.dp, 60.dp),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {IconButton(onClick = {chide = !chide  },
                    content = {Icon(painter = painterResource(id = if (chide) R.drawable.baseline_remove_red_eye_24 else R.drawable.eyec), contentDescription = "eye icon",modifier=Modifier.size(20.dp,20.dp),tint= grey)})}
            )
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp), verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()){
                    Checkbox(checked = appView.JData.tick.value, onCheckedChange = {appView.JData.tick.value = it},modifier= Modifier.padding(0.dp))
                    Text("I accept the terms and condition",fontSize = 16.sp, fontFamily = regFont)
                }
                Text(text = appView.JData.error.value,color = Color.Red,fontSize = 16.sp,fontFamily = regFont)
            Column(verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally,modifier=Modifier.padding(top = 20.dp)) {
                Button(onClick = {valCheck = appView.validate()
                                 if (valCheck) navControl.navigate("Home Page")},modifier= Modifier
                    .size(388.dp, 50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = SeaGreen, contentColor = White26)) {
                    Text("Create Account",fontSize = 16.sp,fontFamily = medFont,textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { /*TODO*/ },modifier= Modifier
                    .size(388.dp, 50.dp),
                    shape = RoundedCornerShape(10.dp)) {
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
                Row(horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text("Already have an Account?",fontSize=16.sp, fontFamily = regFont)
                    TextButton(
                        onClick = {navControl.navigate("Log in")},
                        modifier = Modifier.padding(0.dp),
                        colors = ButtonDefaults.textButtonColors(contentColor = SeaGreen)
                    ) {
                        Text("Sign In", fontSize = 16.sp, fontFamily = medFont)

                    }
                }
            }

        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogIn(navControl: NavHostController,appView: JollyView) {
    var checkVal by remember{ mutableStateOf(false) }
    var visible by remember{ mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(40.dp),modifier=Modifier.padding(20.dp,32.dp)) {
        Row(horizontalArrangement = Arrangement.Start){
            Text("Welcome Back", fontSize = 24.sp, fontFamily = medFont)

        }
        Column(verticalArrangement =Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally ) {
            OutlinedTextField(
                value = appView.JData.email.value,
                onValueChange = { appView.JData.email.value = it },
                label = { Text("Email") },
                placeholder = { Text("Enter your email") },
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Brown),
                modifier = Modifier
                    .size(388.dp, 60.dp),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {Icon(painterResource(id = R.drawable.baseline_cancel_24),"icon of cancel ",Modifier.size(20.dp,20.dp),tint=grey)}
            )
            OutlinedTextField(
                value = appView.JData.password.value,
                onValueChange = {appView.JData.password.value = it },
                label = { Text("Password") },
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Brown),
                placeholder = { Text("Enter a password") },
                modifier = Modifier
                    .size(388.dp, 60.dp),
                visualTransformation = if(visible) VisualTransformation.None else PasswordVisualTransformation(),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {IconButton(onClick = {visible= !visible },
                    content = {Icon(painter = painterResource(id = if (visible) R.drawable.baseline_remove_red_eye_24 else R.drawable.eyec), contentDescription = "eye icon",modifier=Modifier.size(20.dp,20.dp),tint= grey)})}
            )
            Row(Modifier.fillMaxWidth(),Arrangement.spacedBy(60.dp),Alignment.CenterVertically){
                Row(horizontalArrangement = Arrangement.spacedBy(2.dp), verticalAlignment = Alignment.CenterVertically){
                    Checkbox(checked = appView.JData.tick.value, onCheckedChange = {appView.JData.tick.value = it},modifier= Modifier.padding(0.dp))
                    Text("Remember me",fontSize = 16.sp, fontFamily = regFont)
                }
                Text("Forgot Password?",fontSize=16.sp, fontFamily = medFont,color= SeaGreen)
            }

            Text(text = appView.JData.error.value,color = Color.Red,fontSize = 16.sp,fontFamily = regFont)
            Column(verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally,modifier=Modifier.padding(top = 20.dp)) {
                Button(onClick = {checkVal = appView.loginValidate()
                    if (checkVal) navControl.navigate("Home Page")},modifier= Modifier
                    .size(388.dp, 50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = SeaGreen, contentColor = White26)) {
                    Text("Sign In",fontSize = 16.sp,fontFamily = medFont,textAlign = TextAlign.Center)
                }
                OutlinedButton(onClick = { /*TODO*/ },modifier= Modifier
                    .size(388.dp, 50.dp),
                    shape = RoundedCornerShape(10.dp)) {
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
                            "Continue with Google",
                            fontSize = 16.sp,
                            fontFamily = medFont,
                            textAlign = TextAlign.Center,
                            color = Brown
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text("Already have an Account?",fontSize=16.sp, fontFamily = regFont)
                    TextButton(
                        onClick = { },
                        modifier = Modifier.padding(0.dp),
                        colors = ButtonDefaults.textButtonColors(contentColor = SeaGreen)
                    ) {
                        Text("Sign In", fontSize = 16.sp, fontFamily = medFont)

                    }
                }
            }

        }


    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomePage() {
    val scrollState = rememberScrollState()
    //LaunchedEffect(Unit) { scrollState.animateScrollTo(100) }
    Column(Modifier.padding(20.dp,20.dp), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Hello Ally", fontSize = 20.sp, fontFamily = medFont,color = Brown)
                Image(painter = painterResource(id = R.drawable.jollypic),contentDescription = "profile pic of user",modifier = Modifier
                    .size(40.dp, 40.dp)
                    .clip(CircleShape)
                    .clickable { })
            }
            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Start) {
                Text("Welcome Back", fontSize = 16.sp, fontFamily = regFont,color = Brown)
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Featured", fontSize = 20.sp, fontFamily = medFont)
            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Right arrow Icon" )
        }
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically,modifier = Modifier.horizontalScroll(scrollState)) {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(id = R.drawable.jabiboatmall), contentDescription = "picture of jabi boat club",modifier = Modifier
                        .size(170.dp, 230.dp)
                        .clip(RoundedCornerShape(8.dp))
                    )
                  Row(horizontalArrangement = Arrangement.Start){Text("Jabi Boat Club", fontSize = 20.sp, fontFamily = medFont)}
                    Row(horizontalArrangement = Arrangement.Start){ Text("Boat Club",fontSize = 16.sp, fontFamily = regFont)}
                    }
                Column(verticalArrangement = Arrangement.spacedBy(16.dp),horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.cilantro),
                        contentDescription = "picture of cilantro restaurant",
                        modifier = Modifier
                            .size(170.dp, 230.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Row(horizontalArrangement = Arrangement.Start) {
                        Text(
                            "Cilantro",
                            fontSize = 20.sp,
                            fontFamily = medFont
                        )
                    }
                    Row(horizontalArrangement = Arrangement.Start) {
                        Text(
                            "Restaurant",
                            fontSize = 16.sp,
                            fontFamily = regFont
                        )
                    }
                }
                Column(verticalArrangement = Arrangement.spacedBy(16.dp),horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.blucabara),
                        contentDescription = "picture of Blucabara",
                        modifier = Modifier
                            .size(170.dp, 230.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Row(horizontalArrangement = Arrangement.Start) {
                        Text(
                            "BluCabara",
                            fontSize = 20.sp,
                            fontFamily = medFont
                        )
                    }
                    Row(horizontalArrangement = Arrangement.Start) {
                        Text("Cafe and Restaurant", fontSize = 16.sp, fontFamily = regFont)
                    }
                }
                Column(verticalArrangement = Arrangement.spacedBy(16.dp),horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(id = R.drawable.housefortythree), contentDescription = "picture of house 43 restaurant",modifier = Modifier
                        .size(170.dp, 230.dp)
                        .clip(RoundedCornerShape(8.dp))
                    )
                    Row(horizontalArrangement = Arrangement.Start){Text("House 43", fontSize = 20.sp, fontFamily = medFont)}
                    Row(horizontalArrangement = Arrangement.Start){Text("Restaurant",fontSize = 16.sp, fontFamily = regFont)}
                }
        }

        Scaffold(bottomBar = {
            BottomAppBar(Modifier.fillMaxWidth(), containerColor = Color.Transparent) {
                NavigationBarItem(
                    selected = true,
                    onClick = { /*navControl.navigate("Home Page") */ },
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.home_icon
                            ),
                            contentDescription = "home icon",
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    },
                    label = { Text("Home") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = SeaGreen,
                        selectedTextColor = SeaGreen,
                        unselectedIconColor = Brown,
                        unselectedTextColor = Brown
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.search
                            ),
                            contentDescription = "Search Icon",
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    },
                    label = { Text("Search") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = SeaGreen,
                        selectedTextColor = SeaGreen,
                        unselectedIconColor = Brown,
                        unselectedTextColor = Brown
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.map_pin
                            ),
                            contentDescription = "Navigation Icon",
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    },
                    label = { Text("Navigation") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = SeaGreen,
                        selectedTextColor = SeaGreen,
                        unselectedIconColor = Brown,
                        unselectedTextColor = Brown
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.user
                            ),
                            contentDescription = "User Profile icon",
                            modifier = Modifier.size(24.dp, 24.dp)
                        )
                    },
                    label = { Text("Profile") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = SeaGreen,
                        selectedTextColor = SeaGreen,
                        unselectedIconColor = Brown,
                        unselectedTextColor = Brown
                    )
                )
            }
        }) { it }

    }

}
    @Composable
    fun MyHost(navControl: NavHostController, appView: JollyView) {
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
            composable("Sign Up") {
                SignUp(navControl, appView)
            }
            composable("Log in") {
                LogIn(navControl, appView)
            }
            composable("Home Page") {
                HomePage()
            }


        }
    }
