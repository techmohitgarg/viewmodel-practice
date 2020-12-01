package com.example.sample_viewmodel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sample_viewmodel.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class ExampleFragment : Fragment() {

    private lateinit var binding: GameFragmentBinding

    private lateinit var viewModel: ExampleViewModel

    private lateinit var viewModelFactory: ExampleViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("GameFragment", "Called ViewModelProvider.get")

        // WITH OUT USING FACTORY METHOED
        //viewModel = ViewModelProvider(requireActivity()).get(ExampleViewModel::class.java)

        // USING FACTORY METHOD

        viewModelFactory = ExampleViewModelFactory()
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory).get(ExampleViewModel::class.java)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )


        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        updateScoreText()
        updateWordText()
        return binding.root

    }


    private fun onSkip() {
        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }

    private fun onCorrect() {
        viewModel.onCorrect()
        updateScoreText()
        updateWordText()
    }

    /** Methods for updating the UI **/
    private fun updateWordText() {
        binding.wordText.text = viewModel.word
    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }

}
