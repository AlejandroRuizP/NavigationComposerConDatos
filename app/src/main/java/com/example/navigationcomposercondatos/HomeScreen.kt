package com.example.navigationcomposercondatos

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.ejerciciolistasjetpackcompose.datos.Monumento
import com.example.ejerciciolistasjetpackcompose.datos.conjuntoMonumentos

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current


    LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.background(color = Color(59, 52, 50))
        )
        {
            items(conjuntoMonumentos.listaMonumentos) {monu ->
                Box(

                    modifier = Modifier.clickable {

                        navController.navigate(
                        Screen.Second.passMonu(
                            monu.nombre,monu.autor,monu.año,monu.descripcion,monu.localizacion, monu.image)
                        )

                    }
                ) {

                    MonumentoDiseño(monumento = monu)

                }


            }
        }

}


@Composable
fun MonumentoDiseño (monumento: Monumento) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
    ) {
        Row(
            modifier = Modifier
                .background(Color.Gray)

        ) {
            ImagenMonumento(monumento = monumento)

            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = monumento.nombre,
                        style = MaterialTheme.typography.h6
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = ("Localización: " + monumento.localizacion),
                        style = MaterialTheme.typography.caption
                    )

                }


            }
        }
    }

}

@Composable
fun ImagenMonumento(monumento: Monumento){

    Image(painter = rememberImagePainter(monumento.image),
        contentDescription = "imagen",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(15.dp))))
}

@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    SecondScreen(
        nombre = "Alhambra",
        autor = "Alejandro", año = 1974,
        descrip = "Es muy bonita", locali = "Granada",
        imagen = "https://fotografias.lasexta.com/clipping/cmsimages01/2020/07/20/94D41234-1D24-4B1D-8A30-D7D6A622D474/97.jpg?crop=4601,2588,x0,y238&width=1600&height=900&optimize=low&format=webply"
    )


}
