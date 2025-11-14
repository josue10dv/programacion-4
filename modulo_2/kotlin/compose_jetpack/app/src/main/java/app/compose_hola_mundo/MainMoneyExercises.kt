package app.compose_hola_mundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class MoneyScreen(val route: String) {
    object Home : MoneyScreen("money_home")
    object Tip : MoneyScreen("tip")
    object Temperature : MoneyScreen("temperature")
}

class MainMoneyExercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MoneyNavApp() }
    }
}

@Composable
fun MoneyNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = nav,
                startDestination = MoneyScreen.Home.route
            ) {
                composable(MoneyScreen.Home.route) { MoneyHomeScreen(nav) }
                composable(MoneyScreen.Tip.route) { TipScreen(nav) }
                composable(MoneyScreen.Temperature.route) { TemperatureScreen(nav) }
            }
        }
    }
}

@Composable
fun MoneyHomeScreen(nav: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ejercicios diarios sobre dinero",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { nav.navigate(MoneyScreen.Tip.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculadora de propinas")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(MoneyScreen.Temperature.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Promedio 3 notas")
        }
    }
}

@Composable
fun TipScreen(nav: NavController) {
    var amount by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf("") }

    val tip = moneyTipAmount(amount, tipPercent)
    val total = moneyTotalWithTip(amount, tipPercent)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Propina de restaurante",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Total de la cuenta ($)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = tipPercent,
            onValueChange = { tipPercent = it },
            label = { Text("Propina (%)") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Propina = ${"%.2f".format(tip)} $")
        Text("Total = ${"%.2f".format(total)} $")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}

@Composable
fun TemperatureScreen(nav: NavController) {
    var nota_1 by remember { mutableStateOf("") }
    var nota_2 by remember { mutableStateOf("") }
    var nota_3 by remember { mutableStateOf("") }

    val avarage = avarageBetweenThreeGrades(nota_1,nota_2,nota_3)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Calculadora de promedios",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Nota #1", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = nota_1,
                    onValueChange = { nota_1 = it },
                    label = { Text("Sobre 10") }
                )
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Nota #2", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = nota_2,
                    onValueChange = { nota_2 = it },
                    label = { Text("Sobre 10") }
                )
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Nota #3", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = nota_3,
                    onValueChange = { nota_3 = it },
                    label = { Text("Sobre 10") }
                )
            }
        }

        Text("Resultado " + avarage, fontWeight = FontWeight.Bold)

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}

fun moneyTipAmount(amount: String, tipPercent: String): Double {
    val a = amount.replace(",", ".").toDoubleOrNull() ?: 0.0
    val t = tipPercent.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (a < 0.0 || t < 0.0) return 0.0
    return a * (t / 100.0)
}

fun moneyTotalWithTip(amount: String, tipPercent: String): Double {
    val a = amount.replace(",", ".").toDoubleOrNull() ?: 0.0
    val t = tipPercent.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (a < 0.0 || t < 0.0) return 0.0
    return a + moneyTipAmount(amount, tipPercent)
}

fun avarageBetweenThreeGrades(nota_1: String, nota_2: String, nota_3: String): Double {
    val n_1 = nota_1.replace(",", ".").toDoubleOrNull() ?: 0.0
    val n_2 = nota_2.replace(",", ".").toDoubleOrNull() ?: 0.0
    val n_3 = nota_3.replace(",", ".").toDoubleOrNull() ?: 0.0
    return (n_1 + n_2 + n_3) / 3
}

@Preview(showBackground = true)
@Composable
fun PreviewMoneyNav() {
    MoneyNavApp()
}