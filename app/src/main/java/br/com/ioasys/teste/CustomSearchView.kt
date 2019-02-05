package br.com.ioasys.teste

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.SearchView

/**
 * A Custom SearchView that allows one to submit an empty query.
 * This class is based on @Jens Klingenberg java class which can be found
 * at https://github.com/Foso/Notes/blob/master/Android/EmptySubmitSearchView.java.
 */
class CustomSearchView : SearchView {
    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun setOnQueryTextListener(listener: OnQueryTextListener?) {
        super.setOnQueryTextListener(listener)

        findViewById<SearchView.SearchAutoComplete>(androidx.appcompat.R.id.search_src_text)
            .setOnEditorActionListener { _, _, _ ->
                listener?.onQueryTextSubmit(query.toString())
                true
            }
    }
}