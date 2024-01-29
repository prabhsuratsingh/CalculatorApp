package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.Green
import com.example.calculator.ui.theme.Orange
import com.example.calculator.ui.theme.lightGrey

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 0.dp,
    onAction: (CalculatorAction) -> Unit
){
    Box (modifier= modifier
        .fillMaxSize()
        .background(Color.White)){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                //.padding(4.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ){
            Text(
                text = state.number1 + (state.operation?.symbol?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.Black,
                maxLines = 2
            )

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Clear)
                    },
                    colorText = Color.Red
                )

                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(Color.Red)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    }
                )

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    },
                    colorText = Green
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    },
                    colorText = Green
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    },
                    colorText = Green
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(1))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(2))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(3))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    },
                    colorText = Green
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)
                    },
                    colorText = Color.Cyan
                )

                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Color.Red)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)
                    }
                )
            }
        }
    }
}


@Preview
@Composable
fun DisplayCalculator() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    Calculator(state = viewModel.state, onAction = viewModel::onAction )
}






