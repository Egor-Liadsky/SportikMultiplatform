package utils

import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.stop
import kotlinx.browser.document
import org.w3c.dom.COMPLETE
import org.w3c.dom.DocumentReadyState


fun LifecycleRegistry.attachToDocument() {
    fun onVisibilityChanged() {
//        if (document.readyState == DocumentReadyState.COMPLETE) {
//            resume()
//        } else {
//            stop()
//        }
    }

    onVisibilityChanged()

//    document.addEventListener(type = "visibilitychange", callback = { onVisibilityChanged() })
}

