package com.maksewsha.shictionary.presentation.fragments

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.maksewsha.shictionary.R

class AboutFragment : Fragment(R.layout.fragment_about) {

    companion object{
        private val TELEGRAM_URL = "http://telegram.me/"
    }

    private lateinit var textViewAboutInfo: TextView
    private lateinit var textViewEmailInfo: TextView
    private lateinit var textViewTelegramInfo: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        textViewAboutInfo = view.findViewById(R.id.about_info_text_view)
        textViewEmailInfo = view.findViewById(R.id.mail_info_text_view)
        textViewTelegramInfo = view.findViewById(R.id.telegram_info_text_view)

        decorateInfoText()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun decorateInfoText() {
        val textInfoAbout = SpannableString(getString(R.string.about_info))

        val apiUrlIndexStart = textInfoAbout.indexOf(getString(R.string.api_url))
        val apiUrlIndexEnd = getString(R.string.api_url).length + apiUrlIndexStart

        val nameIndexStart = textInfoAbout.indexOf(getString(R.string.app_name))
        val nameIndexEnd = getString(R.string.app_name).length + nameIndexStart

        textInfoAbout.setSpan(
            UnderlineSpan(),
            apiUrlIndexStart,
            apiUrlIndexEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textInfoAbout.setSpan(
            StyleSpan(Typeface.BOLD),
            nameIndexStart,
            nameIndexEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val linkClickableSpan = object: ClickableSpan() {
            override fun onClick(p0: View) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.api_url))))
            }
        }

        textInfoAbout.setSpan(
            linkClickableSpan,
            apiUrlIndexStart,
            apiUrlIndexEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textViewAboutInfo.movementMethod = LinkMovementMethod.getInstance()
        textViewAboutInfo.text = textInfoAbout

        val textMail = SpannableString(getString(R.string.contact_info_email))
        val textTelegram = SpannableString(getString(R.string.contact_info_telegram))

        val textMailStartIndex = textMail.indexOf(getString(R.string.contact_info_email))
        val textMailEndIndex = textMailStartIndex + getString(R.string.contact_info_email).length
        val textTelegramStartIndex = textTelegram.indexOf(getString(R.string.contact_info_telegram))
        val textTelegramEndIndex = textTelegramStartIndex + getString(R.string.contact_info_telegram).length

        val mailClickableSpan = object: ClickableSpan(){
            override fun onClick(p0: View) {
                val intentMail = Intent(Intent.ACTION_VIEW)
                intentMail.data = Uri.parse("mailto:")
                intentMail.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.contact_info_email)))
                startActivity(intentMail)
            }
        }

        val telegramClickableSpan = object: ClickableSpan(){
            override fun onClick(p0: View) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("$TELEGRAM_URL${getString(R.string.contact_info_telegram)}")))
                Log.d("TAG", getString(R.string.contact_info_telegram))
            }
        }

        textMail.setSpan(
            mailClickableSpan,
            textMailStartIndex,
            textMailEndIndex,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textTelegram.setSpan(
            telegramClickableSpan,
            textTelegramStartIndex,
            textTelegramEndIndex,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textViewEmailInfo.movementMethod = LinkMovementMethod.getInstance()
        textViewTelegramInfo.movementMethod = LinkMovementMethod.getInstance()
        textViewEmailInfo.text = textMail
        textViewTelegramInfo.text = textTelegram
    }
}