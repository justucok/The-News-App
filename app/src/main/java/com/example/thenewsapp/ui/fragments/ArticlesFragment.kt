package com.example.thenewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.thenewsapp.R
import com.example.thenewsapp.databinding.FragmentArticlesBinding
import com.example.thenewsapp.ui.NewsActivity
import com.example.thenewsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar


class ArticlesFragment : Fragment(R.layout.fragment_articles) {

    lateinit var newsViewModel: NewsViewModel
    val args: ArticlesFragmentArgs by navArgs()
    lateinit var binding: FragmentArticlesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticlesBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }
        }

        binding.fab.setOnClickListener{
            newsViewModel.addToFavorites(article)
            Snackbar.make(view, "Added to Favourites", Snackbar.LENGTH_SHORT).show()
        }
    }
}