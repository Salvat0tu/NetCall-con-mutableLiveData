package com.example.chiamatadirete.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chiamatadirete.MyApplication
import com.example.chiamatadirete.data.JokeData
import com.example.chiamatadirete.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {


    private lateinit var jokeViewModel: JokeViewModel
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        jokeViewModel =
            (requireActivity().application as MyApplication).viewModelFactory.create(JokeViewModel::class.java)

        binding.buttonFirst.setOnClickListener {
            jokeViewModel.getJoke()
        }
    }
    private fun observeData(){
        jokeViewModel.result.observe(viewLifecycleOwner) { jokeData ->
            if (jokeData != null) {
                binding.textviewFirst.text = jokeData.punchline
                binding.textviewSecond.text = jokeData.setup
            }
        }
    }

private fun setJokeText(it: JokeData) {
    binding.textviewFirst.text = it.punchline
    binding.textviewSecond.text = it.setup
}

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
}