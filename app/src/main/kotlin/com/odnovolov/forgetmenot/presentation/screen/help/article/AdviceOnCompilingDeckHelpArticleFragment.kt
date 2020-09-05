package com.odnovolov.forgetmenot.presentation.screen.help.article

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.odnovolov.forgetmenot.R
import com.odnovolov.forgetmenot.presentation.common.base.BaseFragment
import com.odnovolov.forgetmenot.presentation.screen.help.HelpArticle.AdviceOnCompilingDeck
import com.odnovolov.forgetmenot.presentation.screen.help.HelpDiScope
import com.odnovolov.forgetmenot.presentation.screen.help.HelpEvent.ArticleOpened
import kotlinx.coroutines.launch

class AdviceOnCompilingDeckHelpArticleFragment : BaseFragment() {
    init {
        HelpDiScope.reopenIfClosed()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as TextView).run {
            setText(R.string.article_advice_on_compiling_deck)
            movementMethod = LinkMovementMethod.getInstance()
        }
    }

    override fun onResume() {
        super.onResume()
        viewCoroutineScope!!.launch {
            val diScope = HelpDiScope.getAsync() ?: return@launch
            diScope.controller.dispatch(ArticleOpened(AdviceOnCompilingDeck))
        }
    }
}