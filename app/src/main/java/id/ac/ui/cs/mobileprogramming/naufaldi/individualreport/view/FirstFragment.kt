package id.ac.ui.cs.mobileprogramming.naufaldi.individualreport.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.naufaldi.individualreport.R
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_one.view.*

class FirstFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_one, container, false) as ViewGroup
        rootView.btnSend.setOnClickListener {
            viewModel.setText(editText.text)
            val transaction = this.parentFragmentManager.beginTransaction()
            val fragmentTwo = SecondFragment()
            transaction.replace(R.id.frame, fragmentTwo)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(activity!!).get(SharedViewModel::class.java)
        viewModel.getText().observe(
            viewLifecycleOwner,
            Observer { charSequence -> editText!!.setText(charSequence) })
    }
}


