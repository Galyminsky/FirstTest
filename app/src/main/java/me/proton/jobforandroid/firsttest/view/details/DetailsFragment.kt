package me.proton.jobforandroid.firsttest.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import me.proton.jobforandroid.firsttest.R
import me.proton.jobforandroid.firsttest.databinding.FragmentDetailsBinding
import me.proton.jobforandroid.firsttest.presenter.details.DetailsPresenter
import me.proton.jobforandroid.firsttest.presenter.details.PresenterDetailsContract
import java.util.Locale

class DetailsFragment : Fragment(), ViewDetailsContract {

    private var _detailsBinding: FragmentDetailsBinding? = null
    private val detailsBinding get() = _detailsBinding
    private val presenter: PresenterDetailsContract = DetailsPresenter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _detailsBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        return detailsBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
    }

    private fun setUI() {
        arguments?.let {
            val counter = it.getInt(TOTAL_COUNT_EXTRA, 0)
            presenter.setCounter(counter)
            setCountText(counter)
        }
        detailsBinding?.decrementButton?.setOnClickListener { presenter.onDecrement() }
        detailsBinding?.incrementButton?.setOnClickListener { presenter.onIncrement() }
    }

    override fun setCount(count: Int) {
        setCountText(count)
    }

    private fun setCountText(count: Int) {
        detailsBinding?.totalCountTextView?.text =
            String.format(Locale.getDefault(), getString(R.string.results_count), count)
    }

    companion object {

        private const val TOTAL_COUNT_EXTRA = "TOTAL_COUNT_EXTRA"

        @JvmStatic
        fun newInstance(counter: Int) =
            DetailsFragment().apply { arguments = bundleOf(TOTAL_COUNT_EXTRA to counter) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _detailsBinding = null
    }
}
