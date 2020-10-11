package id.ac.ui.cs.mobileprogramming.naufaldi.individualreport.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.naufaldi.individualreport.R
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_two.*
import kotlinx.android.synthetic.main.fragment_two.view.*

class SecondFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_two, container, false)
//        inputText = arguments?.getString("inputText")
        viewModel = ViewModelProvider(activity!!).get(SharedViewModel::class.java)
        viewModel = ViewModelProvider(activity!!).get(SharedViewModel::class.java)
        viewModel.getText().observe(
            viewLifecycleOwner,
            Observer { charSequence -> outPutTextView!!.text = charSequence })
        return rootView
    }
}