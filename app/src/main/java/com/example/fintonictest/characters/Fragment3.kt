package com.example.fintonictest.characters


import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fintonictest.R
import kotlinx.android.synthetic.main.fragment_fragment3.*

/**
 * A simple [Fragment] subclass.
 */
class Fragment3(val abilities: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeface = Typeface.createFromAsset(resources.assets, "roboto_condensed.bold.ttf")

        textView5.typeface = typeface
        textView5.text = abilities
    }
}
