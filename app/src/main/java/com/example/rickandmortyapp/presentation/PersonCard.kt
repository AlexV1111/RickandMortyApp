package com.example.rickandmortyapp.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.domain.entity.Person

@Composable
fun PersonCard(person: Person) {
    Card(
        modifier = Modifier.height(270.dp),
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.dark_gray),
            contentColor = colorResource(R.color.mouse)
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(person.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .width(64.dp)
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(topStart = 16.dp)
                        ),
                    contentAlignment = Alignment.Center

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    if (person.status == "Alive") {
                                        Color.Green
                                    } else {
                                        Color.Red
                                    },
                                    shape = CircleShape
                                )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = person.status,
                            fontSize = 12.sp,
                        )
                    }
                }
            }
            Box(
                modifier = Modifier.fillMaxWidth()
                .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = person.name,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row {
                        Text(text = person.gender, fontSize = 12.sp)
                        Text(text = " | ", fontSize = 12.sp)
                        Text(text = person.species, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}
