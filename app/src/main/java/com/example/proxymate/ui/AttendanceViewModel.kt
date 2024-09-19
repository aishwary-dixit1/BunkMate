package com.example.proxymate.ui

import androidx.lifecycle.ViewModel
import com.example.proxymate.model.cardDetails

class AttendanceViewModel: ViewModel() {
    var mockCardDetails:  MutableList<cardDetails> = mutableListOf(
        cardDetails("Algorithm", 8, 2),
        cardDetails("Python", 5, 10),
        cardDetails("Architecture", 7, 9),
        cardDetails("Computation", 5, 0),
        cardDetails("HS", 5, 0)
    )
}