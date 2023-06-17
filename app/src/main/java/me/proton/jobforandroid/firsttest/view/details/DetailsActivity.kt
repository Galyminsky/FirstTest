package me.proton.jobforandroid.firsttest.view.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.proton.jobforandroid.firsttest.R
import me.proton.jobforandroid.firsttest.databinding.ActivityDetailsBinding
import me.proton.jobforandroid.firsttest.presenter.details.DetailsPresenter
import me.proton.jobforandroid.firsttest.presenter.details.PresenterDetailsContract
import java.util.Locale

class DetailsActivity : AppCompatActivity(), ViewDetailsContract {

    private lateinit var binding: ActivityDetailsBinding

    private val presenter: PresenterDetailsContract = DetailsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
        presenter.onAttach()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    private fun setUI() {
        val count = intent.getIntExtra(TOTAL_COUNT_EXTRA, 0)
        presenter.setCounter(count)
        setCountText(count)
        binding.decrementButton.setOnClickListener { presenter.onDecrement() }
        binding.incrementButton.setOnClickListener { presenter.onIncrement() }
    }

    override fun setCount(count: Int) {
        setCountText(count)
    }

    private fun setCountText(count: Int) {
        binding.totalCountTextView.text =
            String.format(Locale.getDefault(), getString(R.string.results_count), count)
    }

    companion object {

        const val TOTAL_COUNT_EXTRA = "TOTAL_COUNT_EXTRA"

        fun getIntent(context: Context, totalCount: Int): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(TOTAL_COUNT_EXTRA, totalCount)
            }
        }
    }
}
