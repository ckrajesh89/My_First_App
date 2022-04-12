package com.example.myfirstapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowInsetsAnimationCompat
import org.intellij.lang.annotations.JdkConstants


@Preview
@Composable
fun FirstScreen(){
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(15.dp)
    )
    {
        Column {
            FirstRow()
            SecondBox()
            myColumn()
            myRow()
            myBox()
            myRowEndStatement()
            myColumnEndStatement()
            mySpacer()
            myConstraintLayout()
            mySpacer()
            myRadioButton()
        }
    }    
}

//This will create text in Row based column
@Composable
fun FirstRow(){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
    ) {
        Column (
                verticalArrangement = Arrangement.Center
                ){
                Text(
                    text = "This is the first row Part1",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "This is the second row Part2",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ) 
        }
    }
}

//This will create boxes in row
@Composable
fun SecondBox(){
    Row (
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .size(width = 400.dp, height = 25.dp)

    ) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .size(width = 200.dp, height = 25.dp)
        ) {
            Text(
                text = "I'm Yellow Box",
                color = Color.Magenta,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Center)
            )
        }
        Box(
            modifier = Modifier
                .background(Color.Magenta)
                .size(width = 400.dp, height = 25.dp)
        ) {
            Text(
                text = "I'm Magenta Box",
                color = Color.Yellow,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Center)
            )
        }
    }
}

//This will create text in column based
@Composable
fun myColumn(){
    Column(
        horizontalAlignment = Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "My Column Front Line",
            color = Color.Blue,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "My Column Middle Line",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(CenterHorizontally)
        )
        Text(
            text = "My Column End Line",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(End)
        )
    }
}

//This will create text in a row
@Composable
fun myRow(){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
//            Text("My Row first line")
//            Text("                 ")
//            Text("My Row Second Line")
        Text(
            text = "My Row First Line",
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold
          )
        Text(
            text = "                   "
        )
        Text(
            text = "My Row Second Line",
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold
        )
    }
}

//This will create multiple boxes in a row
@Composable
fun myBox() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(120.dp, 25.dp)
                .background(Color.Red)
        ) {
            Text(
                text = "This is first Box",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterStart)
            )
        }
        Box(
            modifier = Modifier
                .size(120.dp, 25.dp)
                .background(Color.Blue)
        ) {
            Text(
                text = "This is Second Box",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterStart)
            )
        }
        Box(
            modifier = Modifier
                .size(120.dp, 25.dp)
                .background(Color.Green)
        ) {
            Text(
                text = "This is Third Box",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterStart)
            )
        }
    }
}

//This will add text at end of the row
@Composable
fun myRowEndStatement(){
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = "ROW BACK BUTTON",
            fontWeight = FontWeight.Bold
        )
    }
}

//This will add text at end the column
@Composable
fun myColumnEndStatement(){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = "COLUMN BACK BUTTON",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(End)
        )
    }
}

// This is to provide Space
@Composable
fun mySpacer(){
    Spacer(modifier = Modifier.size(20.dp))
}

//This will create multiple boxes perfectly matching with previous box
@Composable
fun myConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.size(width = 300.dp, height = 40.dp)
    )
    {
        val (redBox, blueBox, yellowBox) = createRefs()
        Box(
            modifier = Modifier
                .size(width = 95.dp, height = 40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {}
        ) {
            Text(
                text = "First Constraint Box",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Center)
            )
        }
        Box(
            modifier = Modifier
                .size(width = 95.dp, height = 40.dp)
                .background(Color.Blue)
                .constrainAs(blueBox) {
                    bottom.linkTo(redBox.bottom)
                    start.linkTo(redBox.end, 20.dp)
                }
            )
            {
                Text(
                    text = "Second Constraint Box",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Center)
                    )
            }
        Box(
            modifier = Modifier
                .size(width = 95.dp, height = 40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(blueBox.bottom)
                    start.linkTo(blueBox.end, 20.dp)
                }
            )
            {
                Text(
                    text = "Third Constraint Box",
                    fontWeight = FontWeight.Bold,
//                    style = MaterialTheme.typography.body2
                    modifier = Modifier
                        .align(Center)
                )
            }
    }
}

@Composable
fun myRadioButton() {
    val radioOptions = listOf("A", "B", "C")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

