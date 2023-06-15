package me.proton.jobforandroid.firsttest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import me.proton.jobforandroid.firsttest.R
import me.proton.jobforandroid.firsttest.databinding.ActivityMainBinding
import me.proton.jobforandroid.firsttest.mvp.presenter.MainPresenter
import me.proton.jobforandroid.firsttest.mvp.view.MainView

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    private val emailValidator = EmailValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            emailInput.addTextChangedListener(emailValidator)

            saveButton.setOnClickListener {
                mainPresenter.saveButtonClicked(emailValidator.isValid, emailInput.text.toString(), repeatEmailInput.text.toString(), nameInput.text.toString())
            }
        }
    }

    private fun showError(emailInput: EditText, errorMessage: String){
        emailInput.error = errorMessage
        Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun viewOk() {
        Toast.makeText(this@MainActivity, getString(R.string.valid_email), Toast.LENGTH_SHORT).show()
    }

    override fun viewEmailsNotEqual() {
        showError(binding.repeatEmailInput, getString(R.string.emails_not_equal));
    }

    override fun viewInvalidEmail() {
        showError(binding.emailInput, getString(R.string.invalid_email))
    }

    override fun viewInvalidName() {
        showError(binding.nameInput, getString(R.string.invalid_name))
    }

}
