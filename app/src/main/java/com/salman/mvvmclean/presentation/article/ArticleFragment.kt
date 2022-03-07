package com.salman.mvvmclean.presentation.article

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.salman.mvvmclean.databinding.ArticlesBinding
import com.salman.mvvmclean.domain.model.Article
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ArticleFragment : Fragment() {
    private val viewModel by viewModels<ArticlesViewModel>()
    private lateinit var binding: ArticlesBinding

    private lateinit var state: ArticleState

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.articlesListRv.layoutManager = LinearLayoutManager(activity)
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {

                when (it) {
                    is ArticleState.Loading -> {
                        binding.articlesLoader.visibility = View.VISIBLE
                    }
                    is ArticleState.Success -> {
                        binding.articlesLoader.visibility = View.GONE
                        binding.articlesListRv.adapter =
                            ArticleAdapter(it.articles, requireActivity())
                    }
                    is ArticleState.Error -> {
                        binding.articlesLoader.visibility = View.GONE
                        Snackbar.make(binding.root, it.message, Snackbar.LENGTH_INDEFINITE)
                            .setAction("Dismiss") {}
                            .show()
                    }
                    else -> Unit
                }
            }
        }
    }
}