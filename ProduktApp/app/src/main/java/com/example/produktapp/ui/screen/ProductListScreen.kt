package com.example.produktapp.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.produktapp.viewmodel.ProductViewModel
import kotlinx.coroutines.flow.forEach


@Composable
fun ProductListScreen(
    productViewModel: ProductViewModel = viewModel(),
    onNavigateBack: () -> Unit
) {
    productViewModel.fetchProducts()
    Log.d("TAG", ""+productViewModel.products)
    val products by productViewModel.products.collectAsState(initial = emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Product List", style = MaterialTheme.typography.headlineSmall)
        products.forEach { product ->
            Text("Name: ${product.name}, Unit: ${product.unit}, Price: ${product.price}")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onNavigateBack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Input")
        }
    }
}