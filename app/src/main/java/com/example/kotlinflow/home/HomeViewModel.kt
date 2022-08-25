package com.example.kotlinflow.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.lang.Exception

class HomeViewModel: ViewModel() {
//    val numberSeq = sequenceOf(1, 2, 3, 4, 5)
//    val numberSeq2 = numberSeq.map { it * 2 }

//    val firstFlow = flow {
//        for(i in 1..10) {
////            Log.d("hello", "I'm from flow builder")
//            delay(1000)
//            emit(i)
//        } // shows 1 to 10 after every 1s
//    }
////        .flowOn(Dispatchers.Default) // keep running this until the next wan is launch / all us launch

    fun countDownTimer(minute: Int, second: Int) = flow {
        var initialCount = minute * 60 + second
        var currentCount = initialCount
        emit(currentCount)

        while(currentCount > 0) {
            delay(1000)
            currentCount--
            emit(currentCount)

//            if(currentCount < 5) {
//                throw Exception("hello")
//            }
        }
    }

    fun getCountDownTimer(minute: Int, second: Int) = flow {
        countDownTimer(minute, second)
            .catch { emit(0) }
            .collect {
                emit(String.format("%02d:%02d", it/60, it%60))
            }
    }

//    val secondFlow = listOf(1, 2, 3, 4, 5).asFlow()
}