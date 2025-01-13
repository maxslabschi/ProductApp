package com.example.produktapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.produktapp.data.model.Product

@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = product.unit, style = MaterialTheme.typography.titleMedium)
            Text(
                text = product.unit + " | " + product.id,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}