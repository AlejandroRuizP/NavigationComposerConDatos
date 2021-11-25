package com.example.navigationcomposercondatos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun SecondScreen(nombre: String, autor:String, año: Int, descrip: String, locali: String, imagen: String) {
   Column(
       modifier = Modifier
           .fillMaxWidth()
           .background(Color(242, 236, 235))
           .fillMaxSize()
   ) {

       Row(modifier = Modifier.background(color = Color(255, 250, 249))) {
           ImagenMonumento(imagen)
       }

       Espacio()
       Row(
       ) {
               Text(
                   text = nombre, color = Color(75, 66, 64),
                   fontSize = 30.sp, fontWeight = FontWeight.Bold,
                   modifier = Modifier
                       .padding(8.dp)
                       .background(Color(242, 236, 235))
               )
           Text(text = año.toString(),
              modifier  = Modifier.align(Alignment.Bottom)
                  .padding(8.dp)
           )
           }
       Text(
           text = locali, color = Color(75, 66, 64),
           fontSize = 15.sp, fontWeight = FontWeight.SemiBold,
                   modifier = Modifier
                       .padding(10.dp)
                       .fillMaxWidth()
                       .background(Color(242, 236, 235)))

       Text(
           text = descrip, color = Color(75, 66, 64),
           fontSize = 20.sp, fontWeight = FontWeight.SemiBold,
           modifier = Modifier
               .padding(10.dp)
               .fillMaxWidth()
               .background(Color(242, 236, 235)))


       Text(
           text = "Arquitecto/s: " + autor, color = Color(75, 66, 64),
           fontSize = 15.sp, fontWeight = FontWeight.SemiBold,
           modifier = Modifier
               .padding(10.dp)
               .fillMaxWidth()
               .background(Color(242, 236, 235)))






   }


}

@Composable
fun ImagenMonumento(imagen: String){

    Image(painter = rememberImagePainter(imagen),
        contentDescription = "imagen",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(400.dp)
            .clip(RoundedCornerShape(corner = CornerSize(15.dp))))
}


@Composable
fun Espacio (tamaño: Int = 20) {
    Spacer(modifier = Modifier.size(20.dp)
    )
}




