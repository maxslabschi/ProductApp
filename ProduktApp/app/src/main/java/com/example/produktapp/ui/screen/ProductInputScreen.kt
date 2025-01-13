package com.example.produktapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.produktapp.data.model.Product
import com.example.produktapp.viewmodel.ProductViewModel

@Composable
fun ProductInputScreen(
    productViewModel: ProductViewModel = viewModel(),
    onNavigateToList: () -> Unit
) {
    var id = 2;
    var name by remember { mutableStateOf("") }
    var unit by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Product Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = unit, onValueChange = { unit = it },
            label = { Text("Unit") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Button(
            onClick = {
                val parsedPrice = price.toDoubleOrNull()
                if (parsedPrice != null && name.isNotBlank() &&
                    unit.isNotBlank()
                ) {
                    productViewModel.addProduct(
                        Product(
                            id++, name, unit, parsedPrice
                        )
                    )
                    name = ""
                    unit = ""
                    price = ""
                    onNavigateToList()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Product and View List")
        }
    }
}