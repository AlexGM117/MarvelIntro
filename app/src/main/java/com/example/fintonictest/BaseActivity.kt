package com.example.fintonictest

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog

abstract class BaseActivity : AppCompatActivity(), BaseViewInt {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependencies(MarvelApplication().get(), MarvelApplication().getComponent())
    }

    protected abstract fun injectDependencies(application: MarvelApplication, component: ApplicationComponent)

    override fun showErrorDialog(string: String) {
        LottieAlertDialog.Builder(this, DialogTypes.TYPE_ERROR)
            .setDescription("Hola")
            .setDescription(string)
            .setPositiveText("Aceptar")
            .setPositiveButtonColor(Color.parseColor("#ED1A23"))
            .setPositiveTextColor(Color.parseColor("#FFFFFF"))
            .build()
            .show()
    }
}