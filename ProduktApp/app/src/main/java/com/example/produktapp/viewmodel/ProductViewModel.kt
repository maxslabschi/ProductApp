package com.example.produktapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produktapp.data.model.Product
import com.example.produktapp.data.remote.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products
    val _productsAvailableState = mutableStateOf(false)
    //val productsAvailableState: State<Boolean> get()

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            delay(3000)
            try {
                val response = RetrofitInstance.api.getProducts()
                _products.value = response
                if(response.isNotEmpty())
                    _productsAvailableState.value = true
                else
                    _productsAvailableState.value = false
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun isProductsAvailable(): Boolean {
        return _products.value.isNotEmpty();
    }

    fun addProduct(product: Product) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.addProduct(product)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}