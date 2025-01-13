package com.example.produktapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.produktapp.ui.components.ProductItem
import com.example.produktapp.viewmodel.ProductViewModel

@Composable
fun ProductScreen(viewModel: ProductViewModel = androidx.lifecycle.viewmodel.compose.viewModel(), modifier: Modifier = Modifier) {
    val products = viewModel.products.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp).then(modifier),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(products.value) { product ->
            ProductItem(product)
        }
    }
}