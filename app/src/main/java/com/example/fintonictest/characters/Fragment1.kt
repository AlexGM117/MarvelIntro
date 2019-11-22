package com.example.fintonictest.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment1.*
import android.graphics.Typeface
import com.example.fintonictest.R
import com.example.fintonictest.domain.client.model.Superhero

/**
 * A simple [Fragment] subclass.
 */
class Fragment1(val marvelData: Superhero) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeface = Typeface.createFromAsset(resources.assets, "roboto_condensed.bold.ttf")

        textView2.typeface = typeface
        textView2.text = marvelData.name
        textView3.typeface = typeface
        textView3.text = getString(R.string.char_alias, marvelData.realName)
        textView4.typeface = typeface
        textView4.text = getString(R.string.char_height, marvelData.height)
    }
}
