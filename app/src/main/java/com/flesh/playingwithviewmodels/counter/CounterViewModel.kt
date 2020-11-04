package com.flesh.playingwithviewmodels.counter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.*
import com.flesh.playingwithviewmodels.R
import com.github.ajalt.timberkt.Timber.d

class CounterViewModel : ViewModel() {

    companion object {
        @BindingAdapter("android:text")
        @JvmStatic
        fun setScoreText(view: TextView, score: Int) {
            view.text = view.context.getString(R.string.score, score)
        }
    }

    private val _score: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        //Get initial value
        _score.value = getInitialScore()
    }

    val score: LiveData<Int>
        get() = _score

    private fun getInitialScore(): Int {
        d { "setting" }
        return 0
    }

    //Old way of updating
    @Deprecated("Use Data Binding instead.")
    fun getScoreObserver(owner: LifecycleOwner, uiUpdater: (String) -> Unit) {
        _score.observe(owner, Observer<Int> { score ->
            // update UI
            uiUpdater.invoke("Score: $score")
        })
    }

    fun addToScore() {
        val tempScore = score.value ?: 0
        val newScore = tempScore + 1
        d { "Clicked $newScore" }
        _score.value = newScore
    }

    fun subFromScore() {
        val tempScore = score.value ?: 0
        val newScore = tempScore - 1
        d { "Clicked $newScore" }
        _score.value = newScore
    }

    /**
     * Callback called when the ViewModel is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        d { "destroyed!" }
    }

}

