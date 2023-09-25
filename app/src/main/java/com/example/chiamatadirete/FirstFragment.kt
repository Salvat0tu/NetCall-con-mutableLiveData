package com.example.chiamatadirete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.chiamatadirete.network.JokeData
import com.example.chiamatadirete.network.JokeViewModel
import com.example.chiamatadirete.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val jokeViewModel: JokeViewModel by activityViewModels()

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

        binding.buttonFirst.setOnClickListener {
            jokeViewModel.getJoke()
        }
        jokeViewModel.result.observe(viewLifecycleOwner) {
            if (it != null) {
                setJokeText(it)
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